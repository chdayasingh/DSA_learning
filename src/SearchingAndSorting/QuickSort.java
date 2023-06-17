package SearchingAndSorting;

import java.util.Arrays;

public class QuickSort {
    /*
    Partition Step
    1. choose pivot
    2. place pivot to its correct position
    3. ensure everything on left is smaller or equal to pivot and everything on right is greater than pivot

    Quick Sort
    4. partition around pivot create left and right portion
    5. ask recursion to sort left portion and right portion
    */


    /*
    Pivot choosing options
        Always pick the first element as a pivot.
        Always pick the last element as a pivot (implemented below)
        Pick a random element as a pivot.
        Pick the middle as the pivot.
     */

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // takes 2 scan - 1 for finding pivotPos and other for shifting elems
    private static int partition(int[] arr, int si, int ei){
        // choose pivot
        int pivot = arr[si];
        // count num of elem lesser or equal to pivot from rest
        int count = 0;
        for(int i=si+1; i<=ei; i++){
            if(arr[i] <= pivot){
                count++;
            }
        }
        int pivotPos = si+count;
        // swap the pivot to its correct pos;
        swap(arr, si, pivotPos);

        //ensure everthing on left is smaller to pivot and everything on right is greater or equal than pivot
        int i = si;
        int j = ei;
        int temp = 0;
        // there are several ways to perform this step
        // if  i or j reach to pivotPos then we don't need to anything;
        while(i < pivotPos && j > pivotPos){
            if(arr[i] <= pivot){
                i++;
            }
            else if(arr[j] > pivot){
                j--;
            }
            // if we reach here that means swap is needed
            else{
                swap(arr, i, j);
            }
        }
        return pivotPos;
    }


    // choosing pivot as first element and partition in one scan
    private static int partition1(int[] arr, int low, int high){
        // First element as pivot
        int pivot = arr[low];

//        after k , every elem is greater than pivot
        int k = high;
        for (int i = high; i > low; i--) {
            if (arr[i] > pivot)
                swap(arr, i, k--);
        }
        swap(arr, low, k);
        // As we got pivot element index is end
        // now pivot element is at its sorted position
        // return pivot element index (end)
        return k;
    }


    // choosing pivot as last element and partition in one scan
    private static int partition2(int[] arr, int low, int high){
        int pivot = arr[high];
        // before k index every element is smaller
        int k = low;

        for(int i=low; i<high; i++){
            if(arr[i] < pivot){
                swap(arr, i, k);
                k++;
            }
        }
        swap(arr, k, high);
        return k;
    }




    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
    }

    private static void quickSortHelper(int[] arr, int si, int ei) {
        if(si >= ei){
            return;
        }
        int pivotPos = partition2(arr, si, ei);

        quickSortHelper(arr, si, pivotPos-1);
        quickSortHelper(arr, pivotPos+1, ei);
    }


    public static void main(String[] args) {
        int[] arr = {1,5,3,10,0,6,4};
//        int[] arr = {1,2,3,4,5,6,0};
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
