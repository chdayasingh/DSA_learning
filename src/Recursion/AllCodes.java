package Recursion;

import java.util.ArrayList;

public class AllCodes {

//    Return all codes - String
//    Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to return the list of all possible codes that can be generated from the given string.

//    https://www.geeksforgeeks.org/print-all-possible-decodings-of-a-given-digit-sequence/

    public static char getChar(int num){
        if(num < 1 || num > 26){
            return '\0';
        }
        return (char) (96+num);
    }


    // eg - 1123 => (1 123  and  11 23) combine the both result
    public static ArrayList<String> returnAllCodes(String num){
        if(num.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        ArrayList<String> ans = new ArrayList<>();

        char firstDigitChar = getChar(num.charAt(0) - '0');
        ArrayList<String> smallAns1 = returnAllCodes(num.substring(1));

        for(String i : smallAns1){
            ans.add(firstDigitChar + i);
        }

        // if firstTwoDigitChar not comes to valid alphabet then don't follow the path
        if(num.length() > 1){
            char firstTwoDigitChar = getChar(Integer.parseInt(num.substring(0,2)));
            if(firstTwoDigitChar != '\0'){
                ArrayList<String> smallAns2 = returnAllCodes(num.substring(2));

                for(String i : smallAns2){
                    ans.add(firstTwoDigitChar + i);
                }
            }
        }
        return ans;
    }

    // take decision of first char (single digit, or double) then rest recursion will care
    public static void printAllCodes(String num, String outputSoFar){
        if(num.length() == 0){
            System.out.println(outputSoFar);
            return;
        }
        char firstDigitChar = getChar(num.charAt(0) - '0');
        printAllCodes(num.substring(1), outputSoFar + firstDigitChar);
        if(num.length() > 1){
            char firstTwoDigitChar = getChar(Integer.parseInt(num.substring(0,2)));
            // if firstTwoDigitChar not comes to valid alphabet then don't follow the path
            if(firstTwoDigitChar != '\0')
                printAllCodes(num.substring(2), outputSoFar + firstTwoDigitChar);
        }
    }

    public static void main(String[] args) {
        // failing on this test case
        String str = "721023";
        printAllCodes(str, "");
        System.out.println();
        System.out.println(returnAllCodes(str));
    }
}
