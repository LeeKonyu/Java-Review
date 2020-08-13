package JavaConcurrent.basicThreadMechanism;

/**
 * @ClassName Yield
 * @Description TODO
 * @Author
 * @Date 2020/8/13 16:36
 * @Version
 **/

/**
 * yield()
 *  对静态方法Thread.yield()的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其他线程来执行。
 *  该方法只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其他线程可以运行。
 */
public class Yield {
    public void run() {
        Thread.yield();
    }
}
