package SearchingAndSorting;

import java.util.Arrays;

public class QuickSort {
    /*
    Partition Step
    1. choose pivot
    2. place pivot to its correct position
    3. ensure everything on left is smaller or equal to pivot and everything on right is greater than pivot

    4. partition around pivot create left and right portion
    5. ask recursion to sort left portion and right portion
     */
    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
    }

    private static void quickSortHelper(int[] arr, int si, int ei) {
        if(si >= ei){
            return;
        }
        int pivotPos = partition(arr, si, ei);

        quickSortHelper(arr, si, pivotPos-1);
        quickSortHelper(arr, pivotPos+1, ei);
    }

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
        arr[si] = arr[pivotPos];
        arr[pivotPos] = pivot;

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
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return pivotPos;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,10,0,6,4};
//        int[] arr = {1,2,3,4,5,6,0};
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
