package JavaReview.exception;

/**
 * @ClassName ExceptionExample
 * @Description TODO
 * @Author
 * @Date 2020/8/10 17:36
 * @Version
 **/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 异常
 */
public class ExceptionExample {
    /**
     * Throwable 可以用来表示任何可以作为异常抛出的类，分为两种： Error 和 Exception。其中 Error 用来表示 JVM 无法
     * 处理的错误，Exception 分为两种：
     *      受检异常 ：需要用 try...catch... 语句捕获并进行处理，并且可以从异常中恢复；
     *      非受检异常 ：是程序运行时错误，检查不到的，例如除 0 会引发 Arithmetic Exception，此时程序崩溃并且无法恢复。
     */
    public static void main(String[] args) {
        // 这是受检异常
        try {
            FileInputStream in = new FileInputStream("file path");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 这是非受检异常
        int i = 1/0;
    }
}
