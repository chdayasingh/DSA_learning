package BinaryTree;

import java.util.Scanner;

public class BuildTree {
    private static BTNode<Integer> buildTreeUsingInPreHelper(int inorder[], int preorder[], int siIn, int eiIn, int siPre, int eiPre){
        if(siIn > eiIn){
            return null;
        }
        int rootData = preorder[siPre];
        BTNode<Integer> root = new BTNode<>(rootData);
        // search rootData in inOrder and find the index;
        int rootIndex = -1;
        for(int i = siIn; i<=eiIn; i++){
            if(inorder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        // finding range of inorder and preorder for left subtree and right subtree
        int siInLeft = siIn;
        int eiInLeft = rootIndex-1;
        int siPreLeft = siPre + 1;
        int siInRight = rootIndex+1;
        int eiInRight = eiIn;
        int eiPreRight = eiPre;

        int leftSubTreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubTreeLength - 1;
        int siPreRight = eiPreLeft + 1;

        root.left = buildTreeUsingInPreHelper(inorder, preorder, siInLeft ,eiInLeft, siPreLeft, eiPreLeft);
        root.right = buildTreeUsingInPreHelper(inorder, preorder, siInRight ,eiInRight, siPreRight, eiPreRight);

        return root;
    }

    public static BTNode<Integer> buildTreeUsingInPre(int inorder[], int preorder[], int n) {
        return buildTreeUsingInPreHelper(inorder, preorder, 0, n-1, 0, n-1);

//        1.find root using preorder[0]
//        2.find the pre & in of left subtree & the right subtree
//        3.Ask recurion to build leftSubtree and rightSubtree
    }

    public static BTNode<Integer> buildTreeUsingInPost(int inorder[], int postorder[], int n){
        return buildTreeUsingInPostHelper(inorder, postorder, 0, n-1, 0, n-1);
    }

    private static BTNode<Integer> buildTreeUsingInPostHelper(int[] inorder, int[] postorder, int siIn, int eiIn, int siPost, int eiPost) {
        if(siIn > eiIn){
            return null;
        }
        int rootData = postorder[eiPost];
        BTNode<Integer> root = new BTNode<>(rootData);
        // search rootData in inOrder and find the index;
        int rootIndex = -1;
        for(int i = siIn; i<=eiIn; i++){
            if(inorder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        // finding range of inorder and postorder for left subtree and right subtree
        int siInLeft = siIn;
        int eiInLeft = rootIndex-1;
        int siInRight = rootIndex+1;
        int eiInRight = eiIn;

        int siPostLeft = siPost;
        int eiPostRight = eiPost-1;

        int leftSubTreeLength = eiInLeft - siInLeft + 1;

        int eiPostLeft = siPostLeft + leftSubTreeLength - 1;
        int siPostRight = eiPostLeft + 1;

        root.left = buildTreeUsingInPostHelper(inorder, postorder, siInLeft ,eiInLeft, siPostLeft, eiPostLeft);
        root.right = buildTreeUsingInPostHelper(inorder, postorder, siInRight ,eiInRight, siPostRight, eiPostRight);

        return root;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inorder = {4,2,5,1,6,3};
        int[] preorder = {1,2,4,5,3,6};
        int[] postorder = {4, 5, 2, 6, 3, 1};

//        BTNode<Integer> root = buildTreeUsingInPre(inorder, preorder, inorder.length);
//        BTUse.printDetailedTreeLevelWise(root);

        BTNode<Integer> root = buildTreeUsingInPost(inorder, postorder, inorder.length);
        BTUse.printDetailedTreeLevelWise(root);


    }
}
