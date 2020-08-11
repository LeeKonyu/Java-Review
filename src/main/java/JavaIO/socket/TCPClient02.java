package JavaIO.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName TCPClient02
 * @Description TODO
 * @Author
 * @Date 2020/8/11 18:10
 * @Version
 **/

public class TCPClient02 {
    public static void main(String[] args) {
        String sayHello = "Hello Server , I am client02 !";
        Socket socket = null;
        try {
            // 创建客户端套接字，使用主机的8890端口进行通信
            socket = new Socket(InetAddress.getLocalHost(), 8890);
            System.out.println("Connect to server...");
            // 向服务器端发送信息
            OutputStream os = socket.getOutputStream();
            os.write(sayHello.getBytes());
            // 关闭发送信息
            socket.shutdownOutput();
            // 读取服务器端发送来的信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Server said:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭客户端套接字
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
