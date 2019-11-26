package FirstBook;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPDemo {
    public static final  int PORT = 3000;
    private static final int DATA_LEN = 4096;
    private DatagramSocket socket = null;
    byte[] inBuff = new byte[DATA_LEN];
    private DatagramPacket inPackage = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outPackage;
    String[] books = new String[]{"A", "B", "C", "D"};
    public void init(){
        try{
            socket = new DatagramSocket(PORT);
//            等待1s，然后接受数据，最后发送数据
            for(int i=0; i<1000; i++){
                socket.receive(inPackage);
                System.out.println(inBuff==inPackage.getData());
                System.out.println(new String(inBuff, 0, inPackage.getLength()));
                byte[] sendData = books[i%4].getBytes();
                outPackage = new DatagramPacket(sendData, sendData.length, inPackage.getSocketAddress());
                socket.send(outPackage);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                socket.close();
            }
        }
    }

    public static void main(String[] args) {
        new UDPDemo().init();
    }
}
