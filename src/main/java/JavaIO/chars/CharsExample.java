package JavaIO.chars;

/**
 * @ClassName CharsExample
 * @Description TODO
 * @Author
 * @Date 2020/8/10 19:39
 * @Version
 **/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 字符操作
 */
public class CharsExample {
    public static void main(String[] args) throws Exception {
        /**
         * String的编码方式
         *  String 可以看成一个字符序列，可以指定一个编码方式将它编码为字节序列，也可以指定一个编码方式将一个字节序
         *  列解码为 String。
         */
        String str1 = "中文";                                        //一个中文使用UTF-16be的编码格式占用两个字节，刚好可以用一个char来表示
        byte[] bytes = str1.getBytes("UTF-8");          //编码成UTF-8,由原来的4个字节变为6个字节
        String str2 = new String(bytes, "UTF-8");       //将UTF-8格式的字节进行解码
        System.out.println(str2);
    }
    /**
     * Reader与Writer
     *  不管是磁盘还是网络传输，最小的存储单元都是字节，而不是字符。但是在程序中操作的通常是字符形式的数据，
     *  因此需要提供对字符进行操作的方法。
     *      InputStreamReader 实现从字节流解码成字符流；
     *      OutputStreamWriter 实现字符流编码成为字节流
     */
    String filePath = "";
    public static void readFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }
}
