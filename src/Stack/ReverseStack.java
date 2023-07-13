package Stack;

import java.util.Stack;

public class ReverseStack {
    // we have to reverse stack element and placed back to in orginal stack with the help of only one helper stack/no data structure

    // using recursion
    public static void reverseStackR(Stack<Integer> stk) {
        if(stk.size() <= 1){
            return;
        }
        int temp = stk.pop();
        reverseStackR(stk);
        // insert temp to the bottom of stack using helper stack
        insertAtBottomOfStackR(stk, temp);

    }

    // using 1 stack
    private static void insertAtBottomOfStack(Stack<Integer> stk, int temp) {
        Stack<Integer> helper = new Stack<>();
        while(!stk.isEmpty()){
            helper.push(stk.pop());
        }
        stk.push(temp);
        while(!helper.isEmpty()){
            stk.push(helper.pop());
        }
    }

    // using recursion
    private static void insertAtBottomOfStackR(Stack<Integer> stk, int data){
        if(stk.isEmpty()){
            stk.push(data);
            return;
        }
        int temp = stk.pop();
        insertAtBottomOfStackR(stk, data);
        stk.push(temp);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        Stack<Integer> stk = new Stack<>();
        for(int i : arr){
            stk.push(i);
        }
        System.out.println(stk);
        reverseStackR(stk);
        System.out.println(stk);
    }


}
