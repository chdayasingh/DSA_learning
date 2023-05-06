package BitManipulation;

public class bitOperator {

//    & bitwise and
//    | bitwise or
//    ^ bitwise xor
//    << left shift   a<<b = a * 2kiPowerb
//    >> right shift  a>>b = a / 2kiPowerb

    public static boolean checkEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            return true;
        }
        return false;
    }

//    left shift the mask by i value and do bitwise AND
    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        return ((n & bitMask) == 0) ? 0 : 1;

    }

    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);

        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit){
//        if(newBit == 0){
//            return clearIthBit(n, i);
//        }
//        else {
//            return setIthBit(n, i);
//        }

        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask; // n | 0 = n
    }

    public static int clearIBits(int n, int i){
        int bitMask = (-1)<<i;
        return n & bitMask;
    }

    public static int clearRangeOfBits(int n, int i, int j){
        int a = (~0)<<j+1;   // or -1<<j+1
        int b = (1<<i) - 1; // ((int) Math.pow(2, i)) - 1;
        int bitmask = a | b;
//        System.out.println(bitmask);

        return n & bitmask;
    }




    public static void main(String[] args) {
//        System.out.println(checkEven(5));
//        System.out.println(checkEven(6));
//        System.out.println(getIthBit(10, 3));
//        System.out.println(setIthBit(10, 2));
//        System.out.println(clearIthBit(10, 1));
//        System.out.println(updateIthBit(10, 1, 0));
//        System.out.println(clearIBits(15, 2));
        System.out.println(clearRangeOfBits(77, 1, 4));

    }
}
