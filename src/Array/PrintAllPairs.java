package Array;

import static Array.ArrayUse.take_array_input;

public class PrintAllPairs {
    private static void printAllPairs(int arr[]) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                System.out.print("("+arr[i]+", "+arr[j]+") ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = take_array_input();
        printAllPairs(arr1);
    }


}
