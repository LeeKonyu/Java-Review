package ThinkingInOOP.threeMainFeatures.封装;

/**
 * @ClassName Person
 * @Description TODO
 * @Author
 * @Date 2020/8/9 15:59
 * @Version
 **/

/**
 * 以下Person类封装name、gender、age等属性，外界只能通过get()方法获得Person对象的name属性和gender属性，
 * 而无法获取age属性，但是age属性可以通过调用work()方法使用
 */


public class Person {
    private String name;
    private int gender;
    private int age;

    public String getName(){
        return name;
    }
    public String getGender(){
        return gender == 0 ? "man" : "woman";
    }
    public void work(){
        if (18 <= age && age <=50){
            System.out.println(name + " is working very hard!");
        }else {
            System.out.println(name + " can't work any more");
        }
    }
}
