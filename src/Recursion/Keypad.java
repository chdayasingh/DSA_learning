package Recursion;

import java.util.ArrayList;

public class Keypad {

//    Return Keypad Code
//
//    Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
//    Return empty string for numbers 0 and 1.


    // utility function - takes a single digit number and gives the possible chars can be formed by pressing the number as string
    private static String possibleCharsOfSingleDigit(int n){
        if(n < 2 || n > 9){
            System.exit(0);
        }
        if(n == 2){
            return "abc";
        }
        else if(n == 3){
            return "def";
        }
        else if(n == 4){
            return "ghi";
        }else if(n == 5){
            return "jkl";
        }else if(n == 6){
            return "mno";
        }else if(n == 7){
            return "pqrs";
        }else if(n == 8){
            return "tuv";
        }
        else{
            return "wxyz";
        }
    }


    // Recursive- Bottom up approach
    // split - 123 =>  12 3
    // TC: T(n) = T(n-1) + (n-1)*3*3  Need to solve
    public static ArrayList<String> findPossibleWords(int num) {
        if(num == 0){
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }

        ArrayList<String> smallAns = findPossibleWords(num/10);
        ArrayList<String> ans = new ArrayList<>();

        String possibleChars = possibleCharsOfSingleDigit(num%10);

        for(String i: smallAns){
            for(int j=0; j<possibleChars.length(); j++){
                ans.add(i + possibleChars.charAt(j));
            }
        }
        return ans;
    }

    // Top to Down approach (solved at gfg)
//    public static ArrayList<String> findPossibleWords(int num, String ans){
//
//    }




    public static void main(String[] args) {
        ArrayList<String> permutation = findPossibleWords(23);
        System.out.println(permutation.toString());
    }
}
