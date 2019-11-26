/*
@author：胡军
@time： 2019年11月4日 15:03:53
@version：1.0.1
@describe：创建RPC客户端：
    发送RPC请求
    添加请求属性
    等待RPC回应
    调用RPC服务器

 */

import java.io.*;
import java.net.Socket;

public class MQClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 30001);
        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        // 普通的stream只能一个一个读，只有带上缓存，才能一行一行的读
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.readLine());
    }
}
