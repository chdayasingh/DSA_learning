package Array;

import java.util.Arrays;

public class PairSum_TripletSum {
    public static void main(String[] args) {

    }
    // TC - (nlogn)
    public static int countPairSumToX(int[] arr, int sum){
        Arrays.sort(arr);
        return countPairSumToXHelper(arr, 0, arr.length-1, sum);
    }

    private static int countPairSumToXHelper(int[] arr, int si, int ei, int sum) {
//        TODO
        // Also Handle the case of duplicates elem and all same elems;

        int numPairs = 0;

        while(si < ei){

        }

        return numPairs;
    }

    // find using pairsum function
    // TC - O(n.nlogn)
    public static int countTripletSumToX(int[] arr, int sum){
        Arrays.sort(arr);
        int numTriplets = 0;
        for(int i=0; i<arr.length; i++){
            int targetPairSum = sum-arr[i];
            int numPairs = countPairSumToXHelper(arr, i+1, arr.length-1, targetPairSum);
            numTriplets += numPairs;
        }
        return numTriplets;
    }
}
