package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    StackUsing2Queue(){
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public int size(){
        return this.q1.size();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }
    public void push(int x){
        // adding new item at the end of 1st queue
        q2.add(x);

        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int peek(){
        if(q1.size() == 0){
            return -1;
        }
        return q1.peek();
    }
    public int pop(){
        if(q1.size() == 0){
            return -1;
        }
        return q1.poll();
    }
}
