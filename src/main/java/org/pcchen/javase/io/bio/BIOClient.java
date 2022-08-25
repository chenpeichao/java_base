package org.pcchen.javase.io.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * bio客户端实现-https://www.jianshu.com/p/3131a8d57611
 *
 * @author: ceek
 * @create: 2022/8/25 9:28
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        // 1.创建连接绑定ip和端口
        Socket socket = new Socket("localhost", 9000);
        System.out.println("客户端开始向服务端写入消息");
        socket.getOutputStream().write("hello server".getBytes());
        socket.getOutputStream().flush();
        System.out.println("客户端开始向服务端写入消息完成");

        byte[] bytes = new byte[1024];
        // 2.这里会阻塞 读取服务端数据
        int read = socket.getInputStream().read(bytes);
        // 3.接收服务端回传的数据
        System.out.println("接收到服务端的数据:" + new String(bytes,0,read));
        socket.close();
    }
}
