import java.util.TreeMap;

public class Test {
    static volatile int cnt = 0;
    public static void main(String[] args) throws InterruptedException {
        System.out.println(1 & (~(1 << 0)));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        treeMap.put(5, 5);
        treeMap.put(2, 2);
        treeMap.put(4, 4);

        System.out.println(treeMap.entrySet());

        new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("set cnt = " + 1);
            cnt = 1;
        }).start();
        new Thread(()-> {
            int c = cnt;
            System.out.println("c = " + c);
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cnt = c + 5;
            System.out.println("cnt = " + cnt);
        }).start();
        Thread.sleep(3000);
    }
}
