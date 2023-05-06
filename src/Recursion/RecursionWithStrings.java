package Recursion;

public class RecursionWithStrings {
    public static void main(String[] args) {
        String str = "axcsaxaxx";
//        System.out.println(removeAllOccuranceOfX(str, 'x'));
//        System.out.println(replaceCharacter("abc", 'x', 'X'));

//        System.out.println(replacePi("pip"));

//        System.out.println(stringToInt("123004"));

//        System.out.println(pairStar("aaaa"));
//        System.out.println(pairStar("helllo"));
        System.out.println(checkAB("abbabbaaabba"));
    }


    public static String removeAllOccuranceOfX(String str, char x) {
        if(str.length() == 0){
            return "";
        }
        if(str.charAt(0) == x){
            return removeAllOccuranceOfX(str.substring(1), x);
        }
        return str.charAt(0) + removeAllOccuranceOfX(str.substring(1),x);
    }

    public static String replaceCharacter(String str, char c1, char c2){
        if(str.length() == 0){
            return "";
        }
        if(str.charAt(0) == c1){
            return c2 + replaceCharacter(str.substring(1), c1, c2);
        }
        return str.charAt(0) + replaceCharacter(str.substring(1),c1,c2);
    }

    public static String replacePi(String str){
        if(str.length() <= 1){
            return str;
        }

        if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            return "3.14" + replacePi(str.substring(2));
        }

        return str.charAt(0) + replacePi(str.substring(1));
    }

    public static int stringToInt(String str){
        if(str.length() == 0){
            return -1;
        }
        if(str.length() == 1){
            return str.charAt(0) - '0';
        }
        int smallAns = stringToInt(str.substring(0, str.length()-1));

        return (smallAns*10) + str.charAt(str.length()-1) - '0';
    }

    // helloo -> hel*lo*o
    public static String pairStar(String str){
        if(str.length() <= 1){
            return str;
        }
        String smallOutput = pairStar(str.substring(0, str.length()-1));
        char lastChar = str.charAt(str.length()-1);
        if(smallOutput.charAt(smallOutput.length()-1) == lastChar){
            return smallOutput + "*" + lastChar;
        }
        return smallOutput + lastChar;
    }


    // Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
    //a. The string begins with an 'a'
    //b. Each 'a' is followed by nothing or an 'a' or "bb"
    //c. Each "bb" is followed by nothing or an 'a'
    //If all the rules are followed by the given string, return true otherwise return false.

    private static boolean checkABHelper(String str){
        if(str.length() == 0){
            return true;
        }
        if(str.charAt(0) == 'a'){
            return checkABHelper(str.substring(1));
        }
        else if(str.charAt(0) == 'b'){
            if(str.length() > 1 && str.charAt(1) == 'b'){
                if(str.length() > 2 && str.charAt(2) == 'b'){
                    return false;
                }
                return checkABHelper(str.substring(2));
            }
        }
        return false;
    }

    public static boolean checkAB(String str){
        if(str.charAt(0) != 'a'){
//            System.out.println("String not start with a");
            return false;
        }
        return checkABHelper(str.substring(1));
    }
}
