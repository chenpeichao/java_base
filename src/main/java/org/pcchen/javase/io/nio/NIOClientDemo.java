package org.pcchen.javase.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * nio客户端-https://www.jianshu.com/p/3131a8d57611
 *
 * @author: ceek
 * @create: 2022/8/25 9:49
 */
public class NIOClientDemo {
    private Selector selector;
    public static void main(String[] args) throws IOException {
        NIOClientDemo nioClientDemo = new NIOClientDemo();
        // 初始化客户端
        nioClientDemo.initClient("localhost",9000);
        // 客户端进行对应操作
        nioClientDemo.connect();
    }
    /**
     * 初始化客户端
     * @param ip
     * @param port
     * @throws IOException
     */
    private  void initClient(String ip,int port) throws IOException {
        // 获取socket通道
        SocketChannel socketChannel = SocketChannel.open();
        // 配置非阻塞
        socketChannel.configureBlocking(false);
        // 打开多路复用器
        this.selector = Selector.open();
        // 连接服务端 其实改方法并没有实现连接，
        // 需要在listen()方法中调用channel.finishConnect();才能完成连接
        socketChannel.connect(new InetSocketAddress(ip,port));
        // 将socket注册到多路复用器，事件为SelectionKey.OP_CONNECT事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }
    private void connect() throws IOException {
        while (true){
            // 监听多路复用器里面是否存在需要处理的channel 这里是阻塞的
            selector.select();
            // 获取多路复用器中的channel对应的key
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                // 获取SelectionKey
                SelectionKey key = iterator.next();
                // 获取到之后把当前可以删除，防止重复获取
                iterator.remove();
                // 验证SelectionKey对应的事件
                if(key.isConnectable()){
                    // 获取通道
                    SocketChannel channel = (SocketChannel) key.channel();
                    if(channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    // 配置成非阻塞方式
                    channel.configureBlocking(false);
                    // 写入缓冲流
                    ByteBuffer wrap = ByteBuffer.wrap("Hello server".getBytes());
                    // 向服务端写入信息
                    channel.write(wrap);
                    // 把当前通道注册到多路复用器中，并且注册事件是OP_READ事件
                    channel.register(selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    read(key);
                }else if(key.isWritable()){
                    System.out.println("客户端开始写事件");
                }

            }
        }
    }
    /**
     * 进行读消息
     * @param key
     * @throws IOException
     */
    private void read(SelectionKey key) throws IOException {
        // 获取通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 设置缓存流一次读取的大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 读取消息
        int len = channel.read(buffer);
        if(len != -1){
            System.out.println("客户端收到消息：" + new String(buffer.array(),0,len)) ;
        }
    }
}
