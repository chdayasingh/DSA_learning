package OOPs;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator == 0){
            // Throw error
            denominator = 1;
        }
        this.denominator = denominator;
        simplify(); // to save fraction in simplest form
    }

    private void simplify() {
        int gcd = 1;
        int smaller = Math.min(this.numerator, this.denominator);
        for(int i=2; i<=smaller; i++){
            if(numerator%i == 0 && denominator%i == 0){
                gcd = i;
            }
        }
        numerator = numerator/gcd;
        denominator = denominator/gcd;
    }

    public void increment(){
        numerator = numerator + denominator;
        simplify();
    }

    public void add(Fraction f2){
        // First fraction is the fraction on which function is called
        // Second fraction is passed

        this.numerator = this.numerator*f2.denominator + f2.numerator*this.denominator;
        this.denominator = this.denominator*f2.denominator;
        simplify();
    }

    public static Fraction add(Fraction f1, Fraction f2){
        int newNum = f1.numerator*f2.denominator + f2.numerator*f1.denominator;
        int newDen = f1.denominator*f2.denominator;
        Fraction f3 = new Fraction(newNum, newDen);
        return f3;
    }

    public void print() {
        System.out.println(this.numerator + "/" + this.denominator);
    }
}
