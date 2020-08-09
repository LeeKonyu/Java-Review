package ThinkingInOOP.threeMainFeatures.多态;

/**
 * @ClassName Instrument
 * @Description TODO
 * @Author
 * @Date 2020/8/9 16:16
 * @Version
 **/

/**
 * 下面的代码中，乐器类有两个子类：wind和percussion，他们都覆盖了父类的play()方法，并且在main()方法中使用父类Instrument
 * 来引用Wind和Percussion对象。在Instrument引用调用play()方法时，会执行实际引用对象所在类的play()方法，而不是Instrument
 * 类的方法
 *
 * 多态分为两种：1.编译时多态（多指方法的重载）
 *               2.运行时多态（三个条件）
 *                  1.继承
 *                  2.覆盖（重写）
 *                  3.向上转型（父类引用指向子类对象）
 */
public class Instrument {
    public void play(){
        System.out.println("Instrument is playing...");
    }
}
