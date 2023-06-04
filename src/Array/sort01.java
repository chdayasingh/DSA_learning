package Array;

import java.util.Arrays;

public class sort01 {
    // Doing in one single scan without extra space
    public static void sort01a(int[] arr){
        // two pointers - zeroPos , current(i)

        int zerPos = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                int temp = arr[zerPos];
                arr[zerPos] = arr[i];
                arr[i] = temp;
                zerPos++;
            }
        }
    }

    public static void sort01b(int[] arr){
        // two pointers - left, right

        int left = 0, right = arr.length-1;

        while(left<right){
            if(arr[left] == 0){
                left++;
            }
            else if(arr[right] == 1){
                right--;
            }
            else{
                // swap needed
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 0, 0, 1, 0};
        System.out.println(Arrays.toString(arr));
//        sort01a(arr);
        sort01b(arr);
        System.out.println(Arrays.toString(arr));
    }
}
