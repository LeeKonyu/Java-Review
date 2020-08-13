package JavaConcurrent.mutexSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SynchronizedExample
 * @Description TODO
 * @Author
 * @Date 2020/8/13 17:09
 * @Version
 **/

/**
 * synchronized
 */
public class SynchronizedExample {

    public void func1(){
        /**
         * 1.同步一个代码块
         *  它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
         */
        synchronized (this){
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 2.同步一个方法
     *  它和同步代码块一样，作用于同一个对象。
     */
    public synchronized void func2(){
        // ...
    }

    /**
     * 3.同步一个类
     *  作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
     */
    public void func3(){
        synchronized (SynchronizedExample.class){
            System.out.println();
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 4.同步一个静态方法
     *  作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
     */
    public synchronized static void func4() {
        // ...
    }


    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();

        /* 对于一下代码，使用ExecutorService执行了两个线程，由于调用的使同一个对象的同步代码块，因此这两个线程会进行同步，
           当一个线程进入同步语句块时，另一个线程必须等待。 */
        //executorService.execute(()->e1.fun1());
        //executorService.execute(()->e1.fun1());
        // 执行结果:0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9

        /* 对于以下代码，两个线程调用了不同对象的同步代码块，因此这两个线程就不需要同步。从输出结果可以看出，两个
           线程交叉执行。 */
        executorService.execute(()->e1.func1());
        executorService.execute(()->e2.func1());
        // 执行结果:0 1 0 2 3 4 5 6 7 1 2 3 8 9 4 5 6 7 8 9

        // 执行方法三，同步类
        executorService.execute(()->e1.func3());
        executorService.execute(()->e2.func3());
        // 执行结果:0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9

        executorService.shutdown();
    }
}
