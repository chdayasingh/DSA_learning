package Queue;

public class StaticQueueUsingArray {
    private int[] data;
    private int front,rear,size;

    StaticQueueUsingArray(){
        data = new int[5];
        front = -1;
        rear = -1;
    }
    StaticQueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void print(){
        System.out.print("[ ");
        int frontIndex = front;
        int count = this.size();
        while(count>0){
            System.out.print(data[frontIndex] + " ");
            count--;
            frontIndex = (frontIndex+1)%data.length;
        }
        System.out.println("]");
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }

    public void enqueue(int elem){
        if(size == data.length){
            System.out.println("Queue Overflow");
            return;
        }
        if(size == 0){
            front++;
        }

        rear = (rear+1)%data.length;
        data[rear] = elem;
        size++;
    }
    public int front(){
        if(size == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        return data[front];
    }
    public int dequeue(){
        if(size == 0){
            System.out.println("Queue Underflow");
            return -1;
        }
        int temp = data[front];
        front = (front+1)%data.length;
        size--;
        if(size == 0){
            front = -1;
            rear = -1;
        }
        return temp;
    }


}
