import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(new Element());
        priorityQueue.offer(new Element());
//       抛出异常
    }

    public static class Element {

    }
}
