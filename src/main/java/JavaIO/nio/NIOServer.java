package JavaIO.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName NIOServer
 * @Description TODO
 * @Author
 * @Date 2020/8/11 21:34
 * @Version
 **/

public class NIOServer {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(address);

        while (true){
            // 进行监听事件
            selector.select();
            // 获取到达的事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {

                    ServerSocketChannel ssC = (ServerSocketChannel) key.channel();

                    // 服务器会为每个新连接创建一个SocketChannel
                    SocketChannel sC = ssC.accept();
                    sC.configureBlocking(false);

                    // 这个新连接主要用于从客户端读取数据
                    sC.register(selector, SelectionKey.OP_READ);
                }
                else if (key.isReadable()){

                    SocketChannel sC = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(sC));
                    sC.close();
                }

                keyIterator.remove();
            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException{
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while (true){

            buffer.clear();
            int n = sChannel.read(buffer);
            if (n == -1) {
                break;
            }
            // 切换读写操作
            buffer.flip();

            int limit = buffer.limit();
            // 从缓冲区读出数据存在字符数组中
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);

            buffer.clear();
        }

        return data.toString();
    }
}
