import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        System.out.println(1 & (~(1 << 0)));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        treeMap.put(5, 5);
        treeMap.put(2, 2);
        treeMap.put(4, 4);

        System.out.println(treeMap.entrySet());
    }
}
