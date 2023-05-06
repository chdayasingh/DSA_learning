package BitManipulation;

public class questions {
    public static boolean isPowerOf2(int n){
        // and of number and its previous number is 0 then its in the power of 2
        return (n & (n-1)) == 0;
    }

    public static int countSetBits(int n){
//        // without bit manipulation
//        String numInBinary = Integer.toBinaryString(n);
        int count = 0;
//        for (int i = 0; i < numInBinary.length(); i++) {
//            char c = numInBinary.charAt(i);
//            if( c == '1'){
//                count++;
//            }
//        }
//        return count;

//        TC - O(logn)
//        num of bits required to represent n in binary = logn + 1
        while(n >= 1){
            // get lsb
            int lsb = n & 1;
            if(lsb == 1){
                count++;
            }
            n = n>>1;
        }

        return count;
    }

    public static int incrementNumUsingBits(int n){
        return -(~n);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(63));
        System.out.println(countSetBits(11));
        System.out.println(incrementNumUsingBits(5));
        System.out.println(65 | 32);
        System.out.println((char) ('A' | ' '));
    }
}
