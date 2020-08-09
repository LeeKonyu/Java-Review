package ThinkingInOOP.threeMainFeatures.继承;

/**
 * @ClassName Main
 * @Description TODO
 * @Author
 * @Date 2020/8/9 16:08
 * @Version
 **/

/**
 * 继承实现了IS-A关系，例如Cat和Animal就是一种IS-A关系，因此Cat可以继承自Animal，从而获得Animal非private的属性和方法。
 * 继承应该遵循里氏替换原则，子类对象必须能够替换掉所有父类对象。
 * Cat可以当作Animal来使用，也就是说可以使用Animal引用Cat对象，父类引用指向子类对象成为 向上转型 。
 *
 */

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run();
        Animal animal = new Cat();
        animal.run();
    }
}
