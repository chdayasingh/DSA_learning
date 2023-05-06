package Stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        Stack<Integer> stk = new Stack<>();
        for(int i : arr){
            stk.push(i);
        }

        Stack<Integer> helper = new Stack<>();
        reverseStack(stk, helper);

        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
    }

    public static void reverseStack(Stack<Integer> stk, Stack<Integer> helper) {
        // we have to reverse stack element and placed back to in orginal stack with the help of only one helper stack
        // using recursion we can do this
        if(stk.size() <= 1){
            return;
        }
        int temp = stk.pop();
        reverseStack(stk, helper);
        // insert temp to the bottom of stack using helper stack
        insertAtBottomOfStack(temp, stk, helper);

    }

    private static void insertAtBottomOfStack(int temp, Stack<Integer> stk, Stack<Integer> helper) {
        while(!stk.isEmpty()){
            helper.push(stk.pop());
        }
        stk.push(temp);
        while(!helper.isEmpty()){
            stk.push(helper.pop());
        }
    }
}
