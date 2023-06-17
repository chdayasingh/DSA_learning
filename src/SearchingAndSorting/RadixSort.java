package SearchingAndSorting;

import java.util.Arrays;

//Non Comparision Based
// Digit by Digit Sorting, place value
// from least significant digit to most significant digit


public class RadixSort {
    private static int getMax(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        return max;
    }

    // modified count sort for using in each iteration of radix sort
    // T.C = O(n) for every n>10
    // S.C = O(n)
    private static void countSort(int[] arr, int place){
        int[] freq = new int[10];
        int n = arr.length;

        for (int elem : arr) {                   // nk
            int digit = (elem / place) % 10;
            freq[digit]++;
        }
        // creating prefix sum / commutative freq
        for(int i=1; i<freq.length; i++){     //   10k
            freq[i] += freq[i-1];
        }
        int[] output = new int[n];
        // traversing original array
        for(int i=n-1; i>=0; i--){         // nk
            int digit = (arr[i] / place) % 10;
            output[freq[digit]-1] = arr[i];
            freq[digit]--;
        }
        for(int i=0; i<n; i++){        //nk
            arr[i] = output[i];
        }
    }


    // T.C = O(n*k)  where k is the no of digit
    public static void radixSort(int[] arr){
        int max = getMax(arr);   // n

        for(int place=1; max/place > 0; place*=10){   // c*n
            countSort(arr, place); // n
        }
    }

    public static void main(String[] args) {
        int[] arr = {329, 457, 657, 839, 436, 720, 355};

        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
