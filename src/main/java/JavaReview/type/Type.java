package JavaReview.type;

/**
 * @ClassName Type
 * @Description TODO
 * @Author
 * @Date 2020/8/10 17:41
 * @Version
 **/

public class Type {
    public class Box<T> {
        // T stands for "Type"
        private T t;
        public void set(T t) { this.t = t; }
        public T get() { return t; }
    }
}
