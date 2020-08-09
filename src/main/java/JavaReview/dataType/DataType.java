package JavaReview.dataType;

/**
 * @ClassName DataType
 * @Description TODO
 * @Author
 * @Date 2020/8/9 16:53
 * @Version
 **/

/**
 * 基本类型（类型/占用比特数/占用字节数）
 * byte/8/1
 * char/16/2
 * short/16/2
 * int/32/4
 * float/32/4
 * long/64/8
 * double/64/8
 * boolean/~
 *
 * boolean只有两个值: true、false，可以使用1bit来存储，但是具体大小没有明确规定。
 * JVM会在编译时期将boolean类型的数据转换为int，使用1来代表true，0表示false。JVM
 * 并不支持boolean数组，而是使用byte数组来表示int数组来表示。
 */
public class DataType {
    /**
     * 包装类型
     *      基本类型都有对应的包装类型，基本类型与其对应的包装类型之间的赋值使用自动装箱与拆箱完成。
     *      编译器会在装箱时自动调用valueOf()方法，查看缓存区中是否存在该值。
     */
    Integer x = 2;      // 装箱
    int y = x;          // 拆箱

    /**
     * 缓存池
     *      new Integer(123)与Integer.valueOf(123)的区别在于：
     *          new Integer(123)每次都会创建一个对象；
     *          Integer.valueOf(123)会使用缓存池中的对象，多次调用会得到一个对象的引用
     *
     *          valueOf()方法会判断当前值是否在缓存池中，如果在，就返回缓存池内容，若不在，创建该值。
     *                  public static Integer valueOf(int i) {
     *                      if (i >= IntegerCache.low && i <= IntegerCache.high)
     *                          return IntegerCache.cache[i + (-IntegerCache.low)];
     *                      return new Integer(i);
     *                  }
     *          在Java8中，Integer缓存池的大小默认是-128~127。
     *
     *          基本类型对应的缓冲池如下：
     *          boolean values true and false
     *          all byte values
     *          short values between -128 and 127
     *          int values between -128 and 127
     *          char in the range \u0000 to \u007F
     *          在使用这些基本类型对应的包装类型时，就可以直接使用缓冲池中的对象。
     */
    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);
    }
}
