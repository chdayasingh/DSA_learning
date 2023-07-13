package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaHistogram {
    public static int[] nextRightSmallest(int[] arr){
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] nsr = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && arr[i] <= arr[stk.peek()]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nsr[i] = n;  // storing n instead of -1;
            }
            else{
                nsr[i] = stk.peek();
            }
            stk.push(i);
        }
        return nsr;
    }
    public static int[] nextLeftSmallest(int[] arr){
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] nsl = new int[n];

        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && arr[i] <= arr[stk.peek()]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nsl[i] = -1;  // storing n instead of -1;
            }
            else{
                nsl[i] = stk.peek();
            }
            stk.push(i);
        }
        return nsl;
    }

    public static int maxAreaHistogram(int[] arr){
        int[] nsr = nextRightSmallest(arr);
        int[] nsl = nextLeftSmallest(arr);

//        System.out.println(Arrays.toString(nsr));
//        System.out.println(Arrays.toString(nsl));

        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            max = Math.max(max, height*width);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(maxAreaHistogram(arr));
    }
}
