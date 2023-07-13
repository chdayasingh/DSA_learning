package Stack;

import java.util.Stack;

public class InfixToPostFix {
    private static int precedence(char ch){
        if(ch == '+' || ch=='-'){
            return 1;
        }
        if(ch == '*' || ch=='/'){
            return 2;
        }
        if(ch == '^'){
            return 3;
        }
        return -1;

    }
    public static String infixToPostFix(String infix){
        Stack<Character> stk = new Stack<>();
        StringBuffer postfix = new StringBuffer();

        for(int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                postfix.append(ch);
            }
            else if (ch == '(') {
                stk.push(ch);
            }
            else if(ch == ')'){
                while(stk.peek() != '('){
                    postfix.append(stk.pop());
                }
                stk.pop();
            }
            else { // operand
                while(!stk.isEmpty() && precedence(ch) < precedence(stk.peek())){
                    postfix.append(stk.pop());
                }
                stk.push(ch);
            }
        }
        while(!stk.isEmpty()){
            postfix.append(stk.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostFix("(p+q)*(m-n)"));
        System.out.println(infixToPostFix(str));
    }
}
