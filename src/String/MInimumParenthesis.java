package String;

import java.util.Scanner;

public class MInimumParenthesis {
    public static int minimumParentheses(String pattern) {
        // Write your code here.
        int open = 0;
        int close = 0;

        for(int i=0; i<pattern.length(); i++){
            char current = pattern.charAt(i);
            if(current == '('){
                open++;
            }
            else{
                close++;
            }
        }
        return Math.abs(open-close);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(minimumParentheses(str));
    }
}
