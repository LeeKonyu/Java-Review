package JavaIO.bytes;

/**
 * @ClassName ByteExample
 * @Description TODO
 * @Author
 * @Date 2020/8/10 18:37
 * @Version
 **/

import java.io.*;

/**
 * 字节操作
 */
public class ByteExample {
    //实现文件复制
    public static void copyFile(String src , String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        // read() 最多读取buffer.length个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读取到了eof ，即文件尾
        while ((cnt = in.read(buffer,0,buffer.length)) != -1){
            out.write(buffer,0,cnt);
        }

        in.close();
        out.close();

    }
}
