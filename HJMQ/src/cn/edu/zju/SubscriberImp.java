package cn.edu.zju;

import java.util.List;

public interface SubscriberImp {

//    订阅的主题列表
    List<String> subscribeTopic();

//    通知
    void notify(Topic topic);

}
