package demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class IServer {
    public static ArrayList<Socket> socketArrayList = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30001);
        while(true){
            Socket s = ss.accept();
            socketArrayList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}
