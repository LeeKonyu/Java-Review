package ThinkingInOOP.threeMainFeatures.继承;

/**
 * @ClassName Animal
 * @Description TODO
 * @Author
 * @Date 2020/8/9 16:06
 * @Version
 **/

public class Animal {
    private String name = "动物";

    public String getName(){
        return name;
    }

    public void run(){
        System.out.println(getName() + " is running");
    }
}
