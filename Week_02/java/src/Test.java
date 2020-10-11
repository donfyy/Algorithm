import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();
//
//        priorityQueue.offer(new Element());
//        priorityQueue.offer(new Element());
//       抛出异常
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(0, 0.75f, true);
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(4, 4);
        linkedHashMap.get(1);
        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.toString());
        }
    }

    public static class Element {

    }
}
