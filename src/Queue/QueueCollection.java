package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueCollection {
    public static void reverseQueue(Queue<Integer> list){
        if(list.isEmpty() || list.size() == 1)    {
            return;
        }

        int temp = list.remove();
        reverseQueue(list);
        list.add(temp);
    }

    public static void reverseKElemsInQueue(Queue<Integer> q, int k){
        int n = q.size();
        Stack<Integer> s = new Stack<>();
        // reverse first k elems
        for(int i=0; i<k; i++){
            s.push(q.poll());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }

        for(int i=0; i<n-k; i++){
            q.add(q.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(10);
        q1.add(20);
        q1.add(30);

        System.out.println(q1);
//        System.out.println(q1.size());
        reverseQueue(q1);
        System.out.println(q1);
        reverseKElemsInQueue(q1, 2);
        System.out.println(q1);

    }
}
