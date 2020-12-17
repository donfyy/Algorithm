import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static volatile int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
//        testTreeMap();
//        testThread1();
//        testThread2();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println(1);
                try {
                    sleep(1000);
                    System.out.println(1.1);
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(5);
            }
        }).start();
        new Thread(() -> {
            sleep(1000);
            System.out.println(2);
            synchronized (lock) {
                System.out.println(3);
                sleep(7000);
                System.out.println(4);
            }
        }).start();
    }

    private static void testTreeMap() {
        System.out.println(1 & (~(1 << 0)));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        treeMap.put(5, 5);
        treeMap.put(2, 2);
        treeMap.put(4, 4);

        System.out.println(treeMap.entrySet());
    }

    private static void testThread2() {
        Object lock = new Object();
        AtomicInteger i = new AtomicInteger(1);
        new Thread(() -> {
            System.out.println("1 consumer");
            synchronized (lock) {
                while (i.get() != 0) {
                    try {
                        System.out.println("2 consumer wait");
                        lock.wait();
                        System.out.println("7 consumer after wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            sleep(1000);
            System.out.println("3 producer ");
            synchronized (lock) {
                i.getAndDecrement();
                System.out.println("4 decrement");
                lock.notifyAll();
                System.out.println("5 sleep before 1s");
                sleep(1000);
                System.out.println("6 sleep after 1s");
            }
        }).start();
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testThread1() throws InterruptedException {
        new Thread(() -> {
            sleep(1000);
            System.out.println("set cnt = " + 1);
            cnt = 1;
        }).start();
        new Thread(() -> {
            int c = cnt;
            System.out.println("c = " + c);
            sleep(1200);
            cnt = c + 5;
            System.out.println("cnt = " + cnt);
        }).start();
        Thread.sleep(3000);
    }
}
