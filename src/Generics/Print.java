package Generics;

// print generic method(which can print array items of any type) and bound generic

import Inheritance.Car;

public class Print {
    // This method only accept array of Integer type
    public static<T extends Integer> void print(T[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // accepts array of Pair type
    public static<T extends Pair> void print(T[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i].print();
        }
        System.out.println();
    }
    // accepts array of class types whose implement PrintInterface (who sign the printInterface contract)
    public static<T extends PrintInterface> void print(T[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i].print();
        }
    }
    public static void main(String[] args) {
        Integer a1[] = {1,2,3,4,5};
        print(a1);

//        Array of Pair type
        Pair[] a2 = new Pair[5];
        for(int i=0; i<a2.length; i++){
            a2[i] = new Pair<Integer, Double>(i+1,i+0.5);
        }
        print(a2);

        Car[] a3 = new Car[5];
        for(int i=0; i<a3.length; i++){
            a3[i] = new Car();
        }
        print(a3);
    }
}
