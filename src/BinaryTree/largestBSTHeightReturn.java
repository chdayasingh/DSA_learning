package BinaryTree;

public class largestBSTHeightReturn extends isBSTReturn{
    // height of the maximum bst
    int height;

    largestBSTHeightReturn(int min, int max, boolean isBST, int height) {
        super(min, max, isBST);
        this.height = height;
    }
}
