package Array;

import java.util.Scanner;

import static Array.ArrayUse.printArray;

public class ArrangeNumbersInArray {

//    How to approach?
//    To arrange the numbers in the given sequence, we can continue by taking 2 indices one from
//    start(i) and the other from the end(j). Start with number =1, print it on the first index(i), then
//    increment the number and index i, now print the number on the last index(j), again increment the
//    number and decrement j, print number on the 2nd index(i) and so on continue till i crosses j.
    public static int[] arrange(int n){
        int arr[] = new int[n];
        int i = 0;
        int j = n-1;
        int num = 1;
//        // at each iteration we are filling two indexes
//        while(i<j){
//            arr[i] = num;
//            i++;
//            num++;
//            arr[j] = num;
//            num++;
//            j--;
//        }
//        if(i==j){
//            arr[i] = num;
//        }

        // at each iteration we are filling only one index
        for(; num<=n; num++){
            if(num%2 == 1){
                arr[i] = num;
                i++;
            }
            else{
                arr[j] = num;
                j--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of 'n' : ");
        int n = sc.nextInt();
        int arr1[] = arrange(n);
        printArray(arr1);
    }
}
