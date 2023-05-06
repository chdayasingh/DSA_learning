package Exceptions;


public class ExceptionHandling {
    public static int divide(int num,int den) throws DivideByZeroException {
        if(den == 0){
            throw new DivideByZeroException();
        }
        return num/den;
    }

    public static void main(String[] args)  {
        try{
            int a = divide(2,1);
            System.out.println("In try");
        }
        catch (DivideByZeroException e){
            System.out.println("In catch");
        }
        System.out.println("Main");

    }
}
