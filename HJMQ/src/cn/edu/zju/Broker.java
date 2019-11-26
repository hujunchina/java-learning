package cn.edu.zju;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Broker {
    private final static int MAX_SIZE = 100000;
    //保存消息的数据容器
    protected final static BlockingQueue<byte[]> messageQueue = new ArrayBlockingQueue<byte[]>(MAX_SIZE);
//    两个socket
    private ServerSocket publish_socket;
    private ServerSocket subscribe_socket;
//    存储注册订阅者

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    //    存储主题和信息
    private List<Topic> topicList = new ArrayList<Topic>();
    private void log(String logs){
        System.out.println("Broker: "+logs);
    }
    private static Set<String> topicName = new HashSet<String>();
    private static Map<String, Topic> topicMap = new HashMap<String, Topic>();

    public void publishSocket(){
        try{
            publish_socket = new ServerSocket(BrokerServer.PUBLISH_SERVICE_PORT);
            log("create publish socket server succeeded");
        } catch (IOException e) {
            log("create publish socket failed");
            e.printStackTrace();
        }
    }

    public void subscribeSocket(){
        try{
            subscribe_socket = new ServerSocket(BrokerServer.SUBSCRIBE_SERVICE_PORT);
            log("create subscribe socket server succeeded");
        } catch (IOException e) {
            log("create subscribe socket server failed");
            e.printStackTrace();
        }
    }

    //    保存消息，目前存储在内存中，后期持久化优化到文件中
    public static void msgHandler(List<Topic> topics){
        System.out.println("invoke");
        for(Topic topic: topics){
            TopicHandler.getTopics().add(topic.getTopic());
            topicName.add(topic.getTopic());
            System.out.println(topic.getTopic());
            TopicHandler.addMap(topic.getTopic(), topic);
            topicMap.put(topic.getTopic(), topic);
        }
    }

    public static boolean hasTopic(String name){
        if(topicName.contains(name)){
            return true;
        }else{
            return false;
        }
    }

    public static List<Topic> getTopicList(List<String> tnames){
        List<Topic> rtTopic = null;
        for(String name : tnames){
            if(hasTopic(name)){
                Topic topic = topicMap.get(name);
                rtTopic.add(topic);
            }
        }
        return rtTopic;
    }

    public static Topic getTopic(String name){
        return topicMap.get(name);
    }

    public static void setTopic(String name){
        Topic topic = new Topic();
        topic.setTopic(name);
        topicName.add(name);
        topicMap.put(name, topic);
    }

//    test run server
    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.publishSocket();
        broker.subscribeSocket();
        try{
            while(true){
//                 一个线程作为发布者socket server
                BrokerServer server = new BrokerServer(broker.publish_socket.accept());
                new Thread(server).start();
//                另一个线程作为订阅者 socket server
                BrokerConsumer consumerServer = new BrokerConsumer(broker.subscribe_socket.accept());
                new Thread(consumerServer).start();
            }
        }catch (IOException e){
            broker.log("socket server stopped");
            e.printStackTrace();
        }
    }
}
