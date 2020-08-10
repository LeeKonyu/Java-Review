package JavaIO.serializable;

/**
 * @ClassName SerializableExample
 * @Description TODO
 * @Author
 * @Date 2020/8/10 22:03
 * @Version
 **/

import java.io.*;

/**
 * 序列化
 *  序列化就是将一个对象转换成字节序列，方便存储和传输
 *      序列化：ObjectOutputStream.writeObject()
 *      反序列化：ObjectInputStream.readObject()
 *  不会对静态变量进行序列化，因为序列化只是保存对象的状态，静态变量属于类的状态。
 */
public class SerializableExample {
    /**
     * Serializable
     *  序列化的类需要实现Serializable接口，他只是一个标准，没有任何方法需要实现，但是不实现该接口就进行实例化会抛出异常
     */
    private static class A implements Serializable {
        private int x;
        private transient String y;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a1 = new A(123, "abc");
        String objectFile = "E:\\LocalGit\\Java-Review\\src\\main\\java\\JavaIO\\serializable\\file\\a1";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        Object object = objectInputStream.readObject();
        A a2 = (A) object;
        objectInputStream.close();
        System.out.println(a2 + "\nx = " + a2.x);
        System.out.println("y = " + a2.y);
    }
    /**
     * transient
     *  transient关键字可以使一些属性不会被序列化。
     *
     *  ArrayList中存储数据的数组elementData都是用transient修饰的，因为这个数组是动态扩展的，并不是所有的空间都被使用，
     *  因此就不需要所有的内容都被序列化。通过重写序列化和反序列化方法，可以使得只序列化数组中有内容的那部分数据
     *
     *      private transient Object[] elementData;
     */
}
