package Queue;

import LinkedList.SLLNode;

public class QueueUsingLL<T> {
    private SLLNode<T> front;
    private SLLNode<T> rear;
    private int size;

    public int size(){
        return this.size();
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void enqueue(T elem){
        SLLNode<T> newNode = new SLLNode<>(elem);
        size++;
        if(front == null){
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public T front() throws QueueEmptyException {
        if(front == null){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    public T dequeue() throws QueueEmptyException {
        if(front == null){
            throw new QueueEmptyException();
        }
        T temp = front.data;
        front = front.next;
        size--;
        return temp;
    }
}
