package JavaReview.operation;

/**
 * @ClassName Operation
 * @Description TODO
 * @Author
 * @Date 2020/8/9 18:07
 * @Version
 **/


public class Operation {
    public static void main(String[] args) {
        /**
         * float与double
         * Java不能隐式执行向下转型，因为这会使得精度降低
         */
        //字面量属于double类型，不能直接将1.1直接复制给float变量，因为这是向下转型。
        //float f = 1.1;
        float f = 1.1f;

        /**
         * 隐式类型转换
         * 因为字面量1是int类型，它比short类型精度要高，因此不能隐式地将int类型向下转型成short类型
         */
        short s1 = 1;
        //s1 = s1 +1;
        //但是使用+=或者++运算符可以指刑隐式类型转换
        s1 += 1;
        s1++;
        //上面的语句相当于s1 + 1的计算结果进行了向下转型
        s1 = (short) (s1 + 1);

    }
}
