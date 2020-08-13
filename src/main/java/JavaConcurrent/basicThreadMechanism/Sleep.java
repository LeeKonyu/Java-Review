package JavaConcurrent.basicThreadMechanism;

/**
 * @ClassName Sleep
 * @Description TODO
 * @Author
 * @Date 2020/8/13 16:33
 * @Version
 **/

/**
 * sleep()
 *  Thread.sleep(millisecond)方法会休眠当前正在执行的线程,millisecond单位是毫秒。
 *  sleep()可能会抛出InterruptedException，因为异常不能跨线程传播回main()方法中，因此必须在本地进行处理。线程中抛出的其他异常也同样需要在本地进行处理。
 */
public class Sleep {
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
