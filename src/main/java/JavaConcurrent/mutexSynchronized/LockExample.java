package JavaConcurrent.mutexSynchronized;

/**
 * @ClassName LockExample
 * @Description TODO
 * @Author
 * @Date 2020/8/13 17:31
 * @Version
 **/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *  ReentrantLock 是java.util.concurrent (J.U.C) 包中的锁。
 */
public class LockExample {

    private Lock lock = new ReentrantLock();

    public void func1(){
        lock.lock();        // 上锁
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }finally {
            lock.unlock();  // 确保释放锁，避免发生死锁
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> lockExample.func1());
        executorService.execute(() -> lockExample.func1());

        executorService.shutdown();
    }
}
