package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinSquare {

    // Greedy Approach but its failed, eg - 41
    public static int minSquareToRepresentNGreedy(int n){
        double x = Math.sqrt(n);
        if(x%1 == 0){
            // means n is perfect square
            return 1;
        }
        int xAsInt = (int) x;
        return 1 + minSquareToRepresentNGreedy(n - (xAsInt * xAsInt));
    }

    public static int minSquareToRepresentN(int n){
        if(n == 0){
            return 0;
        }

        int minAns = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            int currentAns = minSquareToRepresentN(n - (i * i));
            minAns = Math.min(minAns, currentAns);
        }
        return 1 + minAns;
    }


    // TC -> O(n*sqrt(n))
    public static int minSquareToRepresentNDP(int n, int[] memo){
        // There is another way to write to base case but it doesn't affect anything
//        double x = Math.sqrt(n);
//        if(x%1 == 0){
//            // means n is perfect square
//            return 1;
//        }
        if(n == 0){
            return 0;
        }

        if(memo[n] != -1){
            return memo[n];
        }
        int minAns = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            int currentAns = minSquareToRepresentNDP(n - (i * i), memo);
            minAns = Math.min(minAns, currentAns);
        }
        memo[n] = 1 + minAns;
        return memo[n];
    }

    public static int minSquareToRepresentNIterativeDP(int n){
        int[] memo = new int[n + 1];
        for(int i=2; i<memo.length; i++){
            memo[i] = -1;
        }
        memo[0] = 0;
        memo[1] = 1;

        for(int i=2; i<memo.length; i++){
            int min = Integer.MAX_VALUE;
            // doing -1^2 , -2^2 and so on ., check minimum squares need for every case
            for(int j=1; j*j<= i; j++){
                int current = memo[i - (j*j)];
                min = Math.min(min, current);
            }
            // 1 is added to min- > eg. for 5 we check minimum squares represent for (4, 1) and one more square added
            memo[i] = 1 + min;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 22;
//        System.out.println(minSquareToRepresentNGreedy(41));
//        System.out.println(minSquareToRepresentN(41));

        int[] memo = new int[n + 1];
        for(int i=0; i<memo.length; i++){
            memo[i] = -1;
        }
        System.out.println(minSquareToRepresentNDP(n, memo));
//        System.out.println(Arrays.toString(memo));

        System.out.println(minSquareToRepresentNIterativeDP(n));
    }
}
