package JavaReview.string;

/**
 * @ClassName StringType
 * @Description TODO
 * @Author
 * @Date 2020/8/9 17:19
 * @Version
 **/

/**
 * String被声明为final，因此它不可被继承。
 * 在java8中，String内部使用char数组存储数据。
 *      public final class String
 *          implements java.io.Serializable, Comparable<String>, CharSequence {
 *              * The value is used for character storage. *
 *              private final char value[];
 *      }
 *
 * 在java9中，String内部使用byte数据存储字符串，并且使用coder属性来标识使用了哪种编码
 *
 * value数组被声明为final，这意味着value数组初始化之后就不能再引用其他数组。
 * 并且String内部没有改变value数组的方法，因此可以保证String不可变。
 * 不可变的好处：
 *      1.可以缓存hash值
 *          String的hash值经常被使用，例如String用作HashMap的key。不可变的特性可以使得hash值也是不可变的，因此只需计算一次
 *      2.String Pool的需要
 *          如果一个String对象已经被创建过了，那么就会从String Pool中取得引用。只有String是不可变的，才可能使用String Pool。
 *      3.安全性
 *          String经常作为参数，不可变性可以保证参数不可变。
 *      4.线程安全
 *          String不可变性天生具备线程安全，可以在多个线程中安全地使用。
 *
 *
 * String , StringBuffer and StringBuilder
 * 1.可变性
 *      String不可变
 *      StringBuffer，StringBuilder可变
 * 2.线程安全
 *      String不可变，因此是线程安全的
 *      StringBuffer可变，由于内部使用synchronized进行同步，所以也是线程安全的
 *      StringBuilder不是线程安全的
 *
 *
 */

public class StringType {
    public static void main(String[] args) {
        /**
         * String Pool
         * 字符串常量池（String Pool）保存着所有字符串字面量（literal strings），这些字面量在编译时期就确定。不仅如此，
         * 还可以使用 String 的 intern() 方法在运行过程中将字符串添加到 String Pool 中。
         * 当一个字符串调用 intern() 方法时，如果 String Pool 中已经存在一个字符串和该字符串值相等（使用 equals() 方法进
         * 行确定），那么就会返回 String Pool 中字符串的引用；否则，就会在 String Pool 中添加一个新的字符串，并返回这
         * 个新字符串的引用。
         * 下面示例中，s1 和 s2 采用 new String() 的方式新建了两个不同字符串，而 s3 和 s4 是通过 s1.intern() 方法取得一个字
         * 符串引用。intern() 首先把 s1 引用的字符串放到 String Pool 中，然后返回这个字符串引用。因此 s3 和 s4 引用的是同
         * 一个字符串。
         */
        //使用new来创建新的String对象，该操作实际上会创建两个对象，一个new出来的String对象，一个指向"aaa"字符串字面量的字符串字面量对象
        //s1和s2相比较的就是他们new出来的String对象，所以肯定不相同
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2); // false
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4); // true

        //若直接使用 字符串字面量 形式创建字符串，会自动将字符串放入String Pool
        //s5是将该字符串字面量放入String Pool中
        String s5 = "bbb";
        //s6的bbb是直接从String Pool中取出来的
        String s6 = "bbb";
        System.out.println(s5 == s6); // true

        /**
         * 在 Java 7 之前，String Pool 被放在运行时常量池中，它属于永久代。而在 Java 7，String Pool 被移到堆中。这是因为
         * 永久代的空间有限，在大量使用字符串的场景下会导致 OutOfMemoryError 错误。
         */

    }
}
