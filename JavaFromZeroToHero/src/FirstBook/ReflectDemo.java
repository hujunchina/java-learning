package FirstBook;

import java.util.Set;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cl = null;
        cl = Class.forName(args[0]);
        Set<String> s = null;
        s=(Set<String>)cl.newInstance();

    }
}
