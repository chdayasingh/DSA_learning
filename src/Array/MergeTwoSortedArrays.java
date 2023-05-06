package Array;

import static Array.ArrayUse.*;

public class MergeTwoSortedArrays {
    private static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] arr = new int[n+m];
        int i = 0,j = 0,k = 0;
//        System.out.println(i + " " + j + " " + k);

        while(i<n && j<m){
            if(arr1[i] <= arr2[j]){
                arr[k] = arr1[i];
                i++;
            }
            else{
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(j<m){
            arr[k] = arr2[j];
            j++;
            k++;
        }
        while(i<n) {
            arr[k] = arr2[i];
            i++;
            k++;
        }

        return arr;

    }

    public static void main(String[] args) {
        int[] arr1 = take_array_input();
        int[] arr2 = take_array_input();
        int[] arr3 = mergeTwoSortedArrays(arr1,arr2);
        printArray(arr3);

    }
}
