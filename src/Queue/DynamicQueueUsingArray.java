package Queue;

import java.util.Arrays;

public class DynamicQueueUsingArray {
    private int[] data;
    private int front,rear,size;

    DynamicQueueUsingArray(){
        data = new int[5];
        front = -1;
        rear = -1;
    }
    DynamicQueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void print(){
        System.out.print("Current Queue : [ ");
        int frontIndex = front;
        int count = this.size();
        while(count>0){
            System.out.print(data[frontIndex] + " ");
            count--;
            frontIndex = (frontIndex+1)%data.length;
        }
        System.out.println("]");
    }

    @Override
    public String toString(){
        return Arrays.toString(data);
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }

    public void enqueue(int elem){
        if(size == data.length){
            increaseSizeOfArray();
        }
        if(size == 0){
            front = 0;
        }
        rear = (rear+1)%data.length;
        data[rear] = elem;
        size++;
    }

    private void increaseSizeOfArray() {
        System.out.println("Queue size increases");
        int[] temp = new int[data.length*2];
//        we are coping element of data to temp in fifo order
        int index = 0;
        for(int i=front; i<data.length; i++){
            temp[index++] = data[i];
        }
        for(int i=0; i<front; i++){
            temp[index++] = data[i];
        }
        front = 0;
        rear = index-1;
        data = temp;
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
        if(size == 0){ //Reseting front and rear
            front = -1;
            rear = -1;
        }
        return temp;
    }

}
