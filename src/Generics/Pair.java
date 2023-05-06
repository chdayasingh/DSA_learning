package Generics;

public class Pair<T1, T2> {
    T1 first;
    T2 second;
    Pair(){}

    Pair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    public void print(){
        System.out.println("(" + this.first + ", " + this.second + ")");
    }

}
