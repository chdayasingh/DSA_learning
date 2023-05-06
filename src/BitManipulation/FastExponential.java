package BitManipulation;

public class FastExponential {
    public static int fastExpoCal(int a, int n){
        // a ki power n
        // expected TC = O(logn)

        int ans = 1;

        String binaryN = Integer.toBinaryString(n);
//        System.out.println(binaryN);

        for(int i=binaryN.length()-1; i>=0; i--){
            if(binaryN.charAt(i) == '1'){
                ans *= a;
            }
            a = a*a;
        }
        return ans;
    }

    // without computing binary value
    public static int fastExpoCal1(int a, int n){
        int ans = 1;

        while(n > 0){
            if((n & 1) == 1){ // checking LSB
                ans *= a;
            }
            a = a*a;
            n = n>>1; // updating n
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastExpoCal(3, 5));
        System.out.println(fastExpoCal1(3, 5));
    }
}
