package Recursion;

public class RecursionWithStrings {

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

    public static String removeConsecutiveDuplicates(String str){
        // base case is length 1 because we are comparing charAt(0) of smallAns with string (so it must be minimum 1 character)
        if (str.length() <= 1){
            return str;
        }

        String smallAns = removeConsecutiveDuplicates(str.substring(1));

        if(str.charAt(0) == smallAns.charAt(0)){
            return smallAns;
        }
        return str.charAt(0) + smallAns;
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


//    Further exercise: How would you change these codes to accommodate for negative values, i.e. convert “-487” to -487, etc.
    public static int stringToInt(String str){
        if(str.length() == 0){
            return 0;
        }
//        if(str.length() == 1){
//            return str.charAt(0) - '0';
//        }
        int smallAns = stringToInt(str.substring(0, str.length()-1));

        return (smallAns*10) + str.charAt(str.length()-1) - '0';
    }

    // eg- "1234"  => us-"1" , recursion-"234"
    public static int stringToInt1(String str){
        // Base case
        if(str.length() == 0){
            return 0;
        }
        int smallAns = stringToInt1(str.substring(1));

        if (str.charAt(0) == '-') {
            return -1 * smallAns;
        }
        int multiplier = (int)Math.pow(10, str.length()-1);
        return ((str.charAt(0)-'0') * multiplier) + smallAns;
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


    public static void main(String[] args) {
        String str = "aaaxbbxcsaxaxx";
//        System.out.println(removeAllOccuranceOfX(str, 'x'));
//        System.out.println(replaceCharacter("abc", 'x', 'X'));

        System.out.println(removeConsecutiveDuplicates(str));

//        System.out.println(replacePi("pip"));

        System.out.println(stringToInt("123004")); // not work for string containing negative num
        System.out.println(stringToInt1("-123004"));

//        System.out.println(pairStar("aaaa"));
//        System.out.println(pairStar("helllo"));
    }
}
