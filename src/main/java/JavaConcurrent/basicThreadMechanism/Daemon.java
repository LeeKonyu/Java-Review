package JavaConcurrent.basicThreadMechanism;

/**
 * @ClassName Daemon
 * @Description TODO
 * @Author
 * @Date 2020/8/13 16:05
 * @Version
 **/

import JavaConcurrent.useThread.UseThreadWithRunnable;

/**
 * Daemon
 *  守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。
 *  当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。
 *  main()属于非守护线程。
 *
 *  使用setDaemon()方法将一个线程设置为守护线程
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new UseThreadWithRunnable());
        thread.setDaemon(true);
    }
}
