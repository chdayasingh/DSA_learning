import java.util.Arrays;
import java.util.Scanner;

//Given two positive numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find product of these two numbers.

public class MultiplyTwoString {
    public static String multiplyStrings(String a, String b) {

        int m = a.length();
        int n = b.length();

        // either is zero
        if (a.equals("0") || b.equals("0")) {
            return "0";
        }

        int[] result = new int[m + n];

        int index = 0;
        for (int i=n-1; i >= 0; i--) {
            int carry = 0;
            int indexCopy = index;
            for (int j=m-1; j >= 0; j--) {
                int digitA = a.charAt(j) - '0';
                int digitB = b.charAt(i) - '0';
                int mul = digitA * digitB;
                mul += carry;

                carry = mul / 10;

                int newRes = result[indexCopy] + mul % 10;
                result[indexCopy] = newRes % 10;
                result[indexCopy + 1] += newRes / 10;

                indexCopy++;
            }
            result[indexCopy] += carry;
            index++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = m + n - 1; i >= 0; i--) {
            if (i == m + n - 1 && result[i] == 0) {
                continue;
            }
            ans.append(result[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(multiplyStrings(a, b));
    }
}
