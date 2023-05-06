package OOP;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.setCoefficients(2,1);
        p1.setCoefficients(0,5);
        p1.print();
        System.out.println(p1.getDegree());
        System.out.println(p1.evaluate(10));

        Polynomial p2 = new Polynomial();
        p2.setCoefficients(0,3);
        p2.setCoefficients(1,6);
        p2.setCoefficients(2,2);
        p2.print();

        Polynomial p3 = Polynomial.addTwoPolynomial(p1,p2);
        p3.print();
    }
}
