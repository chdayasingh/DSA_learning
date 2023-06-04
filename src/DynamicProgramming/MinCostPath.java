package DynamicProgramming;

import java.util.Scanner;

public class MinCostPath {
    public static int minCostPathRecursive(int input[][], int i, int j){
        int m = input.length;
        int n = input[0].length;

        // path not exist, out of bound
        if(i == m || j == n){
            return Integer.MAX_VALUE;
        }

        // reached at destination
        if(i == m-1 && j == n-1){
            return input[i][j];
        }

        int min = Integer.MAX_VALUE;

        int ans1 = minCostPathRecursive(input, i, j+1);
        int ans2 = minCostPathRecursive(input, i+1, j+1);
        int ans3 = minCostPathRecursive(input, i+1, j);

        return input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
    }

    // memoization
    public static int minCostPathDP(int[][] input, int i, int j, int[][] memo) {
        int m = input.length;
        int n = input[0].length;

        // path not exist, out of bound
        if(i == m || j == n){
            return Integer.MAX_VALUE;
        }

        // reached at destination
        if(i == m-1 && j == n-1){
            memo[i][j] = input[i][j];
            return input[i][j];
        }

        int ans1, ans2, ans3;

        if(memo[i][j] == 0){
            ans1 = minCostPathDP(input, i, j+1, memo);
            ans2 = minCostPathDP(input, i+1, j+1, memo);
            ans3 = minCostPathDP(input, i+1, j, memo);

            memo[i][j] = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
        }

        return memo[i][j];
    }

    public static int minCostPathIterative(int[][] input, int i, int j){
        int m = input.length;
        int n = input[0].length;
        int[][] memo = new int[m][n];

        memo[m-1][n-1] = input[m-1][n-1];
        // filling the last row as reverse prefix sum
        for(int a=n-2; a>=0; a--){
            memo[m-1][a] = input[m-1][a] + memo[m-1][a+1];
        }

        // filling the last col as reverse prefix sum
        for(int a=m-2; a>=0; a--){
            memo[a][n-1] = input[a][n-1] + memo[a+1][n-1];
        }

        for(int row=m-2; row>=0; row--){
            for(int col=n-2; col>=0; col--){
                memo[row][col] = input[row][col] + Math.min(memo[row][col+1], Math.min(memo[row+1][col], memo[row+1][col+1]));
            }
        }

        return memo[0][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

//        3 4
//        3 4 1 2
//        2 1 8 9
//        4 7 8 1

        System.out.println(minCostPathRecursive(arr, 0, 0));

        int[][] memo = new int[m][n];
        // we can also initialized memo element with -infinity to counter the input array consist negative element because 0 can be answer of a subproblem

        System.out.println(minCostPathDP(arr, 0, 0, memo));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(minCostPathIterative(arr, 0, 0));

    }


}
