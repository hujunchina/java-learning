package IOStream.demo1;

import java.io.*;

public class FileCopyBuffered {
    public static void main(String[] args) {
        try{
            String sourcepath = "src/IOStream/demo1/s.txt";
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(sourcepath)
            );
            String distpath = "src/IOStream/demo1/d.txt";
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(distpath)
            );
            byte[] buffer = new byte[10];
            int len = bis.read(buffer);
            while(len != -1){
                bos.write(buffer);
                len = bis.read(buffer);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
