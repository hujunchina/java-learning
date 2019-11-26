package demo01;

public class Sun extends Father {
//    编译看左边，运行看左边，因为变量没有重写，写的是方法体
//    重载，载的是参数列表，没有重写，就没有替换，什么类型什么值。
    int num = 2;
    public Sun(){
        System.out.println("Sun construct");
    }
    // 重写： 方法名和参数列表一样
    // 编译看左边，运行看右边
    public void say(){
        System.out.println("Sun method");
    }
    public void say(String name){
        System.out.println("Say "+name);
    }
}
