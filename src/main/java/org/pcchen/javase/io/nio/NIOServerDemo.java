package org.pcchen.javase.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * nio服务端-https://www.jianshu.com/p/3131a8d57611
 *
 * @author: ceek
 * @create: 2022/8/25 9:45
 */
public class NIOServerDemo {
    public static void main(String[] args) throws IOException {
        // 打开服务端通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 设置成非阻塞
        ssc.configureBlocking(false);
        // 绑定端口
        ssc.socket().bind(new InetSocketAddress(9000));
        // 打开多路复用器
        Selector selector = Selector.open();
        // 把ServerSocketChannel注册到selector上，并且selector对客户端accept连接感兴趣
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            System.out.println("等待事件发生。。");
            // 选择多路复用器里面的通道，如果客户端注册通道进去，则会阻塞
            int select = selector.select();
            System.out.println("有事件发生了。。");
            // 获取多路复用器里面的所有注册的通道key
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                // 获取某一个通道key
                SelectionKey key = it.next();
                // 删除当前可以，防止多次处理
                it.remove();
                handle(key);
            }
        }
    }

    private static void handle(SelectionKey key) throws IOException {
        // 验证当前通道属于什么事件
        if (key.isAcceptable()) { // 连接事件
            System.out.println("有客户端连接事件发生了。。");
            // 获取当前key所在的通道
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            // 接受客户端连接 此方法是阻塞的
            SocketChannel sc = ssc.accept();
            // 设置通道为非阻塞方式
            sc.configureBlocking(false);
            // 将通道注册到多路复用器上，并且注册事件是OP_READ时间
            sc.register(key.selector(), SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            System.out.println("有客户端数据可读事件发生了。。");
            SocketChannel sc = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len = sc.read(buffer);
            if (len != -1){
                System.out.println("读取到客户端发送的数据:" + new String(buffer.array(), 0, len));
            }
            ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
            sc.write(bufferToWrite);
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } else if (key.isWritable()) {
            SocketChannel sc = (SocketChannel) key.channel();
            System.out.println("write事件");
            key.interestOps(SelectionKey.OP_READ);
        }
    }

}
