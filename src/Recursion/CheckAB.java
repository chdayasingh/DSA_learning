package Recursion;

public class CheckAB {
    // Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
    //a. The string begins with an 'a'
    //b. Each 'a' is followed by nothing or an 'a' or "bb"
    //c. Each "bb" is followed by nothing or an 'a'
    //If all the rules are followed by the given string, return true otherwise return false.

    public static boolean checkAB(String str){
        if(str.charAt(0) != 'a'){
//            System.out.println("String not start with a");
            return false;
        }
        return checkABHelper(str.substring(1));
    }

    private static boolean checkABHelper(String str){
        if(str.length() == 0){
            return true;
        }
        if(str.charAt(0) == 'a'){
            return checkABHelper(str.substring(1));
        }
        if(str.charAt(0) == 'b' && str.length() > 1 && str.charAt(1) == 'b'){
            if(str.length() > 2 && str.charAt(2) == 'b'){
                return false;
            }
            return checkABHelper((str.substring(2)));
        }
        return false;
    }

    public static boolean checkAB1(String str, String previous){
        if(str.length() == 0){
            return true;
        }
        if(previous.equals("bb") && str.charAt(0) != 'a'){
            return false;
        }
        if(str.charAt(0) == 'b') {
            if(str.length() < 2 || str.charAt(1) != 'b'){
                return false;
            }
        }

        if(str.charAt(0) == 'a'){
            return checkAB1(str.substring(1), "a");
        }
        return checkAB1(str.substring(2), "bb");
    }

    public static void main(String[] args) {
        System.out.println(checkAB("abbabbaaabba"));
        System.out.println(checkAB("abb"));
        System.out.println(checkAB("abababa"));

        // passing initially previous as "bb" so the first leter must start with "a"
        System.out.println(checkAB1("abbabbaaabba", "bb"));
        System.out.println(checkAB1("abb", "bb"));
        System.out.println(checkAB1("abababa", "bb"));
    }
}
