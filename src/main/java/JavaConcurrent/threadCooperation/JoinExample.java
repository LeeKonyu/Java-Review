package JavaConcurrent.threadCooperation;

/**
 * @ClassName JoinExample
 * @Description TODO
 * @Author
 * @Date 2020/8/13 17:55
 * @Version
 **/

/**
 * join()
 *  在线程中调用另一个线程的join()方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
 *  对于以下代码，虽然b线程先启动，但是因为在b线程中调用了a线程的join()方法，b线程会等待a
 *  线程结束才继续执行，因此最后能够保证a线程的输出先于b线程的输出。
 */
public class JoinExample {

    private class A extends Thread{
        @Override
        public void run(){
            System.out.println("A");
        }
    }

    private class B extends Thread{
        private A a;
        B(A a){
            this.a = a;
        }
        @Override
        public void run(){
            try {
                // a调用join()方法，进行“插队”
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample j = new JoinExample();
        j.test();
    }
}
