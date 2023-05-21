package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicProblems {

    public static int fact(int n){
        if(n == 0) {
            return 1;
        }
        return n * fact(n-1);
    }

    //    calculate power of a number TC-(logn)
    //    eg 2^5 = 2.2^2.2^2
    public static long calPower(int x, int pow){
        if(pow == 0){
            return 1;
        }
        // calling calPower for only one time with half value
        long halfPower = calPower(x, pow/2);
        long smallOutput = halfPower*halfPower;

        if(pow%2 == 1){
            // odd power
            smallOutput *= x;
        }
        return smallOutput;
    }

    public static void printNumber1toNIncreasing(int n){
        if(n==1){
            System.out.print(1 + " ");
            return;
        }
        printNumber1toNIncreasing(n-1);
        System.out.print(n + " ");
    }

    public static int numOfDigits(int n){
        // if num is single digit - then num of digit is 1
        // or n == 0 then return 0
        if(n>-10 && n<10){
            return 1;
        }
        return numOfDigits(n/10) + 1;
    }


//    TC - O(2^n)
    public static int nthFiboNum(int n){
        if(n < 1){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }

        return nthFiboNum(n-1);
    }

    public static boolean checkSorted(int[] arr, int i){
        // Base case
        if(i == arr.length-1){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }
        return checkSorted(arr, i+1);
    }

//    Linear Search recursive
    public static int firstIndexOf(int[] arr, int key, int startIndex){
        if(startIndex == arr.length){
            return -1;
        }
        if(arr[startIndex] == key){
            return startIndex;
        }
        return firstIndexOf(arr, key, startIndex+1);
    }

    private static int lastIndexOf(int[] arr, int key, int lastIndex) {
        if(lastIndex < 0){
            return -1;
        }
        if(arr[lastIndex] == key){
            return lastIndex;
        }
        return lastIndexOf(arr, key, lastIndex-1);
    }

    private static ArrayList<Integer> allIndicesOf(int[] arr, int key, int startIndex){
        if(startIndex == arr.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> smallOutput = allIndicesOf(arr, key, startIndex+1);

        if(arr[startIndex] == key){
            smallOutput.add(0, startIndex);
        }
        return smallOutput;
    }

    public static int countZero(int n){
        if(n < 10){
            return n==0? 1: 0;
        }
        int count = countZero(n/10);
        if(n%10 == 0){
            count++;
        }
        return count;
    }

    public static boolean isPalindrome(String str, int si, int ei){
        if(si >= ei){
            return true;
        }
        if(str.charAt(si) != str.charAt(ei)){
            return false;
        }
        return isPalindrome(str, si+1, ei-1);
    }


//    Geometric Sum
//    Given k, find the geometric sum i.e.
//1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)
    public static double geometricSum(int k){
        if(k==0){
            return 1;
        }
        return geometricSum(k-1) + 1/Math.pow(2, k);
    }

    public static void main(String[] args) {
//        System.out.println(fact(5));
//        System.out.println(calPower(2,10));
//        printNumber1toNIncreasing(10);
//        System.out.println(numOfDigits(1230));

        int arr[] = {1,2,3,4,4};
//        System.out.println(checkSorted(arr, 0));

//        System.out.println(firstIndexOf(arr, 4, 0));
//        System.out.println(lastIndexOf(arr, 4, arr.length-1));
//        System.out.println(allIndicesOf(arr, 4, 0).toString());

//        System.out.println(countZero(70080));

//        System.out.println(geometricSum(3));

        String str = "racecar";
//        System.out.println(isPalindrome(str, 0, str.length()-1));


    }



}
