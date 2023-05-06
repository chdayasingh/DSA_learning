package OOP;

public class ComplexNumber {
    private int real;
    private int imaginary;

    ComplexNumber(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void print(){
        System.out.print("("+real);
        if(this.imaginary >= 0)
            System.out.print("+");
        System.out.print(imaginary + "i)\n");
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
        int real = c1.real + c2.real;
        int imaginary = c2.imaginary + c1.imaginary;
        return new ComplexNumber(real, imaginary);
    }

    public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2){
        int real = (c1.real * c2.real) - (c1.imaginary * c2.imaginary);
        int imaginary = c2.imaginary + c1.imaginary;
        return new ComplexNumber(real, imaginary);
    }
}
