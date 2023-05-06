package Exceptions;

public class ExceptionDemo {
    public static int divide(int a, int b) throws DivideByZeroException{
        if(b ==0){
//            throw new ArithmeticException();
            throw new DivideByZeroException();
        }
        int res = a/b;
        return res;
    }
    public static void main(String[] args) {
        try {
            divide(10,0);
            System.out.println("Within Try");
        } catch (DivideByZeroException e) {
            System.out.println("You are trying to divide by zero");
//            throw new RuntimeException(e);
        }
        System.out.println("Main");
//        String str = "";
//        try{
//            System.out.println(str.charAt(1));
//        }catch (Exception e){
//            System.out.println("String out of bound");
//        }

    }
}
