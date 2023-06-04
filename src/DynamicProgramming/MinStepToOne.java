package DynamicProgramming;

import java.util.Arrays;

public class MinStepToOne {

    // Greedy Approach (Doesn’t work always): eg for n=10 it gives steps= 4 but optimal is 3
    private static int minStepToOneGreedy(int n) {
        if(n == 1){
            return 0;
        }

        if(n%3 == 0){
            return 1 + minStepToOneGreedy(n/3);
        }
        if(n%2 == 0){
            return 1 + minStepToOneGreedy(n/2);
        }
        return 1 + minStepToOneGreedy(n-1);
    }

//    T.C => O(3^n)
    public static int minStepToOneBruteForce(int n){
        if(n == 1){
            return 0;
        }

        int subractByOne = minStepToOneBruteForce(n-1);
        int divideByTwo = Integer.MAX_VALUE;
        int divideByThree = Integer.MAX_VALUE;

        if(n%3 == 0){
            divideByThree = minStepToOneBruteForce(n/3);
        }
        if(n%2 == 0){
            divideByTwo = minStepToOneBruteForce(n/2);
        }

        return 1 + Math.min(subractByOne, Math.min(divideByTwo, divideByThree));
    }

    public static int minStepToOneDP(int n, int[] prevResults) {
        if(n == 1){
            return 0;
        }

        if(prevResults[n] != -1){
            return prevResults[n];
        }

        int subractByOne;
        int divideByTwo = Integer.MAX_VALUE;
        int divideByThree = Integer.MAX_VALUE;

        subractByOne = minStepToOneDP(n-1, prevResults);

        if(n%2 == 0){
            divideByTwo =  minStepToOneDP(n/2, prevResults);
        }
        if(n%3 == 0){
            divideByThree =  minStepToOneDP(n/3, prevResults);
        }
        // store the result in the array
        prevResults[n] = 1 + Math.min(subractByOne, Math.min(divideByTwo, divideByThree));
        return prevResults[n];
    }

    public static int minStepToOneIterative(int n){
        int[] prevResults = new int[n+1];

        prevResults[1] = 0;

        for(int i=2; i<prevResults.length; i++){
            int steps = prevResults[i-1];
            if(i%2 == 0){
                steps = Math.min(steps, prevResults[i/2]);
            }
            if(i%3 == 0){
                steps = Math.min(steps, prevResults[i/3]);
            }
            steps += 1;
            prevResults[i] = steps;
        }
//        System.out.println(Arrays.toString(prevResults));

        return prevResults[n];
    }

    public static void main(String[] args) {
//        System.out.println(minStepToOneGreedy(10));
//        System.out.println(minStepToOneBruteForce(10));

        int[] prevResults = new int[10+1];
        for(int i=0; i<prevResults.length; i++){
            prevResults[i] = -1;
        }
        System.out.println((minStepToOneDP(10, prevResults)));
//        System.out.println(Arrays.toString(prevResults));

        System.out.println(minStepToOneIterative((10)));

    }

}
