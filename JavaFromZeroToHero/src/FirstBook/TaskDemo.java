package FirstBook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class TaskDemo extends TimerTask {
    int i=0;
    @Override
    public void run() {
        while(i<100){
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            System.out.println(sdf.format(new Date()));
        }

    }

    public static void main(String[] args) {
        TaskDemo t = new TaskDemo();
        t.run();
        System.out.println("won't see");
    }
}
