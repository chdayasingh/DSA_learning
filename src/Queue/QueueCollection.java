package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(13);
        q1.add(26);
        System.out.println(q1.size());
        q1.poll();
        q1.poll();
        System.out.println(q1.size());
//        System.out.println(q1.isEmpty());
//        System.out.println(q1.size());
//        System.out.println(q1.peek());
//        System.out.println(q1.add(10));
//        System.out.println(q1.poll());
//        System.out.println(q1.poll());

    }
}
