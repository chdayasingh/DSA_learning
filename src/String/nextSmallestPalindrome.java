package String;

import java.util.Scanner;

public class nextSmallestPalindrome {
    public static boolean checkPalindrome(long input){
        long inputReverse = 0;
        long inputCopy = input;
        while(inputCopy > 0){
            int digit = (int)inputCopy%10;
            inputReverse = inputReverse*10 + digit;
            inputCopy /= 10;
        }
        return input == inputReverse;
    }

    // Time limit exceed
    public static String nextSmallestPalindrome1(String number) {
        long num = Long.parseLong(number);
        num++;
        while(!checkPalindrome(num)){
            num++;
        }
        return String.valueOf(num);
    }

    public static String nextSmallestPalindrome2(String number){
        char[] arr = number.toCharArray();
        int n = arr.length;

        // check if all are 9s


        // length is odd
        if(n %2 != 0){
            int mid = n/2;
            if(arr[mid] != '9'){
                arr[mid]++;
            }
            else {
                arr[mid] = '0';
                arr[mid-1]--;
                arr[mid+1]++;
            }
        }
        // length is even
        else{
            int mid2 = n/2;
            int mid1 = mid2-1;

            if(arr[mid1] == '9'){
                arr[mid1] = 0;
                arr[mid2] = 0;
                arr[mid1-1]++;
                arr[mid2-1]++;
            }
            else {
                arr[mid1]++;
                arr[mid2]++;
            }
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
//        System.out.println(checkPalindrome(11223344));
        System.out.println(nextSmallestPalindrome1(input));
        System.out.println(nextSmallestPalindrome2(input));
    }
}
