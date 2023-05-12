package Array;

import java.util.Scanner;

public class RotateArray {
    public static void rotateArray(int[] arr,int n,int k){
        /* Approach 1
        int temp;
    	for(int count = 0; count<k; count++){
            temp = arr[0];
            for(int i=1; i<arr.length; i++){
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = temp;
        } */

        int[] temp = new int[k];
        // coping starting k elements from original array to temp arrya
        for(int i=0; i<k; i++){
            temp[i] = arr[i];
        }
        // shifting element in original array to the left by k positions
        int i=0;
        for(; i<n-k; i++){
            arr[i] = arr[i+k];
        }
        // tranfering temp elements at the end of original array
        for(int j=0; i<n; i++,j++){
            arr[i] = temp[j];
        }


    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        rotateArray(arr, n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
