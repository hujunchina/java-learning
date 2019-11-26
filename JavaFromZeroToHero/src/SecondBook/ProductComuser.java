package SecondBook;

public class ProductComuser {
    static class ham{
        static Object box1 = new Object();
        static Object box2 = new Object();
        static int totalMaterial1 = 10;
        static int totalMaterial2 = 10;
        static int sales11 = 0;
        static int sales12 = 0;
        static int sales21 = 0;
        static int sales22 = 0;
        static int production1 = 0;
        static int production2 = 0;
    }

    static class hamake1 extends Thread{
        public void make(){
            synchronized (ham.box1){
                (ham.production1)++;
                int num1 = ham.production1-ham.sales11-ham.sales12;
                System.out.println("maker01: "+num1+" A hamburgers");
                try{
                    ham.box1.notify();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        public void run() {
            while (ham.production1 < ham.totalMaterial1) {
                make();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (ham.production1 == ham.totalMaterial1) {
                System.out.println("maker01: can not make any more!");
            }
        }
    }

    static class hamake2 extends Thread{
        public void make(){
            synchronized (ham.box2){
                (ham.production2)++;
                int num2 = ham.production2-ham.sales21-ham.sales22;
                System.out.println("maker02: "+num2+" B hamburgers");
                try{
                    ham.box2.notify();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        public void run() {
            while (ham.production2 < ham.totalMaterial2) {
                make();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (ham.production2 == ham.totalMaterial2) {
                System.out.println("maker02: can not make any more!");
            }
        }
    }
    static class assistant extends Thread{
        public void sell01(){
            if(ham.production1 == (ham.sales11+ham.sales12)){
                System.out.println("sell01: A hamburger is gone");
                ham.sales11 = 0;
                ham.sales12 = 0;
                ham.production1 = 0;
                try{
                    ham.box1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                if(ham.production1 > (ham.sales11+ham.sales12)){
                    ham.sales11++;
                    ham.sales12++;
                    System.out.println("sell01: A hamburger is come");
                }
            }
        }
        public void sell02(){
            if(ham.production2 == (ham.sales21+ham.sales22)){
                System.out.println("sell02: B hamburger is gone");
                ham.sales21 = 0;
                ham.sales22 = 0;
                ham.production2 = 0;
                try{
                    ham.box2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                if(ham.production2 > (ham.sales21+ham.sales22)){
                    ham.sales21++;
                    ham.sales22++;
                    System.out.println("sell02: B hamburger is come");
                }
            }
        }
        public void run(){
            while((ham.sales12 + ham.sales11) < ham.production1){
                try{
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sell01();
            }
            while((ham.sales21+ham.sales22) < ham.production2){
                try{
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sell02();
            }
            System.out.println("A hamburgers: "+(ham.production1-ham.sales11-ham.sales21));
            System.out.println("B hamburgers: "+(ham.production2-ham.sales21-ham.sales22));
        }
    }

    public static void main(String[] args) {
        hamake1 m1 = new hamake1();
        hamake2 m2 = new hamake2();
        assistant a1 = new assistant();
        assistant a2 = new assistant();
        m1.start();
        m2.start();
        a1.start();
        a2.start();
    }
}
