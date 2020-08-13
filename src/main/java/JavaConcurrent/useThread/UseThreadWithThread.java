package JavaConcurrent.useThread;

/**
 * @ClassName UseThreadWithThread
 * @Description TODO
 * @Author
 * @Date 2020/8/13 15:50
 * @Version
 **/

public class UseThreadWithThread extends Thread {

    @Override
    public void run(){
        System.out.println("继承Thread类的线程被使用了");
    }

    public static void main(String[] args) {
        UseThreadWithThread utwt = new UseThreadWithThread();
        utwt.start();
    }
}
