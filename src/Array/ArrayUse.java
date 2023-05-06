package Array;

import java.util.Scanner;

public class ArrayUse {
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
    public static void printArray(int[] arr1){
        for(int i=0; i<arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr1= take_array_input();
        printArray(arr1);
    }
}
