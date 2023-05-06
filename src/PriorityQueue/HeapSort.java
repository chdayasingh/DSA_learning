package PriorityQueue;

import java.util.Arrays;
import java.util.Collections;

public class HeapSort {
    // sorted array can be formed easily using MinPriority Queue by creating a heap using array and remove element one by one and put onto original array
    // TC- O(nlogn) SC- O(n)
    // to optimise space we are using inplace heap sort , in which we build heap inside the original array
    // In inplace heap sort SC- O(1)

    // give sorted array in descending order


    public static void buildHeapInNLogN(int[] arr){
        // build heap in same array
        // O(nlogn)
        for(int i=1; i< arr.length; i++){
            int childIndex = i;
            int parentIndex = (childIndex-1)/2;

            // up heapify
            while(childIndex > 0){
                if(arr[childIndex] < arr[parentIndex]){
                    // Swapping the elements at childIndex and parentIndex
                    int temp = arr[parentIndex];
                    arr[parentIndex] = arr[childIndex];
                    arr[childIndex] = temp;

                    // update childIndex and parentIndex
                    childIndex = parentIndex;
                    parentIndex = (childIndex-1)/2;
                }
                else{
                    break;
                }
            }
        }
    }

    public static void downHeapify(int[] arr, int startIndex, int size){
        int parentIndex = startIndex;
        int leftChildIndex = parentIndex*2 + 1;
        int rightChildIndex = parentIndex*2 + 2;

        while(leftChildIndex < size){
            // find minIndex among parentIndex , leftChildIndex and rightChildIndex
            int minIndex = parentIndex;
            if(arr[leftChildIndex] < arr[parentIndex]){
                minIndex = leftChildIndex;
            }
            // handling the case if right child is absent
            if(rightChildIndex < size && arr[rightChildIndex] < arr[minIndex]){
                minIndex = rightChildIndex;
            }
            // if minIndex remains unchanged then no need to swap
            if(minIndex == parentIndex){
                break;
            }
            else{
                // swap the elements
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[minIndex];
                arr[minIndex] = temp;
            }

            // update the parentIndex , leftChildIndex and rightChildIndex
            parentIndex = minIndex;
            leftChildIndex = parentIndex*2 + 1;
            rightChildIndex = parentIndex*2 + 2;
        }
    }

    public static void buildHeap(int[] arr){
        int n = arr.length;

        // downheapify(i,n) from last leafnode to root(first leafnode)

        for(int i=(n/2)-1; i>=0; i--){
            downHeapify(arr, i, n);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void inplaceHeapSort(int[] arr){
        // Build Heap
//        buildHeapInNLogN(arr);
        buildHeap(arr);


//        System.out.println(Arrays.toString(arr));

        // Remove elements from starting one by one, and put them at respective last position
        for(int i=arr.length-1; i>=0; i--){
            // swapping last elem with first elem
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // maintain min heap till ith index , down heapify
            downHeapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 5, 8, 1, 4};
        System.out.println(Arrays.toString(arr));
        inplaceHeapSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
