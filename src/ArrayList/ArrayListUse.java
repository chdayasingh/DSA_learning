package ArrayList;

import java.util.ArrayList;

public class ArrayListUse {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=10; i<=100; i+=10){
            arr.add(i);
        }
//        System.out.println(arr.size());
//        boolean res = arr.contains(15);
//        System.out.println(res);

//        arr.remove(1);

        for(int i: arr){
            System.out.print(i + " ");
        }

//        arr.add(10);
//        arr.add(20);
//        arr.add(30);

//        for(int i=10; i<=100; i+=10){
//            arr.add(i);
//        }
//        arr.add(0, 1);
//        for(int i : arr){
//            System.out.print(i + " ");
//            if(i == arr.get(arr.size()-1)){
//                System.out.println();
//            }
//        }
//        System.out.println(arr.size());

    }
}
