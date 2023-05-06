package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;

public class MaxPQUsingHeap<T> {
    // Maximum priority queue
    private ArrayList<ElementOfPQ<T>> maxHeap;

    MaxPQUsingHeap(){
        maxHeap = new ArrayList<>();
    }

    public void printHeap(){
        System.out.println("Max Heap");
        for(ElementOfPQ<T> elem : maxHeap){
            System.out.print("[v:" + elem.value + "| p-" + elem.priority + "] ");
        }
        System.out.println();
    }

    public int size(){
        return this.maxHeap.size();
    }

    public boolean isEmpty(){
        return this.maxHeap.size() == 0;
    }

    public ElementOfPQ<T> getMaxPriorityElem() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return maxHeap.get(0);
    }

    private void upHeapifyForMaxHeap(int childIndex) {
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(maxHeap.get(childIndex).priority > maxHeap.get(parentIndex).priority){
                // Swapping the elements at childIndex and parentIndex
                Collections.swap(maxHeap, childIndex, parentIndex);
                // update childIndex and parentIndex
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }
            else{
                break;
            }
        }
    }

    public void insert(T value, int priority){
        ElementOfPQ<T> newElem = new ElementOfPQ<>(value, priority);
        maxHeap.add(newElem);
        upHeapifyForMaxHeap(maxHeap.size()-1);
    }

    public ElementOfPQ<T> removeMaxPriorityElem() throws PriorityQueueException {
        if(maxHeap.isEmpty()){
//            System.out.println("heap empty");
            throw new PriorityQueueException();
        }
        ElementOfPQ<T> removed = maxHeap.get(0);

        // set last element at front
        maxHeap.set(0, maxHeap.get(maxHeap.size()-1));
        // remove last element
        maxHeap.remove(maxHeap.size()-1);

        downHeapify();
        return removed;
    }

    private void downHeapify() {
        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while(leftChildIndex < maxHeap.size()){
            // find maxIndex among parentIndex , leftChildIndex and rightChildIndex
            int maxIndex = parentIndex;
            if(maxHeap.get(leftChildIndex).priority > maxHeap.get(parentIndex).priority){
                maxIndex = leftChildIndex;
            }
            // handling the case if right child is absent
            if(rightChildIndex < maxHeap.size() && maxHeap.get(rightChildIndex).priority > maxHeap.get(maxIndex).priority){
                maxIndex = rightChildIndex;
            }
            // if maxIndex remains unchanged then no need to swap
            if(maxIndex == parentIndex){
                return;
            }
            else{
                Collections.swap(maxHeap, parentIndex, maxIndex);
            }

            // update the parentIndex , leftChildIndex and rightChildIndex
            parentIndex = maxIndex;
            leftChildIndex = parentIndex*2 + 1;
            rightChildIndex = parentIndex*2 + 2;
        }
    }


}
