package JavaIO.socket;

/**
 * @ClassName SocketExample
 * @Description TODO
 * @Author
 * @Date 2020/8/11 17:04
 * @Version
 **/

import jdk.net.Sockets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.URL;

/**
 * 网络操作
 */
public class SocketExample {
    /**
     * Java中的网络支持：
     *      InetAddress：用于表示网上的硬件资源，即IP地址
     *      URL：统一资源定位符
     *      Sockets：使用TCP协议实现网络通信
     *      Datagram：使用UDP协议实现网络通信
     */
    // InetAddress，没有公有的构造函数，只能通过静态方法来创建实例
    public void test() throws Exception{
        InetAddress.getByName("github.com");
        byte[] b = new byte[]{127, 0, 0, 1};
        InetAddress.getByAddress(b);
    // URL
        URL url = new URL("http://www.baidu.com");
        // 字节流
        InputStream is = url.openStream();
        // 字符流
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        // 提供缓存功能
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
    /**
     * Sockets
     *      ServerSocket：服务器端类
     *      Socket：客户端类
     *      服务器和客户端通过InputStream和OutputStream进行输入输出
     *
     * Datagram
     *      DatagramSocket：通信类
     *      DatagramPacket：数据包类
     */
}
