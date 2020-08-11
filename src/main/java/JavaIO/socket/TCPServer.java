package JavaIO.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServer
 * @Description TODO
 * @Author
 * @Date 2020/8/11 17:37
 * @Version
 **/

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // 创建服务器端套接字，监听8890端口
            serverSocket = new ServerSocket(8890);

                // 监听绑定的端口上请求连接，这个监听会阻塞当前线程，直到连接建立或发生错误。
                socket = serverSocket.accept();
                System.out.println("Wait client " + socket.getRemoteSocketAddress());
                // 接受来自客户端的信息
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String line;
                System.out.println("Client said:");
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                OutputStream os = socket.getOutputStream();
                os.write("Hello Client!".getBytes());
                System.out.println("end");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket !=null){
                    socket.close();
                }
                if (serverSocket != null){
                    serverSocket.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
