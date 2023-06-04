package DynamicProgramming;

import java.util.Arrays;

public class ByteLandian {

    // for large value of n , not use array to store already computed result(memoization)
    //  use hashmap
    public static long byteLandian(long n, long[] memo){
        if(n <= 1){
            return n;
        }
        if(memo[(int) n] != -1){
            return memo[(int) n];
        }
        long brokendownValue = byteLandian(n/2, memo) + byteLandian(n/3, memo) + byteLandian(n/4, memo);
        memo[(int) n] = Math.max(n, brokendownValue);
        return brokendownValue;
    }

    public static void main(String[] args) {
        long n = 12;

        long[] memo = new long[(int)n+1];
        for(int i=0; i<memo.length; i++){
            memo[i] = -1;
        }

        System.out.println(byteLandian(n, memo));
        System.out.println(Arrays.toString(memo));
    }
}
