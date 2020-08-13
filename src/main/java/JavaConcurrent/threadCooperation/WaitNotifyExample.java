package JavaConcurrent.threadCooperation;

/**
 * @ClassName WaitNotifyExample
 * @Description TODO
 * @Author
 * @Date 2020/8/13 18:15
 * @Version
 **/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * wait() notify() notifyAll()
 *  调用wait()使得线程等待某个条件满足，线程在等待时会被挂起，当其他线程的运行使得这个条件满足时，其他线程会调用
 *  notify()或者notifyAll()来唤醒挂起的线程。
 *
 *  他们都属于Object的一部分，而不是属于Thread。
 *
 *  只能用在同步方法或者同步控制块中使用，否则会在运行时抛出IllegalMonitorStateException。
 *
 *  使用wait()挂起期间，线程会释放锁。这是因为，如果没有释放锁，那么其他线程就无法进入对象的同步方法或者同步控制块中，
 *  那么就无法执行notify()或者notifyAll()来唤醒挂起的线程，造成死锁。
 */
public class WaitNotifyExample {

    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        WaitNotifyExample e1 = new WaitNotifyExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->e1.after());
        executorService.execute(()->e1.before());

        executorService.shutdown();
    }
}
