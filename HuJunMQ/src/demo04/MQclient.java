package demo04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MQclient {
    private final static int SERVER_PORT = 9999;
    //生产消息
    public static void produce(String msg) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            out.println(msg);
            out.flush();
        }
    }
    //消费消息
    public static String consume() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            //先向消息队列发送字符串"CONSUME"表示消费
            out.println("CONSUME");
            out.flush();
            //再从消息队列中获取一条消息
            String msg = in.readLine();
            return  msg;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("请输入1或2选择写入还是取出:");
        System.out.println("1.写入消息  2.消费消息");
        int in;
        int i = 1;
        while(( in = new Scanner(System.in).nextInt())!=-1){
            if(in==1){//写入消息
                MQclient mqClient = new MQclient();
                mqClient.produce("Hello world-"+i);
                i++;
            }else if(in==2){
                MQclient mqClient = new MQclient();
                String msg = mqClient.consume();
                System.out.println("获取的消息是："+msg);
            }else{
                System.out.println("请输入正确的选项");
            }
            System.out.println("请输入1或2选择写入还是取出:");
            System.out.println("1.写入消息  2.消费消息");
        }
    }
}
