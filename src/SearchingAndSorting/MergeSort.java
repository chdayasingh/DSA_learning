package SearchingAndSorting;

import Array.ArrayUse;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    /*
        Algorithm of MergeSort

        divide the problem in two halfs
        ask recursion to sort the two halfs
        then merge the two sorted array;
     */

    // creating two new array for part1 and part 2
    public static void mergeSortNaive(int[] arr){
        if(arr.length <= 1){
            return;
        }
        int mid = arr.length / 2;

        // 1st array
        int[] arr1 = new int[mid];
        for(int i=0; i<arr1.length; i++){
            arr1[i] = arr[i];
        }

        // 2nd array
        int[] arr2 = new int[arr.length - arr1.length];
        for(int i=0, j=mid; i<arr2.length; i++, j++){
            arr2[i] = arr[j];
        }

        mergeSortNaive(arr1);
        mergeSortNaive(arr2);

        mergeTwoSortedArrayNaive(arr1, arr2, arr);
    }

    public static void mergeTwoSortedArrayNaive(int[] arr1, int[] arr2, int[] arr){
        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            }
            else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        if(i == arr1.length){
            while(j < arr2.length){
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
        else {
            while (i < arr1.length) {
                arr[k] = arr1[i];
                i++;
                k++;
            }
        }
    }

//    ____________________________________________________________________________________________



    public static void mergeSort(int[] arr){
        mergeSortHelper(arr, 0, arr.length-1);
    }

    // instead of creating any array, we are defining range for part1 and part2
    private static void mergeSortHelper(int[] arr, int si, int ei) {
        if(si >= ei){
            return;
        }

        int midIndex = (si + ei) / 2;

        mergeSortHelper(arr, si, midIndex);
        mergeSortHelper(arr, midIndex+1, ei);

        mergeTwoSortedArray(arr, si, ei);
    }

    private static void mergeTwoSortedArray(int[] arr, int si, int ei) {
        // Creating new Output array
        int size = ei - si + 1;
        int[] output = new int[size];

        // Range for part1 array: si to mi
        // Range for part2 array: mi+1 to ei
        int midIndex = (si + ei) / 2;
        int i = si;
        int j = midIndex+1;
        int k = 0;

        // filling output array
        while(i <= midIndex && j<=ei){
            if(arr[i] <= arr[j]){
                output[k] = arr[i];
                i++;
            }
            else{
                output[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= midIndex){
            output[k] = arr[i];
            i++;
            k++;
        }
        while(j <= ei){
            output[k] = arr[j];
            j++;
            k++;
        }

        // Now copy output array to original array range( si to ei)
        for(int m=si, n=0; m<=ei; m++, n++){
            arr[m] = output[n];
        }
    }


    public static void main(String[] args) {
//        int[] arr1 = {1,3,4,5};
//        int[] arr2 = {0, 2, 2,5 ,9,10};
//        int[] arr3 = mergeTwoSortedArray(arr1,arr2);
//        ArrayUse.printArray(arr3);

        int[] arr = {1,5,3,10,0,6,4};
//        mergeSortNaive(arr);

//        mergeSort(arr);
        twoWayMergeSortIterative(arr);
        ArrayUse.printArray(arr);
    }


    // 2 way merge sort - iterative method

    public static void twoWayMergeSortIterative(int[] arr){

        for(int subarraySize = 1; subarraySize <= arr.length; subarraySize *= 2){
//            System.out.println("1 " + Arrays.toString(arr));
            for(int si=0; si<arr.length; si+=subarraySize*2){
                int ei = Math.min(si + subarraySize*2 - 1, arr.length-1);


                mergeTwoSortedArray(arr, si, ei);

            }
//            System.out.println("2 " + Arrays.toString(arr));
//            System.out.println();
        }
    }
}
