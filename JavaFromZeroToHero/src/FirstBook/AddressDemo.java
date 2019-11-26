package FirstBook;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressDemo {
    public static void main(String[] args) throws IOException {
//        out net
        InetAddress ip = InetAddress.getByName("www.zju.edu.cn");
        System.out.println("Bing is reachable : "+ ip.isReachable(3000));
        System.out.println(ip.getHostAddress());
//        local net
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local.getCanonicalHostName());
    }
}
