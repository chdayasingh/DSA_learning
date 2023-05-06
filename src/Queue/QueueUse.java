package Queue;

public class QueueUse {
    public static void main(String[] args) throws QueueEmptyException{
        QueueUsingLL<Integer> q2 = new QueueUsingLL<>();

//        for(int i=1; i<=10; i++){
//            q2.enqueue(i*10);
//        }
//        while(!q2.isEmpty()){
//            System.out.println(q2.dequeue());
//        }

        q2.enqueue(10);
        q2.enqueue(20);
        q2.dequeue();
        q2.dequeue();
        q2.enqueue(30);
        q2.enqueue(40);
        while(!q2.isEmpty()){
            System.out.println(q2.dequeue());
        }


//        DynamicQueueUsingArray q1 = new DynamicQueueUsingArray(4);
//
//        for(int i=1; i<=4; i++){
//            q1.enqueue(i);
//            q1.print();
//        }
//        q1.dequeue();
//        q1.print();
//        q1.dequeue();
//        q1.print();
//        q1.enqueue(5);
//        q1.print();
//        q1.enqueue(6);
//        q1.print();
//        System.out.println(q1.size());
//        q1.printInsideArray();
//        for(int i=7; i<=15; i++){
//            q1.enqueue(i);
//            q1.print();
//        }

//        StaticQueueUsingArray q = new StaticQueueUsingArray(5);

//        for(int i=1; i<=3; i++){
//            q.enqueue(i);
//            System.out.println(i + " is enqueue");
////            System.out.println("size : " + q.size());
////            System.out.println("front : " + q.front());
////            System.out.println();
//        }
//
//        while(!q.isEmpty()){
//            System.out.println("Deleted elem: " + q.dequeue());
////            System.out.println("size : " + q.size());
////            System.out.println("front : " + q.front());
////            System.out.println();
//        }
//        for(int i=1; i<=10; i++){
//            if(q.size() == 5){
//                q.dequeue();
//                q.print();
//            }
//            q.enqueue(i);
//            q.print();
//        }
    }
}
