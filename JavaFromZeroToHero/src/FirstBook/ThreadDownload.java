package FirstBook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ThreadDownload extends Thread {
    private final int BUFF_LEN = 64;
    private long start;
    private long stop;
    private InputStream is;
    private RandomAccessFile mm;
    public ThreadDownload(long start, long stop, InputStream is, RandomAccessFile mm){
        System.out.println(start+"--->"+stop);
        this.start = start;
        this.stop = stop;
        this.is = is;
        this.mm = mm;
    }


    @Override
    public void run() {
        try{
            is.skip(start);
            mm.seek(start);
            byte[] buff = new byte[BUFF_LEN];
            long contentLen = stop - start;
            long times = contentLen / BUFF_LEN +4;
            int hasRead = 0;
            for(int i=0; i<times; i++){
                hasRead = is.read(buff);
                if(hasRead < 0){
                    break;
                }
                mm.write(buff, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(is!=null){
                    is.close();
                }
                if(mm!=null){
                    mm.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final int DOWN_THREAD_NUM = 4;
        final String OUT_FILE_NAME = "down.jpg";
        InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
        RandomAccessFile[] mmArr = new RandomAccessFile[DOWN_THREAD_NUM];
        try{
            URL url = new URL("https://s2.ax1x.com/2019/07/10/ZcPsSI.png");
            isArr[0] = url.openStream();
            long fileLen = getFileLength(url);
            System.out.println("Net Source size: "+fileLen);
            mmArr[0] = new RandomAccessFile(OUT_FILE_NAME, "rw");
            for(int i=0; i<fileLen; i++){
                mmArr[0].write(0);
            }
            long numPerThread = fileLen / DOWN_THREAD_NUM;
            long left = fileLen % DOWN_THREAD_NUM;
            for(int i=0; i<DOWN_THREAD_NUM; i++){
                if( i != 0){
                    isArr[i] = url.openStream();
                    mmArr[i] = new RandomAccessFile(OUT_FILE_NAME, "rw");
                }
                if(i==DOWN_THREAD_NUM-1){
                    new ThreadDownload(i*numPerThread, (i+1)*numPerThread+left, isArr[i], mmArr[i]).start();
                }else{
                    new ThreadDownload(i*numPerThread, (i+1)*numPerThread, isArr[i], mmArr[i]).start();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getFileLength(URL url) throws IOException {
        URLConnection con = url.openConnection();
        return con.getContentLength();
    }
}
