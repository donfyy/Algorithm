import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    static class A<T> {

    }
    public static void main(String[] args) {
        A<String>[] array = null;
        array = new ArrayList<String>().toArray(array);
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
