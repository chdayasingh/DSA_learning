package BinaryTree;

import java.util.Scanner;

public class DiameterOfBT {
    public static int height(BTNode<Integer> root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int diameterOfBinaryTree(BTNode<Integer> root) {
        if(root == null){
            return 0;
        }

        int option1 = height(root.left) + height(root.right);
        int option2 = diameterOfBinaryTree(root.left);
        int option3 = diameterOfBinaryTree(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    public static int diameterOfBinaryTree1(BTNode<Integer> root){
        int[] diameter = new int[1];
        diameterOfBinaryTree1Helper(root, diameter);
        return diameter[0];
    }

    private static void diameterOfBinaryTree1Helper(BTNode<Integer> root, int[] diameter) {
        if(root == null){
            return;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);

        diameterOfBinaryTree1Helper(root.left, diameter);
        diameterOfBinaryTree1Helper(root.right, diameter);
    }

    public static DiameterReturn diameterOfBinaryTreeBetter(BTNode<Integer> root) {
        if(root == null){
            return new DiameterReturn(0,0);
        }

        DiameterReturn leftOutput = diameterOfBinaryTreeBetter(root.left);
        DiameterReturn rightOutput = diameterOfBinaryTreeBetter(root.right);

        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        int diameter = Math.max(leftOutput.height + rightOutput.height, Math.max(leftOutput.diameter, rightOutput.diameter));

        return new DiameterReturn(height, diameter);
    }


    public static int diameterOfBinaryTreeBetter1(BTNode<Integer> root){
        int[] diameter = new int[1];
        diameterOfBinaryTreeBetter1Helper(root, diameter);
        return diameter[0];
    }

    // Return height
    // Post order
    public static int diameterOfBinaryTreeBetter1Helper(BTNode<Integer> root, int[] diameter){
        if(root == null){
            return 0;
        }
        int leftHeight = diameterOfBinaryTreeBetter1Helper(root.left, diameter);
        int rightHeight = diameterOfBinaryTreeBetter1Helper(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight+rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTNode<Integer> root = BTUse.takeTreeInputLevelWise(); // Dummy value : 1 2 3 4 -1 -1 5 -1 -1 -1 -1

        System.out.println("Diameter of the Tree: " + diameterOfBinaryTree(root));
        System.out.println("Diameter of the Tree (Better): " + diameterOfBinaryTreeBetter(root).diameter);
        System.out.println("Diameter of the Tree 1: " + diameterOfBinaryTree1(root));
        System.out.println("Diameter of the Tree (Better 1): " + diameterOfBinaryTreeBetter1(root));
    }
}
