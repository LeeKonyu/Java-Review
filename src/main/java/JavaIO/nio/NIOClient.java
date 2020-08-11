package JavaIO.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName NIOClient
 * @Description TODO
 * @Author
 * @Date 2020/8/11 21:55
 * @Version
 **/

public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        String s = "Hello World!";
        os.write(s.getBytes());
        os.close();
    }
}
