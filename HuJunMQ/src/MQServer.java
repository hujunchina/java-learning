/*
@author：胡军
@time： 2019年11月4日 15:03:53
@version：1.0.1
@describe：创建RPC服务器：
    创建连接
    创建通道
    设置通信结构
    开始发布（消费）
    RPC请求：
        获取文本信息
        确认消息
        向客户端响应
    RPC响应：
        获取消息
        获取时间
        输出消息
    服务器端初始化
    资源清理
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MQServer {
    protected ServerSocket ss;
    public MQServer() throws IOException {
        ss = new ServerSocket(30001);
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("localhost: "+ip.getHostName());
        System.out.println("\t\t:"+ip.getHostAddress());
    }

    public static void main(String[] args) throws IOException {
        MQServer mqs = new MQServer();
        while(true){
            Socket s = mqs.ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("Message from server");
            ps.close();
            s.close();
        }
    }
}
