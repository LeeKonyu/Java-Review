### NIO
> 新的输入/输出 (NIO) 库是在 JDK 1.4 中引入的，弥补了原来的 I/O 的不足，提供了高速的、面向块的 I/O。
#### 流与块
---
I/O与NIO最重要的区别是数据打包和传输的方式，I/O以流的方式处理数据，而NIO以块的方式处理数据。

面向流的I/O一次处理一个字节数据：一个输入流产生一个字节数据，一个输出流消费一个字节数据。为流式
数据创建过滤器非常容易，链接几个过滤器，以便每个过滤器只负责复杂处理机制的一部分。不利的一面是，
面向流的I/O通常相当慢。

面向块的I/O一次处理一个数据块，按块处理数据比按流处理数据要快得多。但是面向块的I/O缺少一些面向流
的。

I/O包和NIO已经很好地集成了，java.io.* 已经以 NIO 为基础重新实现了，所以现在它可以利用 NIO 的一些特性。例
如，java.io.* 包中的一些类包含以块的形式读写数据的方法，这使得即使在面向流的系统中，处理速度也会更快。

#### 通道与缓冲区
----
1. 通道

Channel是对原I/O包中的流的模拟，可以通过它读取和写入数据。

通道与流不同的处在于，流只能一个方向进行读或者写（一个流要么是输入流，要么是输出流），而通道
可以双向操作，支持只读、只写、同时读写的方式进行操作。

通道包括以下类型：
- FileChannel：从文件中读写数据;
- DatagramChannel：通过UDP读写网络中的数据;
- SocketChannel：通过TCP读写网络中的数据;
- ServerSocketChannel：可以监听新进来的TCP连接，对每一个新进来的连接都会创建一个SocketChannel
    - 与Sockets套接字中的操作差不多，通过```socket = serversocket.accept()```，作用是监听`端口`上的连接

2. 缓冲区

发送给一个通道(写)的所有数据都必须首先放到缓冲区中，同样地，从通道中读取的任何数据都要先读到
缓冲区中。也就是说，不会直接从通道进行读写数据，而是要先经过缓冲区。

缓冲区实质上是一个数组，但它不仅仅是一个数组。缓冲区提供了对数据的结构化访问，而且还可以跟踪系统的读/写进程。

缓冲区包括以下类型：
- ByteBuffer
- CharBuffer
- ShortBuffer
- IntBuffer
- FloatBuffer
- LongBuffer
- DoubleBuffer
> 缓冲区类无公有构造函数，要通过静态方法的方式创建实例

#### 缓冲区状态变量
----
- capacity：最大容量;
- position：当前已经读写的字节数;
- limit：还可以读写的字节数;

状态变量的改变过程举例：
1. 新建一个大小为 8 个字节的缓冲区，此时 position 为 0，而 limit = capacity = 8。capacity 变量不会改变，下面的讨
  论会忽略它
2. 从输入通道中读取 5 个字节数据写入缓冲区中，此时 position 为 5，limit 保持不变
3. 在将缓冲区的数据写到输出通道之前，需要先调用 flip() 方法，这个方法将 limit 设置为当前 position，并将
   position 设置为 0。
4. 从缓冲区中取 4 个字节到输出缓冲中，此时 position 设为 4。
5. 最后需要调用 clear() 方法来清空缓冲区，此时 position 和 limit 都被设置为最初位置。

#### 选择器
----
NIO常常被叫做非阻塞IO，主要是因为NIO在网络通信中的非阻塞特性被广泛使用。

NIO实现了IO多路复用中的Reactor模型，一个线程Thread使用一个选择器Selector通过轮询的方式去监听
多个通道Channel上的时间，从而让一个线程可以处理多个事件。

通过配置监听的通道Channel为非阻塞，那么当Channel上的IO时间还未到达时，就不会进入阻塞状态一直等待，
而是继续轮询其他Channel，找到IO时间已经到的Channel执行。

因为创建和切换线程的开销很大，因此使用一个线程来处理多个事件而不是一个线程处理一个时间，对于IO密集型的
应用具有很好地性能。

应该注意的是，只有套接字Channel才能配置为非阻塞，而FileChannel不能，为FileChannel配置非阻塞也没有意义。

#### 对比
----
NIO与普通I/O的区别主要有以下两点：
- NIO是非阻塞的;
- NIO是面向块，I/O面向流
