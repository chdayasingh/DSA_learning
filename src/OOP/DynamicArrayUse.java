package OOP;

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray a1 = new DynamicArray();
        a1.print();
        System.out.println(a1.size());
        for(int i=0;i<5; i++){
            a1.add(i+1);
        }
//        a1.add(12,100);
        a1.set(2,100);
        a1.print();
        System.out.println(a1.size());


//        a1.add(10);
//        a1.print();
//        System.out.println(a1.size());
//        a1.add(3,100);
//        a1.print();
//        System.out.println(a1.size());

//        a1.set(0,10);
//        a1.print();
//        System.out.println(a1.size());
//        System.out.println(a1.isEmpty());
//        System.out.println(a1.get(0));
//        a1.removeLast();
//        a1.print();
//        System.out.println(a1.size());




    }
}
