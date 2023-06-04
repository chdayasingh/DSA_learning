package DynamicProgramming;

public class LCS {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "bbd";

//        System.out.println(lcsRecursive(s1, s2, 0, 0));

        int[][] memo = new int[s1.length()][s2.length()];
        for(int i=0; i< memo.length; i++){
            for(int j=0; j<memo[i].length; j++){
                memo[i][j] = -1;
            }
        }

//        System.out.println(lcsDP(s1, s2, 0, 0, memo));

        System.out.println(lcsIterative(s1, s2));
    }

    public static int lcsRecursive(String s1, String s2, int i, int j) {
//        System.out.println(i + " " + j);
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
//        System.out.println(s1.substring(i) + " " + s2.substring(j));
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + lcsRecursive(s1, s2, i+1, j+1);
        }
        else{
            int ans1 = lcsRecursive(s1, s2, i, j+1);
            int ans2 = lcsRecursive(s1, s2, i+1, j);
            return Math.max(ans1, ans2);
        }
    }


//    TC = O(n * m)
    public static int lcsDP(String s1, String s2, int i, int j, int[][] memo) {
//        System.out.println(i + " " + j);
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int ans;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + lcsDP(s1, s2, i+1, j+1, memo);
        }
        else{
            int ans1 = lcsDP(s1, s2, i, j+1, memo);
            int ans2 = lcsDP(s1, s2, i+1, j, memo);
            ans = Math.max(ans1, ans2);
        }
        memo[i][j] = ans;
        return ans;
    }

    public static int lcsIterative(String s1, String s2){
        // one extra row and col to cut down the extra code
        int[][] memo = new int[s1.length()+1][s2.length()+1];

        for(int row=s1.length()-1; row>=0; row--){
            for(int col=s2.length()-1; col>=0; col--){
                if(s1.charAt(row) == s2.charAt(col)){
                    memo[row][col] = 1 + memo[row+1][col+1];
                }
                else {
                    memo[row][col] = Math.max(memo[row][col+1], memo[row+1][col]);
                }
            }
        }

//        for (int i = 0; i < memo.length; i++) {
//            for (int j = 0; j < memo[i].length; j++) {
//                System.out.print(memo[i][j] + " ");
//            }
//            System.out.println();
//        }

        return memo[0][0];
    }
}
