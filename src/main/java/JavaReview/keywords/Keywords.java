package JavaReview.keywords;

/**
 * @ClassName Keywords
 * @Description TODO
 * @Author
 * @Date 2020/8/10 15:51
 * @Version
 **/

/**
 * 关键字
 */
public class Keywords {
    /**
     * final
     *  1.数据
     *      声明数据是常量，可以是编译时常量，也可以是在运行时被初始化后不能被改变的常量。
     *      对于基本类型，final使数值不变
     *      对于引用类型，final使引用不可改变，但引用的对象可以改变
     *  2.方法
     *      声明方法不能被子类重写
     *      private方法隐式地被指定为final，如果在子类中定义的方法和基类中的一个private方法签名相同，
     *      此时子类的方法不是重写基类的方法，而是在子类中又自己定义了一个方法
     *  3.类
     *      声明final的类不能被继承
     */
    final int x = 1;
    // x = 2; // cannot assign value to final variable 'x'
    //final A y = new A();
    //y.a = 1;

    /**
     * static
     *  1.静态变量
     *      静态变量：又称为类变量，它是属于类的，类的所有实例都共享静态变量，可以直接通过类名来访问它。静态变量在内存中只存在一份。
     *      实例变量：每创建一个实例就会产生一个实例变量，它与该实例同生共死。
     *      只能访问所属类的静态字段和静态方法，方法中不能有 this 和 super 关键字（原因是静态变量和语句块已被初始化，而构造函数还没有，所以无法使用this和super关键字）。
     */
    public static class A {
        private int x;  //实例变量(成员变量)
        private static int y;   //静态变量
        public static void main(String[] args) {
            A a = new A();
            int x = a.x;
            int y = A.y;
            // int b = y; // Non-static field 'y' cannot be referenced from a static context
            // int b = this.y; // 'A.this' cannot be referenced from a static context
        }
    }
    /**
     *  2.静态方法
     *      静态方法在类加载的时候就存在了，它不依赖于任何实例。所以静态方法必须有实现，也就是说他不能是抽象方法。
     */
    public static abstract class B{
        public static void fun1() {

        }
        // public abstract static void func2(); // Illegal combination of modifiers: 'abstract' and 'static'
    }
    /**
     *  3.静态语句块
     *      静态语句块在类初始化时运行一次。
     *      public class A {
     *          static {
     *              System.out.println("123");
     *          }
     *          public static void main(String[] args) {
     *              A a1 = new A();
     *              A a2 = new A();
     *          }
     *      }
     *      结果：123
     */

    /**
     *  4.静态内部类
     *      非静态内部类依赖于外部类的实例，而静态内部类不需要。
     *      非静态内部类中不能有static方法或变量，原因是无法被外部类直接调用，如int y = B.A.x，由于A是非静态内部类，所以B.A处就出现错误了。
     *      静态内部类不能访问外部类的非静态的变量和方法。
     *      public class OuterClass {
     *          class InnerClass {
     *          }
     *
     *          static class StaticInnerClass {
     *          }
     *
     *          public static void main(String[] args) {
     *          // InnerClass innerClass = new InnerClass(); // 'OuterClass.this' cannot be reference from a static context
     *          OuterClass outerClass = new OuterClass();
     *          InnerClass innerClass = outerClass.new InnerClass();
     *          StaticInnerClass staticInnerClass = new StaticInnerClass();
     *          }
     *      }
     */

    /**
     *  6.初始化顺序
     *      静态变量和静态语句块优先于实例变量和普通语句块，静态变量和静态语句块的初始化顺序取决于它们在代码中的顺序，最后才是构造函数的初始化。
     *
     *      public static String staticField = "静态变量";
     *
     *      static {
     *          System.out.println("静态语句块");
     *      }
     *
     *      public String field = "实例变量";
     *
     *      {
     *          System.out.println("普通语句块");
     *      }
     *
     *      public InitialOrderTest() {
     *          System.out.println("构造函数");
     *      }
     *
     *      存在继承的情况下，初始化顺序为：
     *      父类（静态变量、静态语句块）
     *      子类（静态变量、静态语句块）
     *      父类（实例变量、普通语句块）
     *      父类（构造函数）
     *      子类（实例变量、普通语句块）
     *      子类（构造函数
     */

}
