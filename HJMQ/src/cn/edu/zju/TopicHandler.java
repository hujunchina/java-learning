package cn.edu.zju;

import java.util.*;

public class TopicHandler{

    public static Set<String> getTopics() {
        return topics;
    }

    private static volatile Set<String> topics = new HashSet<String>();

    public static Map<String, Topic> getTopicMap() {
        return topicMap;
    }

    private static volatile Map<String, Topic> topicMap = new HashMap<String, Topic>();

    public static boolean hasTopic(String topicName){
        if(topics.contains(topicName)){
            return true;
        }else{
            return false;
        }
    }

    public static void addMap(String topicName, Topic topic){

        topicMap.put(topicName, topic);
    }

    public static Topic getTopic(String topicName){
        if(topics.contains(topicName)){
            return topicMap.get(topicName);
        }else{
            return null;
        }
    }

//    test
    public static void main(String[] args) {
        List<Topic> topics = new ArrayList<Topic>();
        Topic topic = new Topic();
        topic.setTopic("test");
        topic.addContent("tests");
//        TopicHandler.getTopics().add(topic.getTopic());
//        TopicHandler.addMap(topic.getTopic(), topic);
        if(TopicHandler.hasTopic(topic.getTopic())){
            topics.add(TopicHandler.getTopic(topic.getTopic()));
            System.out.println("Ok1");
        }else{
            System.out.println("failed");
        }
        if(Broker.hasTopic("test")){
            System.out.println("Ok1");
        }else{
            System.out.println("failed");
        }
    }
}
