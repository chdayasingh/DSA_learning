package OOP;

public class FractionUse {
    public static void main(String[] args) {
         Fraction f1 = new Fraction(2,3);
//         f1.setNumerator(3);
//         f1.setDenominator(0);
         f1.printFraction();
//         f1.increment();
//         f1.printFraction();
//        f1.simplify();
//        f1.printFraction();
        Fraction f2 = new Fraction(1,2);
        f2.printFraction();
//        f1.addFraction(f2);
//        f1.printFraction();
        Fraction f3 = Fraction.addTwoFraction(f1,f2);
        f3.printFraction();
    }
}
