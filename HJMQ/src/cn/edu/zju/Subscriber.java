package cn.edu.zju;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class Subscriber {

    private String host;
    private int port;
    private Socket socket;
    private Set<String> topics = new HashSet<String>();
    private Set<SubscriberImp> subscriberImpSet = new HashSet<SubscriberImp>();
    private static final Map<String, Integer> COUNTER = new HashMap<>();
    public Subscriber() {
        host = "127.0.0.1";
        port = 8082;
    }
    public Subscriber(String host, int port){
        this.host = host;
        this.port = port;
    }
    private void log(String logs){
        System.out.println("Subscriber: "+logs);
    }

    private boolean connect(){
        boolean result = false;
        try{
            socket = new Socket(host, port);
            result = true;
            log("create socket succeeded");
        } catch (IOException e) {
            log("create socket failed");
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
            result = true;
            log("topic send succeeded");
        } catch (IOException e) {
            log("write failed");
            e.printStackTrace();
        }
        return result;
    }

//  需要先发送消息主题，然后得到相关主题的消息！
    private Message read(Message msg){
        Message response = Message.newResponseMessage();
        if(!socket.isConnected()){
            connect();
        }
        try{
            if(write(msg)){
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                byte[] bytes = new byte[1024];
                dis.read(bytes);
                response.setBody(bytes);
                log("read succeeded");
            }else{
                log("topic send failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
            log("read failed");
        }
        return response;
    }

    private void addSubscriber(SubscriberImp subscriberImp){
        if(subscriberImp != null){
            if(!subscriberImpSet.contains(subscriberImp)){
                subscriberImpSet.add(subscriberImp);
                log("add a new subscriber");
            }
            topics.addAll(subscriberImp.subscribeTopic());
            List<Topic> topics = fetch(subscriberImp.subscribeTopic());
            log("add subscriber's topic");
            showResult(topics);
        }else{
            log("add subscriber failed");
        }
    }

    private void showResult(List<Topic> topics){
        if(topics != null){
            for(Topic topic : topics){
                log(topic.toString());
            }
        }else{
            log("there is no topic to show");
        }
    }

    private void stop() throws IOException {
        socket.close();
    }

    private List<Topic> fetch(String[] topics){
        return fetch(Arrays.asList(topics));
    }

    private List<Topic> fetch(List<String> topics){
        List<Topic> rtTopics = null;
        if(topics != null && topics.size()>0){
            List<Topic> topicList = new ArrayList<Topic>();
            for(String tp : topics){
                Topic topic = new Topic();
                topic.setTopic(tp);
                topicList.add(topic);
            }
            Message request = Message.newRequestMessage();
            request.setReqHandlerType((short)2);
            request.setBody(DataUtils.serialize(topicList));
            try{
                Message response = read(request);
                if(response.getBody() != null){
                    Object object = DataUtils.deserialize(response.getBody());
                    rtTopics = (List<Topic>)object;
                }
                log("fetch topics succeeded");
            }catch (RuntimeException e){
                log("fetch topics failed");
                e.printStackTrace();
            }
//            通知订阅者
            if(rtTopics != null){
                log("subscriber fetch message: "+rtTopics.toString());
                try{
                    for(Topic topic : rtTopics){
                        if(COUNTER.containsKey(topic.getTopic())){
                            if(topic.getReadCounter() > COUNTER.get(topic.getTopic())){
                                for(SubscriberImp s : subscriberImpSet){
                                    if(s.subscribeTopic()!=null &&
                                    s.subscribeTopic().contains(topic.getTopic())){
                                        s.notify(topic);
                                    }
                                }
                                COUNTER.put(topic.getTopic(), topic.getReadCounter());
                            }else if(topic.getReadCounter() < 0){
                                for(SubscriberImp s : subscriberImpSet){
                                    if(s.subscribeTopic()!=null &&
                                            s.subscribeTopic().contains(topic.getTopic())){
                                        s.notify(topic);
                                    }
                                }
                                COUNTER.put(topic.getTopic(), topic.getReadCounter());
                            }else{
                                log("has been spending, "+topic.toString());
                            }
                        }else{
                            for(SubscriberImp s : subscriberImpSet){
                                if(s.subscribeTopic()!=null &&
                                        s.subscribeTopic().contains(topic.getTopic())){
                                    s.notify(topic);
                                }
                            }
                            COUNTER.put(topic.getTopic(), topic.getReadCounter());
                        }
                    }
                }catch (RuntimeException e){
                    log("notify subscriber failed");
                    e.printStackTrace();
                }
            }
        }
        return rtTopics;
    }

//  test subscriber
    public static void main(String[] args)  {
        Subscriber subscriber = new Subscriber();
        subscriber.connect();

        subscriber.addSubscriber(new SubscriberImp() {
            @Override
            public List<String> subscribeTopic() {
                List<String> tps = new ArrayList<String>();
                tps.add("test");
                return tps;
            }

            @Override
            public void notify(Topic topic) {
                subscriber.log("consumer subscriber: "+topic.toString());
            }
        });

    }
}
