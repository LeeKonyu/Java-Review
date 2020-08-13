package JavaConcurrent.basicThreadMechanism;

/**
 * @ClassName Executor
 * @Description TODO
 * @Author
 * @Date 2020/8/13 15:59
 * @Version
 **/

import JavaConcurrent.useThread.UseThreadWithRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor
 *  Executor管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰。
 *
 *  主要有三种Executor：
 *      CachedThreadPool：一个任务创建一个线程；
 *      FixedThreadPool：所有任务只能使用固定大小的线程；
 *      SingleThreadExecutor：相当于大小为1的FixedThreadPool。
 */
public class Executor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new UseThreadWithRunnable());
        }
        executorService.shutdown();
    }
}
