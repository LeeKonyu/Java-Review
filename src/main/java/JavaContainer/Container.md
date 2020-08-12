### 容器中的设计模式
#### 迭代器模式
----
Collection继承了Iterable接口，其中的iterator()方法能够产生一个Iterator对象，通过这个对象就可以迭代遍历Collection中的元素

从`JDK 1.5`之后可以使用foreach方法来遍历实现了Iterable接口的聚合对象。
````
    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    for ( String item : list ) {
        System.out.println(item);
    }
````

#### 适配器模式
----
java.util.Arrays#asList()可以把数组类型转换为List类型。
````
@SafeVarargs
public static <T> List<T> asList(T... a) {
        return new ArrayList<>(a);
}
````
应该注意的是asList()的参数为泛型的变长参数，不能使用基本类型数组作为参数，只能使用相应的包装类型数组。
````
Integer[] arr = { 1 , 2 , 3 };
List list = Arrays.asList(arr);
````
也可以使用以下方式调用asList():
````
List list = Arrays.asList(1 , 2 , 3);
````