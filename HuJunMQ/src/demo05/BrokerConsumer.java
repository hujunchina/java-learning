package demo05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BrokerConsumer implements Runnable{
    public static int SUBSCRIBE_SERVICE_PORT = 8082;
    private final Socket socket;

    public BrokerConsumer(Socket socket){
        this.socket = socket;
    }

    private void log(String logs){
        System.out.println("BrokerConsumer: "+logs);
    }

    //    保存消息，目前存储在内存中，后期持久化优化到文件中
    public void msgHandler(Topic topic){
        TopicHandler.getTopics().add(topic.getTopic());
        TopicHandler.addMap(topic.getTopic(), topic);
    }

//    connect
//    private boolean connect(){
//        boolean result = false;
//        try{
//            socket = new Socket()
//        }
//    }

    private List<Topic> getTopics(Message msg){
        List<Topic> topics = new ArrayList<Topic>();
        Object object = DataUtils.deserialize(msg.getBody());
        List<Topic> topicList = (List<Topic>)object;
        if(topicList != null){
            for(Topic topic : topicList){
                if(Broker.hasTopic(topic.getTopic())){
                    topics.add(Broker.getTopic(topic.getTopic()));
                }else{
                    log("get not exist topic");
                }
            }
        }else{
            log("get topic list is null");
        }
        return topics;
    }

//
//    private void write(Message msg){
//
//    }

//    send what subscriber wanted topics
    private boolean send(List<Topic> topics) throws InterruptedException, IOException {
        boolean result = false;
        if(topics != null){
            Thread.sleep(100);
            Message response = Message.newResponseMessage();
            response.setReqHandlerType((short)2);
            response.setBody(DataUtils.serialize(topics));
            if(!socket.isConnected()){
                log("socket is not connect");
                return false;
            }
            try{
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.write(response.getBody());
                log("write to socket succeeded");
            }catch (IOException e){
                log("write to socket failed");
                e.printStackTrace();
            }
        }else{
            log("get null topic list");
            result = false;
        }
        return result;
    }

    @Override
    public void run() {
        try{
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            List<Topic> topicList = null;
            while(true){
                byte[] bytes = new byte[512];
                dis.read(bytes);
                Message msg = new Message();
                msg.setBody(bytes);
                topicList = getTopics(msg);
                send(topicList);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
