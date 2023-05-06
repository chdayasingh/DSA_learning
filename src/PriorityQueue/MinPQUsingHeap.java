package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;

public class MinPQUsingHeap<T> {
    // Minimum priority Queue
    private ArrayList<ElementOfPQ<T>> minHeap;

    MinPQUsingHeap(){
        minHeap = new ArrayList<>();
    }

    public void printHeap(){
        System.out.println("Min Heap");
        for(ElementOfPQ<T> elem : minHeap){
            System.out.print("[v:" + elem.value + ", p-" + elem.priority + "] ");
        }
        System.out.println();
    }

    public int size(){
        return this.minHeap.size();
    }

    public boolean isEmpty(){
        return minHeap.size() == 0;
    }

    public ElementOfPQ<T> getMinPriorityElem() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return minHeap.get(0);
    }

    private void upHeapifyForMinHeap(int childIndex) {
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(minHeap.get(childIndex).priority < minHeap.get(parentIndex).priority){
                // Swapping the elements at childIndex and parentIndex
                Collections.swap(minHeap, childIndex, parentIndex);

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
        minHeap.add(newElem);
        upHeapifyForMinHeap(minHeap.size()-1);
    }


    public ElementOfPQ<T> removeMinPriorityElem() throws PriorityQueueException {
        if(minHeap.isEmpty()){
//            System.out.println("heap empty");
            throw new PriorityQueueException();
        }
        ElementOfPQ<T> removed = minHeap.get(0);

        // set last element at front
        minHeap.set(0, minHeap.get(minHeap.size()-1));
        // remove last element
        minHeap.remove(minHeap.size()-1);

        downHeapify();
        return removed;
    }

    private void downHeapify() {
        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while(leftChildIndex < minHeap.size()){
            // find minIndex among parentIndex , leftChildIndex and rightChildIndex
            int minIndex = parentIndex;
            if(minHeap.get(leftChildIndex).priority < minHeap.get(parentIndex).priority){
                minIndex = leftChildIndex;
            }
            // handling the case if right child is absent
            if(rightChildIndex < minHeap.size() && minHeap.get(rightChildIndex).priority < minHeap.get(minIndex).priority){
                minIndex = rightChildIndex;
            }
            // if minIndex remains unchanged then no need to swap
            if(minIndex == parentIndex){
                return;
            }
            else{
                Collections.swap(minHeap, parentIndex, minIndex);
            }

            // update the parentIndex , leftChildIndex and rightChildIndex
            parentIndex = minIndex;
            leftChildIndex = parentIndex*2 + 1;
            rightChildIndex = parentIndex*2 + 2;
        }

        // long code
//        while(leftChildIndex < minHeap.size()){
//            int parentChildPriority = minHeap.get(parentIndex).priority;
//            int leftChildPriority = minHeap.get(leftChildIndex).priority;
//            // There can be possibility that righchild is absent
//            int rightChildPriority;
//            try {
//                rightChildPriority = minHeap.get(rightChildIndex).priority;
//            }
//            catch(Exception e){
//                rightChildPriority = Integer.MAX_VALUE;
//            }
//
//            int minPriorityFromChild = Math.min(leftChildPriority, rightChildPriority);
//
//            if(minPriorityFromChild < parentChildPriority){
//                if(minPriorityFromChild == leftChildPriority){
//                    // swap parent with left
//                    Collections.swap(minHeap, leftChildIndex, parentIndex);
//                    parentIndex = leftChildIndex;
//                }
//                else {
//                    // swap parent with right child
//                    Collections.swap(minHeap, rightChildIndex, parentIndex);
//                    parentIndex = rightChildIndex;
//                }
//                leftChildIndex = parentIndex*2 + 1;
//                rightChildIndex = parentIndex*2 + 2;
//            }
//            else{
//                break;
//            }
//        }
    }
}
