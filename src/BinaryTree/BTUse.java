package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import LinkedList.*;

public class BTUse {
    public static BTNode<Integer> takeTreeInput(Scanner sc){
        System.out.println("Enter the node : ");
        int data = sc.nextInt();
        BTNode<Integer> root = new BTNode<>(data);
        System.out.println("Enter num of children of " + root.data + " (0,1,2) : ");
        int children = sc.nextInt();
        if(children == 1){
            System.out.println("child is on left or right (l or r) : ");
            String str = sc.next();
            if(str.equals("r")){
                root.right = takeTreeInput(sc);
            } else {
                root.left = takeTreeInput(sc);
            }
        }
        else if(children == 2){
            root.left = takeTreeInput(sc);
            root.right = takeTreeInput(sc);
        }
        return root;
    }

    // improved (-1 means no child) but difficult to use for user
    public static BTNode<Integer> takeTreeInput1(Scanner sc){
        System.out.println("Enter root data: ");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BTNode<Integer> root = new BTNode<>(rootData);
        root.left = takeTreeInput1(sc);
        root.right = takeTreeInput1(sc);

        return root;
    }

    // user friendly recursive input
    // but it needs 3 extra arguments- isRoot, parentData, isLeft
    public static BTNode<Integer> takeTreeInput1Better(Scanner sc, boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data: ");
        }
        else if (isLeft){
            System.out.println("Enter left data of " + parentData + " : ");
        }
        else{
            System.out.println("Enter right data of " + parentData + " : ");
        }

        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        BTNode<Integer> root = new BTNode<>(data);
        root.left = takeTreeInput1Better(sc, false, data, true);
        root.right = takeTreeInput1Better(sc, false, data, false);

        return root;
    }

    // Non - recursive
    public static BTNode<Integer> takeTreeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root Data : ");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BTNode<Integer> root = new BTNode<>(rootData);
        Queue<BTNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            BTNode<Integer> parent = pendingNodes.poll();
            System.out.println("Enter left child of " + parent.data);
            int leftChildData = sc.nextInt();
            if(leftChildData != -1){
                BTNode<Integer> leftChild = new BTNode<>(leftChildData);
                parent.left = leftChild;
                pendingNodes.add(leftChild);
            }
            System.out.println("Enter right child of " + parent.data);
            int rightChildData = sc.nextInt();
            if(rightChildData != -1){
                BTNode<Integer> rightChild = new BTNode<>(rightChildData);
                parent.right = rightChild;
                pendingNodes.add(rightChild);
            }
        }
        return root;
    }

    public static void printDetailedTreeRecursive(BTNode<Integer> root) {
        if(root == null){
            return;
        }
        String s = root.data + ": ";
        if(root.left != null){
            s += "left-" + root.left.data + ", ";
        }
        if(root.right != null){
            s += "right-" + root.right.data;
        }
        System.out.println(s);

        printDetailedTreeRecursive(root.left);
        printDetailedTreeRecursive(root.right);
    }

    public static void printDetailedTreeLevelWise(BTNode<Integer> root) {
        if(root == null){
            return;
        }
        Queue<BTNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            BTNode<Integer> front = pendingNodes.poll();
            String s = front.data + ": ";
            if(front.left != null){
                s += "L-" + front.left.data + ", ";
                pendingNodes.add(front.left);
            }

            if(front.right != null){
                s += "R-" + front.right.data;
                pendingNodes.add(front.right);
            }
            System.out.println(s);
        }
    }

    // printing tree level wise - printing each level in different line
    // using two queues
    public static void printTreeLevelWise(BTNode<Integer> root) {
        if(root == null){
            return;
        }
        Queue<BTNode<Integer>> pendingNodes = new LinkedList<>();
        Queue<BTNode<Integer>> pendingNodes1 = new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            BTNode<Integer> front = pendingNodes.poll();
            System.out.print(front.data + " ");
            if(front.left != null){
                pendingNodes1.add(front.left);
            }
            if(front.right != null){
                pendingNodes1.add(front.right);
            }
            if(pendingNodes.isEmpty()){
                System.out.println();
                while(!pendingNodes1.isEmpty()){
                    pendingNodes.add(pendingNodes1.poll());
                }
            }
        }
    }

    public static void printTreeLevelWiseBetter(BTNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<BTNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while(!pendingNodes.isEmpty()){
            BTNode<Integer> front = pendingNodes.poll();
            if(front != null){
                System.out.print(front.data + " ");
                if(front.left != null){
                    pendingNodes.add(front.left);
                }
                if(front.right != null){
                    pendingNodes.add(front.right);
                }
            }
            else{
                if(!pendingNodes.isEmpty()){
                    System.out.println();
                    pendingNodes.add(null);
                }
            }
        }
        System.out.println();
    }
    public static void printTreePreOrder(BTNode<Integer> root) {
        if(root == null){
            return;
        }
        System.out.println(root.data);
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }

    public static void printTreePostOrder(BTNode<Integer> root) {
        if(root == null){
            return;
        }
        printTreePostOrder(root.left);
        printTreePostOrder(root.right);
        System.out.println(root.data);
    }

    public static void printTreeInOrder(BTNode<Integer> root) {
        if(root == null){
            return;
        }
        printTreeInOrder(root.left);
        System.out.println(root.data);
        printTreeInOrder(root.right);
    }

    public static int numNodes(BTNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 1;
        count += numNodes(root.left);
        count += numNodes(root.right);
        return count;
    }

    public static int largest(BTNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int leftLargest = largest(root.left);
        int rightLargest = largest(root.right);

        return Math.max(root.data, Math.max(leftLargest, rightLargest));
    }

    public static int nodesGreaterThanX(BTNode<Integer> root, int x) {
        if(root == null){
            return 0;
        }
        if(root.data > x){
            return 1 + nodesGreaterThanX(root.left, x) + nodesGreaterThanX(root.right, x);
        }
        return nodesGreaterThanX(root.left, x) + nodesGreaterThanX(root.right, x);
    }

    public static int height(BTNode<Integer> root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int leafCount(BTNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return leafCount(root.left) + leafCount(root.right);
    }

    public static void printNodesAtDepthK(BTNode<Integer> root, int k){
        if(k<0) return;
        if(root == null) return;
        if(k == 0){
            System.out.print(root.data + " ");
            return;
        }
        printNodesAtDepthK(root.left, k-1);
        printNodesAtDepthK(root.right, k-1);
    }

    public static void printNodesWithoutSibling(BTNode<Integer> root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right != null){
            System.out.println(root.right.data);
        }
        else if(root.left != null && root.right == null){
            System.out.println(root.left.data);
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        BTNode<Integer> root = takeTreeInput(sc);
//        BTNode<Integer> root = takeTreeInput1(sc);
        BTNode<Integer> root = takeTreeInputLevelWise(); // Dummy value : 1 2 3 4 -1 -1 5 -1 -1 -1 -1

//        BTNode<Integer> root = takeTreeInput1Better(sc, true, 0,false);
//        printDetailedTreeRecursive(root);
//        printDetailedTreeLevelWise(root);
//        System.out.println("Num of Nodes in the Tree : " + numNodes(root));
//        System.out.println("Num of leaf nodes : " + leafCount(root));

//        printTreePreOrder(root);
//        System.out.println();
//        printTreePostOrder(root);
//        printTreeInOrder(root);

//        System.out.println("Largest in the Tree: "+ largest(root));
//        System.out.println("Num of nodes greater than 5 : " + nodesGreaterThanX(root, 5));

//        System.out.println("Tree Height : " + height(root));

//        printNodesAtDepthK(root, 1);
//        System.out.println();

//        printNodesWithoutSibling(root);

//        BTNode<Integer> newRoot = removeLeafNodes(root);
//        printDetailedTreeRecursive(newRoot);

//        System.out.println("Is Balanced : " + isBalanced(root));
//        System.out.println("Is Balanced : " + isBalancedBetter(root).isBalanced);

//        System.out.println("Diameter of the Tree: " + diameterOfBinaryTree(root));
//        System.out.println("Diameter of the Tree: " + diameterOfBinaryTreeBetter(root).diameter + " and height : " + diameterOfBinaryTreeBetter(root).height);

//        int[] inorder = {4,2,5,1,6,3};
//        int[] preorder = {1,2,4,5,3,6};
//
//        BTNode<Integer> root = buildTreeUsingInPre(inorder, preorder, inorder.length);
//        printDetailedTreeLevelWise(root);

//        createAndInsertDuplicateNode(root);
//        printTreeLevelWise(root);
        printTreeLevelWiseBetter(root);
//        10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1   - Dummy Input

//        printRootToLeafPathSumToK(root, 13);

//        ArrayList<Integer> path = givePathFromRootToX(root, 5);
//        for(int i: path){
//            System.out.println(i);
//        }

        ArrayList<SLLNode<Integer>> arr = btToLevelWiseLL(root);
        for(SLLNode<Integer> head: arr){
            LinkedListUse.print(head);
        }
    }

    public static BTNode<Integer> removeLeafNodes(BTNode<Integer> root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }

    public static boolean isBalanced(BTNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    public static IsBalancedReturn isBalancedBetter(BTNode<Integer> root){
        if(root == null){
            return new IsBalancedReturn(0,true);
        }

        IsBalancedReturn leftOutput = isBalancedBetter(root.left);
        IsBalancedReturn rightOutput = isBalancedBetter(root.right);

        boolean isBal = true;
        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }
        else if(Math.abs(leftOutput.height - rightOutput.height) > 1){
            isBal = false;
        }
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        return new IsBalancedReturn(height, isBal);
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

    // not need to return new head because head will never change as duplicate node is always connect to left
    public static void createAndInsertDuplicateNode(BTNode<Integer> root){
        if(root == null){
            return;
        }
        // not need to connect with root because root have connection to its child already
        createAndInsertDuplicateNode(root.left);
        createAndInsertDuplicateNode(root.right);

        BTNode<Integer> rootDuplicate = new BTNode<>(root.data);
        BTNode<Integer> leftTemp = root.left;
        root.left = rootDuplicate;
        rootDuplicate.left = leftTemp;
    }

    public static void printRootToLeafPathSumToK(BTNode<Integer> root, int k){
        printRootToLeafPathSumToKHelper(root, "", k);
    }

    private static void printRootToLeafPathSumToKHelper(BTNode<Integer> root, String path, int k) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && root.data == k){
            System.out.println(path + root.data);
        }
        int smallK = k - root.data;
        printRootToLeafPathSumToKHelper(root.left, path+root.data+" ", smallK);
        printRootToLeafPathSumToKHelper(root.right, path+root.data+" ", smallK);

    }


    // return an array list containing the path from root to x
    public static ArrayList<Integer> givePathFromRootToX(BTNode<Integer> root, int x){
        // Base Case
        if(root == null){
            return null;
        }
        if(root.data == x){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }
        ArrayList<Integer> path = givePathFromRootToX(root.left, x);
        if(path != null){
            path.add(root.data);
            return path;
        }
        path = givePathFromRootToX(root.right, x);
        if(path != null){
            path.add(root.data);
            return path;
        }
        return null;
    }

    // TODO: Assignment BT Q5
    //  print/return all nodes distance k from the given node
    // Try to do with two approaches as in hint video



    // BST2 Assignment Q1:
    //    Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.

    public static ArrayList<SLLNode<Integer>> btToLevelWiseLL(BTNode<Integer> root){
        // Edge case
        if(root == null){
            return null;
        }
        // ArrayList which holds the reference of head of all linked list created
        ArrayList<SLLNode<Integer>> ans = new ArrayList<>();
        // Queue which keep the nodes of tree to be cover
        Queue<BTNode<Integer>> pendingNodes = new LinkedList<>();

        pendingNodes.add(root);
        pendingNodes.add(null);

//        for linkedlist creation
        SLLNode<Integer> head = null;
        SLLNode<Integer> tail = null;

        while(!pendingNodes.isEmpty()){
            BTNode<Integer> currentTreeNode = pendingNodes.poll();

//            identify the level end by null
            if (currentTreeNode == null){
                // add head of ll to the arraylist and set head and tail both null
                ans.add(head);
                head = null;
                tail = null;
                if(!pendingNodes.isEmpty()){
                    pendingNodes.add(null);
                }
            }
            else{
                // adding currentTreeNode childrens to the queue if its present
                if(currentTreeNode.left != null){
                    pendingNodes.add(currentTreeNode.left);
                }
                if(currentTreeNode.right != null){
                    pendingNodes.add(currentTreeNode.right);
                }

                SLLNode<Integer> linkedListNode = new SLLNode<>(currentTreeNode.data);
                if(head == null){
                    head = linkedListNode;
                    tail = linkedListNode;
                }
                else{
                    tail.next = linkedListNode;
                    tail = linkedListNode;
                }
            }
        }
        return ans;
    }

}
