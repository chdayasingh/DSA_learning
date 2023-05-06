package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BracketsProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(checkBracketsBalanced(str));
        System.out.println(checkRedundantBrackets(str));
    }

    public static boolean checkBracketsBalanced(String str) {
//        Sample Input 1 :
//        (()()())
//        Sample Output 1 :
//        true
//        Sample Input 2 :
//        ()()(()
//        Sample Output 2 :
//        false
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char item = str.charAt(i);
            if(item == '('){
                s.push(item);
            }
            else if(item == ')'){
                if(s.isEmpty()) return false;

                s.pop();
            }
        }
        return s.isEmpty();
    }

    public static boolean checkRedundantBrackets(String str){
        // we are checking the bracket pair is contains atleast one opertor or not, if not than its redundant
        char[] arr = str.toCharArray();
        Stack<Character> s = new Stack<>();
        for(char i : arr){
            if(i == ')'){
                if(s.peek() == '('){
                    return true;
                }
                boolean hasOperator = false;
                while(s.peek() != '('){
                    if (s.peek() == '+' || s.peek() == '-' || s.peek() == '*' || s.peek() == '/') {
                        hasOperator = true;
                    }
                    s.pop();
                }
                // if the bracket pair contains no operator then its redundant
                if(!hasOperator){
                    return true;
                }
                s.pop();
            }
            else {
                s.push(i);
            }
        }
        return false;
    }
}
