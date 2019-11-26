import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class browser {
    private static void log(String logs){
        System.out.println("Browser: "+logs);
    }
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 9090);
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter pw = new PrintWriter(osw, true);
//
//            200: only using GET and HOST !
            pw.println("GET /hujun.html HTTP/1.1");
            //pw.println("Accept: */*");
            //pw.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
            pw.println("Host: 127.0.0.1:9090");
            pw.println("");
            Thread.sleep(100);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String ret = br.readLine();
            while(ret!=null){
                log(ret);
                ret = br.readLine();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
