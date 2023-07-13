package PriorityQueue;

public class HeapUse {
    public static void main(String[] args) {
        Heap h = new Heap();
        int[] arr = {15,10,3,8,12,9,4,1,24};

        for(int i: arr){
            h.insert(i);
        }
//        System.out.println(h);

        while (!h.isEmpty()){
            System.out.println(h.remove());

        }

    }
}
