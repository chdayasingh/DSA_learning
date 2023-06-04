package DynamicProgramming;

import java.util.Scanner;

public class StairCaseIterative {
    public static int possibleWaysToClimbStairCase(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1 || n == 2){
            return n;
        }

        int ways[] = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        for (int i=3; i<ways.length; i++){
            ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
        }
        return ways[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(possibleWaysToClimbStairCase(n));
    }
}
