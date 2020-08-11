package JavaIO.nio;

/**
 * @ClassName NIOExample
 * @Description TODO
 * @Author
 * @Date 2020/8/11 18:19
 * @Version
 **/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO
 */
public class NIOExample {
    // 使用NIO快速复制文件的实例
    public static void fastCopy(String src , String dist) throws IOException{
        // 获取文件输入流
        FileInputStream fin = new FileInputStream(src);
        // 获取字节输入流的文件通道
        FileChannel fcin = fin.getChannel();
        // 获取文件输出流
        FileOutputStream fout = new FileOutputStream(dist);
        // 获取字节输出流的文件通道
        FileChannel fcout = fout.getChannel();
        // 创建字节缓冲区，并分配1024个字节
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true){
            // 从输入通道读取字节到缓冲区中
            int r = fcin.read(buffer);
            // read()返回读取的字节数，当为-1时，代表EOF。break直接跳出循环
            if (r == -1){
                break;
            }
            // 切换读写操作
            buffer.flip();
            // 把缓冲区中的内容写到文件中
            fcout.write(buffer);
            // 清空缓冲区
            buffer.clear();
        }
    }

    // 使用I/O复制文件
    public static void slowCopy(String src , String dist) throws IOException{
        FileInputStream fin = new FileInputStream(src);
        FileOutputStream fout = new FileOutputStream(dist);

        byte[] b = new byte[1024];
        int i;
        while ((i = fin.read(b,0,b.length)) != -1){
            fout.write(b,0,i);
        }

        fin.close();
        fout.close();
    }

    public static void main(String[] args) throws IOException {
        String src = "E:\\CS-Notes-PDF\\CS-Notes-PDF\\设计模式.pdf";
        String dist = "E:/Test.pdf";
        long fastStart = System.currentTimeMillis();
        fastCopy(src,dist);
        long fastEnd = System.currentTimeMillis();
        System.out.println("NIO程序运行时间： "+(fastEnd-fastStart)+"ms");

        long slowStart = System.currentTimeMillis();
        slowCopy(src,dist);
        long slowEnd = System.currentTimeMillis();
        System.out.println("I/O程序运行时间： "+(slowEnd-slowStart)+"ms");

        //比较了一下，NIO确实要比I/O快，一个接近两兆的文件，NIO快接近一倍
    }
}
