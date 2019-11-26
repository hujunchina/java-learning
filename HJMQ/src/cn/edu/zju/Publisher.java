package cn.edu.zju;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Publisher {
    private Socket socket;
    private PrintStream ps = null;
    private String host;
    private int port;

    public Publisher(){
        host = "127.0.0.1";
        port = 8081;
    }
    public Publisher(String host, int port){
        this.host = host;
        this.port = port;
    }

    private void log(String logs){
        System.out.println("Publisher: "+logs);
    }
    private boolean connect(){
        boolean result = false;
        try{
            socket = new Socket(host, port);
            log("connect success");
            result = true;
        }catch (IOException e){
            log("connect failed");
            e.printStackTrace();
        }
        return result;
    }
    private boolean write(Message msg){
        boolean result = false;
        if(!socket.isConnected()){
            result = connect();
        }
        try{
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.write(msg.getBody());
        } catch (IOException e) {
            log("write failed");
            e.printStackTrace();
        }
        return result;
    }
    private void stop() throws IOException {
        socket.close();
    }

//    每次发送一个主题
    public boolean send(List<Topic> topics) throws InterruptedException {
        boolean result = false;
//        把主题做消息发送
        Thread.sleep(100);
        Message request = Message.newRequestMessage();
        request.setReqHandlerType((short)1);
        request.setBody(DataUtils.serialize(topics));
        if(!socket.isConnected()){
            result = connect();
        }
        result = write(request);
        log("send succeeded");
        return result;
    }

//    test  publisher
    public static void main(String[] args) throws InterruptedException {
        Publisher publisher = new Publisher();
        publisher.connect();
        for(int i=0; i<10; i++){
            List<Topic> list = new ArrayList<Topic>();
            Topic topic = new Topic();
            topic.setTopic("test");
            topic.addContent("content: "+i);
            list.add(topic);
            publisher.send(list);
        }
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            Message msg = new Message();
            msg.setBody(DataUtils.serialize(line));
            publisher.write(msg);
        }
    }
}
