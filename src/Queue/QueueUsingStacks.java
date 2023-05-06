package Queue;

import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> s1;
    private Stack<T> s2;

    QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public int size(){
        return s1.size();
    }

    public boolean isEmpty(){
        return s1.isEmpty();
    }

    public void enqueue(T elem){
        s1.push(elem);
    }

    public T dequeue(){
        if(s1.size() == 0){
            return null;
        }
        if(s1.size() == 1){
            return s1.pop();
        }
        while(s1.size() != 1){
            s2.push(s1.pop());
        }
        T temp = s1.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return temp;
    }

    public T peek(){
        if(s1.size() == 0){
            return null;
        }
        if(s1.size() == 1){
            return s1.peek();
        }
        while(s1.size() != 1){
            s2.push(s1.pop());
        }
        T temp = s1.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return temp;
    }

}
