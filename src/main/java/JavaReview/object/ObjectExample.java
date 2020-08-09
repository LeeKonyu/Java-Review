package JavaReview.object;

/**
 * @ClassName ObjectExample
 * @Description TODO
 * @Author
 * @Date 2020/8/9 21:16
 * @Version
 **/

//Object 通用方法
public class ObjectExample{
    /**
     *    public native int hashCode()
     *     public boolean equals(Object obj)
     *     protected native Object clone() throws CloneNotSupportedException
     *     public String toString()
     *     public final native Class<?> getClass()
     *     protected void finalize() throws Throwable {}
     *     public final native void notify()
     *     public final native void notifyAll()
     *     public final native void wait(long timeout) throws InterruptedException
     *     public final void wait(long timeout, int nanos) throws InterruptedException
     *     public final void wait() throws InterruptedException
     */

    /**
     * equals()
     * 1.等价关系
     *      1.自反性
     *      x.equals(x);    //true
     *      2.对称性
     *      x.equals(y) == y.equals(x); //true
     *      3.传递性
     *      if(x.equals(y) && y.equals(z))
     *          x.equals(z);    //true
     *      4.一致性(多次调用结果相同)
     *      x.equals(y) == x.equals(y);    //true
     *      5.与null的比较
     *      对任意不是null的对象与null进行比较结果都为false
     *      x.equals(null)  //false
     *
     * 2.等价与相等
     *      对于基本类型，== 判断两个值是否相等，基本类型没有 equals() 方法。
     *      对于引用类型，== 判断两个变量是否引用同一个对象，而 equals() 判断引用的对象是否等价。
     */
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(a == b);               //true
        System.out.println(a.equals(b));        //true
        String aa = new String("aa");
        String bb = new String("aa");
        System.out.println(aa == bb);             //false
        System.out.println(aa.equals(bb));      //true
    }
    /**
     * 2.hashCode()
     *      hashCode() 返回散列值，而 equals() 是用来判断两个对象是否等价。等价的两个对象散列值一定相同，但是散列值相
     *      同的两个对象不一定等价。
     *      在覆盖 equals() 方法时应当总是覆盖 hashCode() 方法，保证等价的两个对象散列值也相等。
     *      HashMap的get()方法便是通过hashCode()和equals()方法来进行取值，这两种方法可以得到唯一的键值对。首先通过hashCode()方法找到存放数据的桶(链表)
     *      ，然后再通过equals()方法确定桶中的Key，如果Key相同，就把值取出来。
     *      意思很明确，就是先用hash函数确定在哪个位置，然后遍历这个位置上对应的链表，直到找到这个Key，然后返回value
     *
     *      这里有个地方很关键，那就是如何判判断相等我们看到这里是靠equal函数来判断的，equal函数是所有类都会从Object类处继承的函数，
     *      当我们在HashMap中存储我们自己定义的类的时候，默认的equal函数的行为可能不能符合我们的要求，所以需要重写。
     */
    class Student {
        String name;
        int age;
        //true表示男，false表示女
        boolean sex;

        //创建具有均匀性的散列函数，一般取31
        @Override
        public int hashCode() {
            int result = 17;
            result = 31*result+name.hashCode();
            result = 31*result+age;
            result = 31*result+(sex ? 0 : 1);
            return result;
        }
        //当类的类型与属性的值全部一样时，认为equals
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Student &&
                    this.name.equals(((Student)obj).name) &&
                    this.age ==  ((Student)obj).age &&
                    this.sex == ((Student)obj).sex;
        }
    }

    /**
     * 3.toString()
     *  默认返回 ToStringExample@4554617c 这种形式，其中 @ 后面的数值为散列码的无符号十六进制表示。
     */

    /**
     * 4.clone()
     *  使用 clone() 方法来拷贝一个对象即复杂又有风险，它会抛出异常，并且还需要类型转换。Ewective Java 书上讲到，
     *  最好不要去使用 clone()，可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象。
     */

    public class CloneConstructorExample {
        private int[] arr;
        public CloneConstructorExample() {
            arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }
        public CloneConstructorExample(CloneConstructorExample original) {
            arr = new int[original.arr.length];
            for (int i = 0; i < original.arr.length; i++) {
                arr[i] = original.arr[i];
            }
        }
        public void set(int index, int value) {
            arr[index] = value;
        }
        public int get(int index) {
            return arr[index];
        }
    }
    CloneConstructorExample e1 = new CloneConstructorExample();
    CloneConstructorExample e2 = new CloneConstructorExample(e1);
    //e1.set(2, 222);
    //System.out.println(e2.get(2)); // 2

}
