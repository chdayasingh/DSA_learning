package OOP;

public class ComplexNumberUse {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2,-3);
        ComplexNumber c2 = new ComplexNumber(5,-7);
        c1.print();
        c2.print();
        ComplexNumber c3 = ComplexNumber.add(c1,c2);
        c3.print();
        c3 = ComplexNumber.multiply(c1,c2);
        c3.print();
    }
}
