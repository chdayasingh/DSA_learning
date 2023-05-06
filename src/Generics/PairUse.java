package Generics;

public class PairUse {
    public static void main(String[] args) {
        Pair<Integer, Double> p1 = new Pair<>(1,2.1);
        System.out.println(p1.first + " " + p1.second);

        Pair<Integer, Pair<Integer, Integer>> p2 = new Pair<>(1,new Pair<>(2,3));
        System.out.println(p2.first + " " + p2.second.first + " " + p2.second.second);




//        Pair<String, Integer> p = new Pair<>();
//        p.first = "daya";
//        p.second = 24;
//        System.out.println(p.first);
//        System.out.println(p.second);

//        Chained Generics
//        Pair<Pair<String,Integer>,Integer> p1 = new Pair<>();
//        p1.first = new Pair<>();
//        p1.first.first = "daya";
//        p1.first.second = 23;
//        System.out.println(p1.first + " " + p1.first.first + " " + p1.first.second);
//
//        p1.second = 24;
//        System.out.println(p1.second);
    }
}
