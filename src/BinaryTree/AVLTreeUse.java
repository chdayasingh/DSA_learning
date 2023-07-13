package BinaryTree;

public class AVLTreeUse {
    public static void main(String[] args) {
        AVLTree tree1 = new AVLTree();
        int[] arr = {1, 2, 3, 4, 5,6,7};
        for (int i : arr){
            tree1.insert(i);
        }
        System.out.println(tree1);
    }

}
