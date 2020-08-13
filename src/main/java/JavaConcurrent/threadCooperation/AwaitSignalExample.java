package JavaConcurrent.threadCooperation;

/**
 * @ClassName AwaitSignalExample
 * @Description TODO
 * @Author
 * @Date 2020/8/13 18:50
 * @Version
 **/

import JavaReview.keywords.Keywords;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await() signal() signalAll()
 *  java.util.concurrent类库中提供了Condition类来实现线程之间的协调，可以在Condition上调用
 *  await()方法使线程等待，其他线程调用signal()和signalAll()方法唤醒等待的线程。
 *
 *  相比于wait()这种等待方式，await()可以指定等待的条件，因此更加灵活。
 *
 *  使用Lock来获取一个Condition对象
 */
public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before(){
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void after(){
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        AwaitSignalExample example = new AwaitSignalExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());

        executorService.shutdown();
    }
}
