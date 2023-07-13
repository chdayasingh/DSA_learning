package PriorityQueue;

import java.util.Arrays;

// Max heap
public class Heap {

    int[] items;
    int size;

    public Heap() {
        this.items = new int[10];
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    public void insert(int x){
        if(isFull()){
            throw new IllegalStateException();
        }
        items[size++] = x;
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size-1;
        while (index > 0 && items[index] > items[parentIndex(index)]){
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swap(int index, int parentIndex) {
        int temp = items[index];
        items[index] = items[parentIndex];
        items[parentIndex] = temp;
    }

    private int parentIndex(int index){
        return (index-1)/2;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public int remove(){
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int root = items[0];
        items[0] = items[size-1];
        items[size-1] = 0; // reseting
        size--;

        bubbleDown();
        return root;
    }


    // another easiest way is implement in priorityQueueUsingHeap class
    private void bubbleDown() {
//        System.out.println("bubble down called");
        int index = 0;
        while(index < size && !isValidParent(index)){
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        if(leftChildIndex(index) >= size) { // left child don't exist
            return index;
        }
        if(rightChildIndex(index) >= size){ // right child don't exist
            return leftChildIndex(index);
        }
        return items[leftChildIndex(index)] >= items[rightChildIndex(index)] ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if(leftChildIndex(index) >= size) { // left child don't exist
            return true;
        }
        boolean isValid = items[leftChildIndex(index)] <= items[index];
        if(rightChildIndex(index) >= size){ // right child don't exist
            return isValid;
        }
        return isValid && items[rightChildIndex(index)] <= items[index];
    }

    private int leftChildIndex(int index) {
        return index*2 + 1;
    }
    private int rightChildIndex(int index) {
        return index*2 + 2;
    }

}
