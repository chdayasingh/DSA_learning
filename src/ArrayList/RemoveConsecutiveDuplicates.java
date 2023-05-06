package ArrayList;

import java.util.ArrayList;

public class RemoveConsecutiveDuplicates {
//    private static ArrayList<Integer> removeConsecutiveDuplicates(int[] arr) {
//        ArrayList<Integer> result = new ArrayList<>();
//        result.add(arr[0]);
//        for(int i=1; i<arr.length; i++){
//            if(arr[i] != arr[i-1]){
//                result.add(arr[i]);
//            }
//        }
//        return result;
//    }

    public static ArrayList<Integer> removeConsecutiveDuplicates(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                list.add(arr[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,4,1};
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
        ArrayList<Integer> newArr= removeConsecutiveDuplicates(arr);

        for(int i: newArr){
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
