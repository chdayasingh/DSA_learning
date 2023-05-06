public class PoweMod {
    public static void main(String[] args) {
        long x = 7;
        long n = 123456789;
        long m = 1000000007;
        long result = powerMod(x, n, m);
        System.out.println(x + " to the power " + n + " modulo " + m + " = " + result);
    }

    private static long powerMod(long x, long n, long m) {
        if(n == 0){
            return 1%m;
        }

        long smallOutput = powerMod(x, n/2, m);
        if(n % 2 == 0){
            return (smallOutput * smallOutput) % m;
        }
        return (smallOutput * smallOutput * x) % m;
    }


}
