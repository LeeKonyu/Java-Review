package JavaConcurrent.interrupt;

/**
 * @ClassName Interrupt
 * @Description TODO
 * @Author
 * @Date 2020/8/13 16:49
 * @Version
 **/

public class Interrupt {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                System.out.println("Hello");
                Thread.sleep(1000);
                System.out.println("World");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();
    }
}
