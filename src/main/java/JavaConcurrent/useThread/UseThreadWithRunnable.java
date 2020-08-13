package JavaConcurrent.useThread;

/**
 * @ClassName UseThread
 * @Description TODO
 * @Author
 * @Date 2020/8/13 15:39
 * @Version
 **/

public class UseThreadWithRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("通过实现Runnable接口来使用线程");
    }

    public static void main(String[] args) {
        UseThreadWithRunnable utwr = new UseThreadWithRunnable();
        Thread t = new Thread(utwr);
        t.start();
    }
}
