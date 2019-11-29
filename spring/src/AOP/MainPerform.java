package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPerform {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("AOP/aops.xml");
        Perform p = (Perform) context.getBean("littleDot");
        p.play();
    }
}
