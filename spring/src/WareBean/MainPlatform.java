package WareBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPlatform {
    public static void main(String[] args) throws PerformanceException {
//        Poem sonnet29 = new Sonnet29();
//        Performer duck = new DanceJuggle(15, sonnet29);
        ApplicationContext context = new ClassPathXmlApplicationContext("WareBean/warebeans.xml");
//        绑定初始和销毁方法
        Auditorium auditorium = (Auditorium) context.getBean("auditorium");
//        一个人演唱+背诵
        Performer duck = (Performer) context.getBean("danceJuggle");
        duck.perform();
//        一个人演唱+弹奏
        Performer kenny = (Performer) context.getBean("kenny");
        kenny.perform();
//        另一个人演唱+弹奏
        Performer pianor = (Performer) context.getBean("pianor");
        pianor.perform();
//        一个人演唱+弹奏两个乐器
        Performer oneManBand = (Performer) context.getBean("oneManBand");
        oneManBand.perform();
//        一个人弹奏不同乐器并演唱不同歌
        Performer oneManPlay = (Performer) context.getBean("oneManPlay");
        oneManPlay.perform();

        SpEL spEL = (SpEL) context.getBean("spel");
        System.out.println(spEL.toString());
    }
}
