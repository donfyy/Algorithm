import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class DequeTest {
    static class A<T> {

        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    static class E1{}
    static class E2 extends E1 {}
    public static void main(String[] args) {
        A<? extends E1> a1 = new A<>();
        E1 t = a1.getT();
//        a1.setT(); x 因为不知道传入的对象是不是E1的子类
        // 有上界的范型类型不能写入对象，是因为不知道要写入的对象是什么类型，这些对象
        // 不能够被安全的转换成目标类型，但是对于有下界的范型类型可以写入对象，因为可供写入的对象都是
        // 下界或者下界的对象，这些对象可以被安全的转换成目标对象
        A<? super E1> a2 = new A<>();
        a2.setT(new E1());
        a2.setT(new E2());


        synchronized (a1) {
            System.out.println("i");
        }
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        System.out.println(map.putIfAbsent("a", "b"));

        System.out.println("------------------------------------------------");

        test1();
        System.out.println("------------------------------------------------");
        test2();
        System.out.println("-----------------------------------------");
        System.out.println(Integer.toBinaryString(-1));
        System.out.println("128:" + Integer.toBinaryString(128));
        System.out.println("-128:" + Integer.toBinaryString(-128));
        System.out.println(Integer.toBinaryString(65408));
        System.out.println(Integer.toUnsignedString(-1));
        System.out.println(Integer.toUnsignedLong(-1));
        System.out.println(Long.toBinaryString(Integer.toUnsignedLong(-1)));
        System.out.println(Long.toUnsignedString(Integer.toUnsignedLong(-1)));
        System.out.println(Long.toBinaryString(-1L));
        System.out.println("你:" + "你".length());
        System.out.println(~0 + ":" + Integer.toBinaryString(~0));

        System.out.println(~3);
        System.out.println(0.1 + 0.2);
        System.out.println(0.1 + 0.2 == 0.3);
        System.out.println(0.1 + 0.2 - 0.3 <  0.0001);
    }

    static void test1() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    static void test2() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
