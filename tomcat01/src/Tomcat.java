import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Tomcat {
    public static void log(String logs){
        System.out.println("Tomcat: "+logs);
    }
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(9092);
            log("Server start at 9092 port");
            Socket socket = ss.accept();

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String ret = br.readLine();
            while(ret!=""){
                log(ret);
                ret = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
