package Recursion;

import java.util.ArrayList;

public class BinaryStringWithNoConsecutive1s {
    static ArrayList<String> ans = new ArrayList<>();

    private static String toString(int[] arr){
        StringBuffer str = new StringBuffer();
        for(int i: arr){
            str.append(i);
        }
        return str.toString();
    }

    public static ArrayList<String> generateString(int k) {
        int[] bs = new int[k]; //binary string

        generateString(bs, 0, k);
        return ans;
    }

    public static void generateString(int[] bs, int i, int k){
        if(i == k){
            ans.add(toString(bs));
            return;
        }

        if(i == 0){ // first index
            bs[i] = 0;
            generateString(bs, i+1, k);
            bs[i] = 1;
            generateString(bs, i+1, k);
            return;
        }
        bs[i] = 0;
        generateString(bs, i+1, k);
        if(bs[i-1] != 1){
            bs[i] = 1;
            generateString(bs, i+1, k);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> ans = generateString(3);
        System.out.println(ans);
    }
}

