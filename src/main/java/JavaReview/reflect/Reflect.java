package JavaReview.reflect;

/**
 * @ClassName Reflect
 * @Description TODO
 * @Author
 * @Date 2020/8/10 16:24
 * @Version
 **/

import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 */
public class Reflect {
    public Reflect(){}
    public Reflect(String s){
        System.out.println(s + "with parameter constructor...");
    }
    /**
     *  每个类中都有一个Class对象，包含了与类有关的信息。当编译一个新类时(javac)，会产生一个同名的.class文件，该文件内容保存着Class对象。
     *
     *  类加载相当于Class对象的加载，类在第一次使用时才动态加载到JVM中。也可以使用Class.forName("com.mysql.jdbc.Driver")这种方式来控制类的加载，
     *  该方法会返回一个Driver的Class对象。
     *
     *  反射可以提供 运行时 (注意不是编译时)的类信息，并且这个类可以在运行时才加载进来，甚至在编译时期该类的.class不存在也可以加载进来。
     *
     *  Class和java.lang.reflect一起对反射提供了支持，java.lang.reflect类库主要包含了一下三个类:
     *      Field : 可以使用get()和set()方法读取和修改Field对象关联的字段;
     *      Method : 可以使用invoke()方法调用与Method对象关联的方法;
     *      Constructor : 可以用Constructor创建新的对象。
     */
    public void print(){
        System.out.println("reflect executed successful...");
    }
    public static void main(String[] args) {
        try {
            Class r = Class.forName("JavaReview.reflect.Reflect");
            Method rMethod = r.getMethod("print");
            Object o = r.newInstance();
            rMethod.invoke(o);

            //getConstructor是获取公有的构造函数
            //getDeclaredConstructor是获取所有构造函数，包括私有、包权限、公有的。
            //由于Class对象是包外的，所以获取构造器要么该构造函数是public的，要么使用getDeclared...方法
            Constructor rConstructor = r.getConstructor(String.class);  //获取Reflect类带String参数的构造器
            Object objS = rConstructor.newInstance("String ");  //根据构造器创建实例
            System.out.println(objS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     *  反射的优点：
     *      可扩展性 ：应用程序可以利用全限定名创建可扩展对象的实例，来使用来自外部的用户自定义类
     *      类浏览器和可视化开发环境 ：一个类浏览器需要可以枚举类的成员。可视化开发环境（如 IDE）可以从利用反
     *                                 射中可用的类型信息中受益，以帮助程序员编写正确的代码。
     *      调试器和测试工具 ： 调试器需要能够检查一个类里的私有成员。测试工具可以利用反射来自动地调用类里定义
     *                          的可被发现的 API 定义，以确保一组测试中有较高的代码覆盖率。
     *  反射的缺点：
     *  尽管反射非常强大，但也不能滥用。如果一个功能可以不用反射完成，那么最好就不用。在我们使用反射技术时，下
     *  面几条内容应该牢记于心。
     *      性能开销 ：反射涉及了动态类型的解析，所以 JVM 无法对这些代码进行优化。因此，反射操作的效率要比那些
     *                 非反射操作低得多。我们应该避免在经常被执行的代码或对性能要求很高的程序中使用反射。
     *      安全限制 ：使用反射技术要求程序必须在一个没有安全限制的环境中运行。如果一个程序必须在有安全限制的
     *                 环境中运行，如 Applet，那么这就是个问题了。
     *      内部暴露 ：由于反射允许代码执行一些在正常情况下不被允许的操作（比如访问私有的属性和方法），所以使
     *                 用反射可能会导致意料之外的副作用，这可能导致代码功能失调并破坏可移植性。反射代码破坏了抽象性，因
     *                 此当平台发生改变的时候，代码的行为就有可能也随着变化。
     */
}
