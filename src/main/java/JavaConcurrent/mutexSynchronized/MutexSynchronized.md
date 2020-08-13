### 互斥同步
具体代码查看同目录下java文件
#### synchronized
是Java关键字，添加在方法、代码块等前面。
#### ReentrantLock
是java.util.concurrent (J.U.C) 包中的锁。

#### 比较
1. 锁的实现

synchronized是JVM实现的，而ReentrantLock是JDK实现的。

2. 性能

新版本Java对synchronized进行了很多优化，例如自旋锁等，synchronized 与 ReentrantLock大致相同。

3. 等待可中断

当持有锁的线程称其不释放锁的时候，正在等待的线程可以选择放弃等待，改为处理其他事情。

Reentrant可中断，而synchronized不行。

4. 公平锁

公平锁是指多个线程在等待同一个锁时，必须按照申请锁的时间顺序来依次获得锁。

5. 锁绑定多个条件

一个ReentrantLock可以同时绑定多个Condition对象。

#### 使用选择
除非需要使用ReentrantLock的高级功能，否则优先使用synchronized。这是因为synchronized是JVM实现的一种锁机制，
JVM原生地支持它，而ReentrantLock不是所有的JDK版本都支持。并且使用synchronized不用担心没有释放锁而导致死锁问题，
因为JVM会确保锁的释放。