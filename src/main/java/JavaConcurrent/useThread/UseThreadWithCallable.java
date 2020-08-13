package JavaConcurrent.useThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName UseThreadWithCallable
 * @Description TODO
 * @Author
 * @Date 2020/8/13 15:41
 * @Version
 **/

public class UseThreadWithCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseThreadWithCallable utwc = new UseThreadWithCallable();
        FutureTask<Integer> ft = new FutureTask<>(utwc);
        Thread t = new Thread(ft);
        t.start();
        System.out.println(ft.get());
    }
}
