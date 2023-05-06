package OOPs;

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();
        System.out.println("Array Size Before: "+d.size());
        for(int i=0; i<10; i++){
            d.add(i+100);
        }
        System.out.println("Array Size After: "+d.size());
        d.printHorizontally();
//        System.out.println("Element at Index 2: "+d.get(2));
        d.set(2,25);
        d.printHorizontally();
//        System.out.println("Element at Index 2: "+d.get(2));

        d.addAtIndex(3,26);
        d.printHorizontally();
        System.out.println(d.size());

//        while(!d.isEmpty()){
//            d.removeLast();
//            System.out.println("Now Array size- "+d.size());
//        }

    }
}
