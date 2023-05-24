package Recursion;

import java.util.HashMap;
import java.util.Scanner;

public class StairCase {

    /*Staircase
A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways the child can run up to the stairs. You need to return number of possible ways W.
 */

    // map to store the already computed result for better performance
    public static HashMap<Integer, Integer> map = new HashMap<>(); // key: value of n, value: possible ways
    public static int stairCase(int n){
        if(n == 0){ // you covered all the stairs
            return 1;
        }
        if(n < 0){
            return 0;
        }
        // if we already computed the ans for smallerOutput then return it
        if(map.containsKey(n)){
            return map.get(n);
        }
        // num of ways to climb stairs if i take 1 step
        int op1 = stairCase(n-1);
        map.put(n-1, op1);

        int op2 = stairCase(n-2);
        map.put(n-2, op2);

        int op3 = stairCase(n-3);
        map.put(n-3, op3);

        return op1 + op2 + op3;
    }

    public static void main(String[] args) {
        System.out.println(stairCase(5));
        System.out.println(stairCase(4));
    }
}
