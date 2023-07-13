package BinaryTree;

import java.util.Scanner;

public class MaxSumPath {
    public static int maxPathSum(BTNode<Integer> root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(BTNode<Integer> node, int maxValue[]) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTNode<Integer> root = BTUse.takeTreeInputLevelWise(); // Dummy value : 1 2 3 4 -1 -1 5 -1 -1 -1 -1

        System.out.println(maxPathSum(root));
    }
}
