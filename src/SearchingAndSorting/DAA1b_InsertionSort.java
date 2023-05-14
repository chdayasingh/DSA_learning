package SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class DAA1b_InsertionSort {
    public static int[] take_array_input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter Array elements separated by space : ");
        for(int i=0; i<n; i++) {
//            System.out.println("Enter " + i + "th element : ");
            arr1[i] = sc.nextInt();
        }
        return arr1;
    }

    public static void insert(int[] arr, int i){
        int temp = arr[i];
        int j=i-1;
        while(j>=0 && temp < arr[j]){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;
    }
    public static void insertion_sort(int[] arr){
        for(int i=1; i<arr.length; i++){
            insert(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = take_array_input();
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        insertion_sort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
