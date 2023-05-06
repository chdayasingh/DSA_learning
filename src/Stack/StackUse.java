package Stack;

public class StackUse {
    public static void main(String[] args) throws StackEmptyException, StackFullException {

        StackUsingLL<Integer> s2 = new StackUsingLL<>();
        System.out.println(s2.size);
        s2.push(10);
        s2.push(20);
        s2.push(30);
        System.out.println(s2.pop());
        System.out.println(s2.pop());
        System.out.println(s2.pop());
        System.out.println(s2.pop());

        System.out.println(s2.size);

//        StackUsingArray s1 = new StackUsingArray();
//
//        int[] arr = {1,2,3,4,5};
//
//        for(int i=0; i<arr.length; i++){
//            s1.push(arr[i]);
//            System.out.println(s1.top());
//        }
//        System.out.println(s1.size());
//
//        while(! s1.isEmpty()){
//            System.out.println(s1.pop());
//        }
//        System.out.println(s1.size());

//        System.out.println(s1.size());
//        System.out.println(s1.top());
//        System.out.println(s1.pop());
//        System.out.println(s1.size());
//        System.out.println(s1.top());
//        System.out.println(s1.isEmpty());

    }

}
