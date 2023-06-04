package DynamicProgramming;

//Edit Distance
//
//        You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings. Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
//        1. Delete a character
//        2. Replace a character with another one
//        3. Insert a character
//        Note :Strings don't contain spaces in between.

public class EditDistance {

    // trying to convert s to make same as t

    public static void main(String[] args) {
        String s = "abc";
        String t = "abdc";

//        System.out.println(editDistanceGreedy(s,t));
        System.out.println(editDistanceRecursive(s, t));
        System.out.println(editDistanceR1(s, t, s.length(), t.length()));
        System.out.println(editDistanceIterative(s, t));
    }

    // wrong answer by greedy aproach
    private static int editDistanceGreedy(String s, String t) {
        if(s.length() == 0){
            return 0;
        }

        // if the both character are equal then skip
        if (s.charAt(0) == t.charAt(0)) {
            return editDistanceGreedy(s.substring(1), t.substring(1));
        }

        // if we are here that's means string's chars are not equal
        // we can perform three operations to make them equal

        if (s.length() == t.length()){
            // we perform replace chars op only
            return 1 + editDistanceGreedy(s.substring(1), t.substring(1));
        }

        // here, means length are unequal, so we perform insert or delete
        if(s.length() > t.length()){
            return 1 + editDistanceGreedy(s.substring(1), t);
        }
        else{
            return 1 + editDistanceGreedy(s, t.substring(1));
        }
    }


    // recursive, passing substring
    public static int editDistanceRecursive(String s, String t){
        int m = s.length();
        int n = t.length();

        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }

        if(s.charAt(0) == t.charAt(0)){
            return editDistanceRecursive(s.substring(1), t.substring(1));
        }

        // Inserting a char
        int ans1 = editDistanceRecursive(s, t.substring(1));
        // Remove a char
        int ans2 = editDistanceRecursive(s.substring(1), t);
        // replace a char
        int ans3 = editDistanceRecursive(s.substring(1), t.substring(1));

        return 1 + Math.min(ans1, Math.min(ans2, ans3));
    }


    // recursive, passing size
    public static int editDistanceR1(String s, String t, int m, int n){
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }

        if(s.charAt(m-1) == t.charAt(n-1)){
            return editDistanceR1(s, t, m-1, n-1);
        }

        // Inserting a char
        int ans1 = editDistanceR1(s, t, m, n-1);
        // Remove a char
        int ans2 = editDistanceR1(s, t, m-1, n);
        // replace a char
        int ans3 = editDistanceR1(s, t, m-1, n-1);

        return 1 + Math.min(ans1, Math.min(ans2, ans3));
    }

    // Iterative
    public static int editDistanceIterative(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] memo = new int[m+1][n+1];

        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[i].length; j++){
                if(i == 0){
                    memo[i][j] = j;
                }
                else if(j == 0){
                    memo[i][j] = i;
                }
                // characters are same
                else if(s.charAt(i-1) == t.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1];
                }
                else{
                    memo[i][j] = 1 + Math.min(memo[i-1][j], Math.min(memo[i-1][j-1], memo[i][j-1]));
                }
            }
        }

        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[i].length; j++){
                System.out.print(memo[i][j]);
            }
            System.out.println();
        }
        return memo[m][n];
    }

}
