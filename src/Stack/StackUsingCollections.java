package Stack;

import java.util.Stack;

public class StackUsingCollections {
    public static String reverseStringUsingStack(String str){
        if (str == null){
            throw new IllegalArgumentException();
        }

        Stack<Character> stack = new Stack<>();
        StringBuffer revStr = new StringBuffer();
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            revStr.append(stack.pop());
        }
        return revStr.toString();
    }

    public static void main(String[] args) {
//        Stack<Integer> s1 = new Stack<>();

        System.out.println(reverseStringUsingStack("abcd"));
    }
}
