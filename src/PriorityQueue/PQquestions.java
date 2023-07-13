package PriorityQueue;

import java.util.*;

public class PQquestions {
    public static void main(String[] args) throws PriorityQueueException {
//        int[] arr = {5, 2, 9, 6, 8, 7,4, 11, 1,10,3};

//        for(int i: getKSmallestElem(arr, 4)){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for(int i: getKLargestElem(arr, 4)){
//            System.out.print(i + " ");
//        }
//        System.out.println(kLargestElement(arr, 4));

        int[] arr = {2,3,2,2,4};
        System.out.println(buyTicket(arr, 3));

    }

    public static ArrayList<Integer> getKSmallestElem(int[] arr, int k){
        // maintaining maxPQ for first k elems
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<k; i++){
            pQueue.add(arr[i]);
        }
        for(int i=k; i<arr.length; i++){
            // if we found less elem than maxOfPQ then replace it
            if(arr[i] < pQueue.peek()) {
                pQueue.poll();
                pQueue.add(arr[i]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pQueue.isEmpty()){
            ans.add(pQueue.poll());
        }
        return ans;
    }

    public static ArrayList<Integer> getKLargestElem(int[] arr, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pQueue.add(arr[i]);
        }
        for(int i=k; i<arr.length; i++){
            if(arr[i] > pQueue.peek()) {
                pQueue.poll();
                pQueue.add(arr[i]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pQueue.isEmpty()){
            ans.add(pQueue.poll());
        }
        return ans;
    }

    //    T.C = O(nlogk)
    //    S.C = O(k)
    public static int kthLargestElement(int[] arr, int k){
        // making a minheap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // adding k elem to minHeap
        for(int i=0; i<k; i++){
            minHeap.add(arr[i]);
        }
        for(int i=k; i<arr.length; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.peek();
    }

    //    Buy the ticket
    //    Input Format:
    //    The first line of input contains an integer, that denotes the value of total number of people standing in queue or the size of the array of priorities. Let us denote it with the symbol N.
    //    The following line contains N space separated integers, that denote the value of the elements of the array of priorities.
    //    The following contains an integer, that denotes the value of index of your priority. Let us denote it with symbol k.
    //    Output Format :
    //    The first and only line of output contains the time required for you to get the ticket.

        // we need to find the time , person at kth index will get the ticket
    public static int buyTicket(int[] arr, int k){
        // creating a queue to maintain the indexes of array
        // Note - in queue we are storing indices ,not elements of array . To avoid the case of duplicates element
        Queue<Integer> q = new LinkedList<>();
        // creating a maxPQ to compare first person's priority in queue  with maxPriority at O(1)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<arr.length; i++){
            q.add(i);
            maxPQ.add(arr[i]);
        }

        int time = 0;

        while (!q.isEmpty()){
            int index = q.poll();
            // if the first person's priority in queue is equal to max priority then the person will get the ticket
            if(arr[index] == maxPQ.peek()){
                maxPQ.poll();
                time++;
                if(index == k){
                    return time;
                }
            }
            // if the priority of first person in queue is less than max priority then it will go to the last of queue
            else{
                q.add(index);
            }
        }
        // In case of valid inputs we will never come here
        return Integer.MAX_VALUE;
    }

}
