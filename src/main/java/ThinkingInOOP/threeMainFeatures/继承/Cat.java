package ThinkingInOOP.threeMainFeatures.继承;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author
 * @Date 2020/8/9 16:07
 * @Version
 **/

public class Cat extends Animal {
    private String name = "猫";

    public String getName(){
        return name;
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running");
    }
}
