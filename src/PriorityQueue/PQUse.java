package PriorityQueue;

public class PQUse {
    public static void main(String[] args) throws PriorityQueueException {
        // sorting array using minPQ
        MinPQUsingHeap<Character> pq1 = new MinPQUsingHeap<>();

        int[] arr = {5,4,3,2,1};
        String str = "ABCDEFGI";

        for(int elem: arr){
            System.out.print(elem + " ");
        }
        System.out.println();

        // inserting into pq
        for(int i=0; i<arr.length; i++){
            pq1.insert(str.charAt(i), arr[i]);
        }

        int index=0;
        while(!pq1.isEmpty()){
            arr[index] = pq1.removeMinPriorityElem().priority;
            index++;
        }

        for(int elem: arr){
            System.out.print(elem + " ");
        }
        System.out.println();




//        sorting array in decreasing order using maxPQ
        MaxPQUsingHeap<Character> pq2 = new MaxPQUsingHeap<>();
        int[] arr2 = {10, 20, 30, 50, 60, 70, 100};
        for(int elem: arr2){
            System.out.print(elem + " ");
        }
        System.out.println();

        // inserting into pq2
        for(int i=0; i<arr2.length; i++){
            pq2.insert(str.charAt(i), arr2[i]);
        }

        pq2.printHeap();

        int index2=0;
        while(!pq2.isEmpty()){
            arr2[index2] = pq2.removeMaxPriorityElem().priority;
            index2++;
        }
        for(int elem: arr2){
            System.out.print(elem + " ");
        }
        System.out.println();

    }
}
