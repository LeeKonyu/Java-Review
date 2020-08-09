package JavaReview.extend;

/**
 * @ClassName Extends
 * @Description TODO
 * @Author
 * @Date 2020/8/9 18:33
 * @Version
 **/

public class Extends {
    /**
     * 抽象类与接口
     * 1.抽象类
     *      抽象类和抽象方法都是以abstract关键字进行声明。抽象类一般会包含抽象方法，抽象方法一定位于抽象类中。
     *      抽象类和普通类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类。
     */
    public abstract class AbstractClass{
        private int x;
        private int y;

        //abstract method can't have method body
        public abstract void fun1();
        public void fun2(){
            System.out.println("fun2...");
        }
    }
    public class AbstractClassExtend extends AbstractClass{
        //实现抽象方法
        public void fun1() {
            System.out.println("fun1...");
        }
    }
    //实例化其子类，进行向上转型
   AbstractClass aC = new AbstractClassExtend();

    /**
     * 2.接口
     * 接口时抽象类的眼神，在Java8之前，它可以看出是一个完全抽象的类，也就是说，它不能有任何方法的实现。
     * 从Java8开始，接口也可以拥有默认的方法实现，这是因为不支持默认方法的接口的维护成本太高了。在Java8
     * 之前，如果一个接口想要添加新的方法，那么要修改所有实现了该接口的类。
     *
     * 接口的成员(字段+方法)默认都是public的，并且不允许定义为private或者protected
     * 接口的字段默认都是static和final的
     *
     * 抽象类和接口的比较：
     * 从设计层面上看，抽象类提供了一种 IS-A 关系，那么就必须满足里式替换原则，即子类对象必须能够替换掉所
     * 有父类对象。而接口更像是一种 LIKE-A 关系，它只是提供一种方法实现契约，并不要求接口和实现接口的类具
     * 有 IS-A 关系。
     * 从使用上来看，一个类可以实现多个接口，但是不能继承多个抽象类。
     * 接口的字段只能是 static 和 final 类型的，而抽象类的字段没有这种限制。
     * 接口的成员只能是 public 的，而抽象类的成员可以有多种访问权限
     */

    public interface Interface{
        void fun1();
        default void fun2(){
            System.out.println("fun2...");
        }
        static final int x = 2;
    }

    public class InterfaceImpl implements Interface{

        @Override
        public void fun1() {
            System.out.println("fun1...");
        }
    }
    Interface iF = new InterfaceImpl();

    public static void main(String[] args) {
        System.out.println(Interface.x);
    }
    /**
     * super
     *  访问父类的构造函数：可以使用super函数访问父类的构造函数，从而委托父类完成一些初始化工作
     *  访问父类的成员：如果子类重写了父类的某个方法，可以通过使用super关键字来引用父类的方法实现。
     */
    public class SuperExample {
        protected int x;
        protected int y;
        public SuperExample(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void func() {
            System.out.println("SuperExample.func()");
        }
    }
    public class SuperExtendExample extends SuperExample{
        private int z;

        //这里必须写构造函数，以子类的构造函数来调用父类的构造函数，以此达到父类实例化的目的
        //原因：父类由于写了带参的构造函数，所以无参的构造函数自动消失。
        //      子类继承父类，在实例化的时候两个类一定都要被实例化，而且是父类先被实例化，子类再被实例化。
        //      那么由于父类不能自己调用构造函数，就需要子类通过super()方法调用父类的构造函数了，这也就父类就可以被实例化了。
        public SuperExtendExample(int x, int y,int z) {
            super(x, y);
            this.z = z;
        }

        public void func(){
            super.func();
            System.out.println("SuperExtendExample.func()");
        }
    }
    SuperExample se = new SuperExtendExample(1,2,3);
}
