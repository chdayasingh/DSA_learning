package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class NthFibboNum {
    public static int nthFibboNum(int n, int[] dp){
        if(n < 2){
            return n;
        }
        int ans1, ans2;
        if(dp[n-1] != -1){
            ans1 = dp[n-1];
        }
        else{
            ans1 = nthFibboNum(n-1, dp);
            dp[n-1] = ans1;
        }
        if(dp[n-2] != -1){
            ans2 = dp[n-2];
        }
        else{
            ans2 = nthFibboNum(n-2, dp);
            dp[n-2] = ans2;
        }

        return ans1+ans2;
    }

    public static int nthFibboNumIterative(int n){
        if(n < 2){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int nthFibboNumIterative1(int n){
//        if(n < 2){
//            return n;
//        }

        int a = 0;
        int b = 1;

        for(int i=1; i<n; i++){
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // for storing result
        int[] dp = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }

        System.out.println(nthFibboNum(n, dp));
        System.out.println(nthFibboNumIterative(n));
        System.out.println(nthFibboNumIterative1(n));
    }
}
