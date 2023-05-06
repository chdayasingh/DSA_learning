package Array;

import static Array.ArrayUse.*;

public class Largest {
    public static int giveLargest(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;

    }

    public static int secondLargest(int[] arr){
        int n = arr.length;
        int lar = Integer.MIN_VALUE;
        int secLar = Integer.MIN_VALUE;
        for(int i=0;i<n; i++){
            if(arr[i] > lar){
                secLar = lar;
                lar = arr[i];
            }
            else if(arr[i] != lar && arr[i] > secLar){
                secLar = arr[i];
            }
        }
        return secLar;
    }

    public static void main(String[] args) {
        int[] arr1 = take_array_input();
        printArray(arr1);
//        int max = giveLargest(arr1);
//        System.out.println("\nMaximum value in this array: " + max);

        int secLar = secondLargest(arr1);
        System.out.println("\nSecond maximum value in this array: " + secLar);
    }
}
