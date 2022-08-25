package org.pcchen.javase.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio服务端实现-多线程-https://www.jianshu.com/p/3131a8d57611
 *
 * @author: ceek
 * @create: 2022/8/25 9:47
 */
public class BIOServerMultiThread {
    public static void main(String[] args) throws IOException {
        // 1.创建服务端socket
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("服务端启动...");
        while (true){
            System.out.println("服务端接受客户端连接前");
            // 2.这里会阻塞
            Socket socket = serverSocket.accept();
            System.out.println("服务端接受客户端连接后");
            // 3.多线程处理方案
            new Thread(()->{
                try {
                    handel(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
    private static void handel(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("服务端读取客户端传入信息前");
        // 3.1这里会阻塞 读取客户端数据
        int read = socket.getInputStream().read(bytes);
        if(read != -1){
            System.out.println("服务端读取客户端传入信息，msg："+new String(bytes,0,read));
        }
        System.out.println("服务端向客户端写入信息");
        socket.getOutputStream().write("hello client".getBytes());
        socket.getOutputStream().flush();
        socket.close();
    }
}
