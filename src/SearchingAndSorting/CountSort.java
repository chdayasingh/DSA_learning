package SearchingAndSorting;

import java.util.*;

// Non Comparison Based Sorting Algo
// Use When Range is defined
// Not In-place

public class CountSort {

    // Non stable
    // TC- O(n+k), SC- O(K)
    public static void basicCountSort(int[] arr, int max){
        int[] freq = new int[max+1];

        for(int i: arr){
            freq[i]++;
        }
        int index = 0;
        for(int i=0; i< freq.length; i++){
            for(int j=1; j<=freq[i]; j++){
                arr[index++] = i;
            }
        }
    }


    // Stable count sort - using commutative freq or prefix sum
    // TC- O(n+k), SC- O(n+K)
    public static void countSort(int[] arr, int max){
        int n = arr.length;
        int[] freq = new int[max+1];

        for(int i: arr){
            freq[i]++;
        }
        // Prefix sum / cumulative frequency
        for(int i=1; i<freq.length; i++){
            freq[i] = freq[i] + freq[i-1];
        }

        int[] output = new int[n];

        //Traversing original array from end
        for(int i=n-1; i>=0; i--){
            output[freq[arr[i]]-1] = arr[i];
            freq[arr[i]]--;
        }
        // copy output array to arr
        for(int i=0; i<output.length; i++){
            arr[i] = output[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 4, 1, 2, 0};
        System.out.println(Arrays.toString(arr));
        // passing array and max value of arr
        basicCountSort(arr, 5);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {4, 5, 2, 0, 4, 2, 0, 2};

        System.out.println(Arrays.toString(arr1));
        countSort(arr1,5);
        System.out.println(Arrays.toString(arr1));
    }
}
