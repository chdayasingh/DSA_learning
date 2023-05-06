package Recursion;

import java.util.HashMap;
import java.util.Scanner;

public class Recursion {
//    calculate power of a number TC-(logn)
//    eg 2^5 = 2.2^2.2^2
    public static long calPower(int n, int pow){
        if(pow == 0){
            return 1;
        }
        // calling calPower for only one time with half value
        long halfPower = calPower(n, pow/2);
        long smallOutput = halfPower*halfPower;

        if(pow%2 == 1){
            // odd power
            smallOutput *= n;
        }
        return smallOutput;
    }

/*Staircase
A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways the child can run up to the stairs. You need to return number of possible ways W.
 */

    public static HashMap<Integer, Integer> map = new HashMap<>();
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
        Scanner sc = new Scanner(System.in);

//        System.out.println(calPower(2,4));

        System.out.println(stairCase(5));
    }
}
