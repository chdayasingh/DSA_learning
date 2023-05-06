package Array;

import java.util.Arrays;
import java.util.Scanner;

import static Array.ArrayUse.*;

public class Searching {
    public static int linearSearch(int[] arr, int x){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int x){
        System.out.println("binarySearch called");
        int s = 0;
        int e = arr.length - 1;

        while(s<=e){
            int m = (s + e) / 2;
            if (arr[m] < x){
                s = m + 1;
            }
            else if (arr[m] > x){
                e = m - 1;
            }
            else{
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = take_array_input();
//        System.out.println(linearSearch(arr1,5));
        System.out.println("Enter the value to be searched: ");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        System.out.println(binarySearch(arr1,val));
    }
}
