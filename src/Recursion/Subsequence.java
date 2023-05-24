package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsequence {
//    Print all subsequences of a string

    // Bottom up approach
    // Returning Array of Strings
    public static String[] findSubsequence(String str){
        if(str.length() == 0){
            return new String[]{""};
        }
        String[] smallAns = findSubsequence(str.substring(1));
        String[] ans = new String[2*smallAns.length];

        int k = 0;
        for(int i=0; i< smallAns.length; i++){
            ans[i] = smallAns[i];
            ans[i+smallAns.length] = str.charAt(0) + smallAns[i];
        }
        return ans;
    }

    // Returning ArrayList of String
    public static ArrayList<String> findSubsequence1(String str){
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> smallAns = findSubsequence1(str.substring(1));
        int n = smallAns.size();

        for(int i=0; i< n; i++){
            smallAns.add(str.charAt(0) + smallAns.get(i));
        }
        return smallAns;
    }


//    Method 2 (Pick and Don’t Pick Concept) : Top to Down approach
    // use this approach to print the subsequence

    //global variable (class data member)
    public static ArrayList<String> subS = new ArrayList<>();

    public static void findSubsequence2(String str, String ouputSoFar){
        if(str.length() == 0){
            subS.add(ouputSoFar);
            return;
        }
        // don't pick the first char
        findSubsequence2(str.substring(1), ouputSoFar);
        // pick the first char
        findSubsequence2(str.substring(1), ouputSoFar + str.charAt(0));
    }

    public static void main(String[] args) {
        String str = "xyz";
        String[] subsequence = findSubsequence(str);
        System.out.println(Arrays.toString(subsequence));

        ArrayList<String> subsequence1 = findSubsequence1(str);
        System.out.println(subsequence1.toString());

        System.out.println(subS.toString());
        findSubsequence2(str, "");
        System.out.println(subS.toString());

    }

}
