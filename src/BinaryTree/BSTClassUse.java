package BinaryTree;

public class BSTClassUse {
    public static void main(String[] args) {
        BST bst1 = new BST();
//        int[] arr = {8,5,10,2,6,7};

        int[] arr = {10,5,15,3,7,18};

        for(int i: arr){
            bst1.insert(i);
        }

//        System.out.println((bst1.isPresent(3)));

//        bst1.insert(8);
        bst1.printTree();
//        System.out.println("Size before deleting : " + bst1.size());
//        System.out.println(bst1.deleteData(8));
//        bst1.printTree();
//        System.out.println("Size after deleting : " + bst1.size());

        System.out.println();

        System.out.println(bst1.giveElementsInRange(1,100));
    }
}
