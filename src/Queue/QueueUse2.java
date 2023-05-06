package Queue;

public class QueueUse2 {
    public static void main(String[] args) {
        QueueUsingStacks<Integer> q = new QueueUsingStacks<>();
        int arr[] = {10,20,30,40};

        for(int i: arr){
            q.enqueue(i);
        }

        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }

        System.out.println(q.dequeue());
    }
}
