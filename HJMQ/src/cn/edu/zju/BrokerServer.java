package cn.edu.zju;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class BrokerServer implements Runnable{
    public static int PUBLISH_SERVICE_PORT = 8081;
    public static int SUBSCRIBE_SERVICE_PORT = 8082;
    private final Socket socket;

    // 单一的接受请求
    public BrokerServer(Socket socket) {
        this.socket = socket;
    }
//    日志记录
    private void log(String logs){
        System.out.println("BrokerServer: "+logs);
    }

//    保存消息，目前存储在内存中，后期持久化优化到文件中
    public void msgHandler(List<Topic> topics){
        for(Topic topic: topics){
            TopicHandler.getTopics().add(topic.getTopic());

            TopicHandler.addMap(topic.getTopic(), topic);
        }
    }

    @Override
    public void run() {
        try{
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while(true){
                byte[] bytes = new byte[512];
                dis.read(bytes);
                Broker.messageQueue.offer(bytes);
                Object object = DataUtils.deserialize(bytes);
                List<Topic> topicList = (List<Topic>)object;
                Broker.msgHandler(topicList);
                log("received msg");
                log(" "+Broker.messageQueue.size());
//                test

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
