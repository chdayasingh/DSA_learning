package Array;

//        Sample Input 1:
//        1
//        6
//        9 3 6 12 4 32
//        Sample Output 1 :
//        3 9 12 6 32 4
//        Sample Input 2:
//        2
//        9
//        9 3 6 12 4 32 5 11 19
//        4
//        1 2 3 4
//        Sample Output 2 :
//        3 9 12 6 32 4 11 5 19
//        2 1 4 3

import static Array.ArrayUse.printArray;
import static Array.ArrayUse.take_array_input;

public class SwapAlternate {
    public static void main(String[] args) {
        int[] arr1 = take_array_input();
        swapAlternate(arr1);
        printArray(arr1);
    }

    private static void swapAlternate(int[] input) {
        int n = input.length;
        for(int i=0; i<n-1; i+=2){
            int temp = input[i];
            input[i] = input[i+1];
            input[i+1] = temp;
        }
    }
}
