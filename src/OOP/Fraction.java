package OOP;

public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }
    public void setNumerator(int numerator){
        this.numerator = numerator;
        simplify();
    }
    public void setDenominator(int denominator){
        if(denominator == 0){
            System.out.println("Denominator can't be zero");
            return;
        }
        this.denominator = denominator;
        simplify();
    }
    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }
    public void printFraction(){
        System.out.println(numerator + "/" + denominator);
    }
    public void simplify(){
        int gcd = 1;
        int smaller = Math.min(numerator,denominator);
        for(int i=2; i<=smaller; i++){
            if(numerator%i ==0 && denominator%i == 0){
                gcd = i;
            }
        }
        this.numerator /= gcd;
        this.denominator /=  gcd;
    }

    public void increment() {
        this.numerator = this.numerator + this.denominator;
        simplify();
    }

    public void addFraction(Fraction f){
         this.numerator = (this.numerator * f.denominator) + (this.denominator *  f.numerator);
         this.denominator = this.denominator * f.denominator;
         simplify();
    }
    public static Fraction addTwoFraction(Fraction f1,Fraction f2){
        int num = (f1.numerator * f2.denominator) + (f1.denominator *  f2.numerator);
        int den = f1.denominator * f2.denominator;
        return new Fraction(num,den);
    }
}
