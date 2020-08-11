package JavaIO.nio;

/**
 * @ClassName NIOSelectorExample
 * @Description TODO
 * @Author
 * @Date 2020/8/11 21:14
 * @Version
 **/

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO网络通信中的选择器
 * 可以通过一个线程处理多个事件(one thread -> one selector -> many channel)
 */
public class NIOSelectorExample {

    public static void main(String[] args) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();

        // 将通道注册到选择器上
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        // 将通道设置为非阻塞，以此达到一个线程处理多个事件的目的
        /**
         * 通道必须配置为非阻塞模式，否则使用选择器就没有任何意义了，因为如果通道在某个事件上被阻塞，那么服务器就
         * 不能响应其它事件，必须等待这个事件处理完毕才能去处理其它事件，显然这和选择器的作用背道而驰
         */

        ssChannel.configureBlocking(false);
        /**
         * 注册的具体事件
         *  SelectionKey.OP_CONNECT
         *  SelectionKey.OP_ACCEPT
         *  SelectionKey.OP_READ
         *  SelectionKey.OP_WRITE
         */
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 因为以此select()不能处理完所有事件，并且服务器端有可能需要一直监听事件，因此服务器端处理事件的代码一般会放在死循环里面
        while (true) {
            // 监听事件，他会监听到达的事件，一直阻塞直到至少有一个事件到达。与套接字中的accept()方法差不多
            int num = selector.select();

            // 获取到达的事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // ...
                } else if (key.isReadable()) {
                    // ...
                }
                keyIterator.remove();
            }
        }
    }

}
