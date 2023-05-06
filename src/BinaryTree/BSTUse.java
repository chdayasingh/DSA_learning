package BinaryTree;

import LinkedList.PairOfHeadTail;
import LinkedList.SLLNode;

import java.util.ArrayList;

public class BSTUse {
    public static boolean searchInBST(BTNode<Integer> root, int x){
        if(root == null){
            return false;
        }
        if (x == root.data){
            return true;
        }
        else if(x < root.data){
            return searchInBST(root.left, x);
        }
        return searchInBST(root.right, x);
    }

    public static void printElementsBetweenK1K2(BTNode<Integer> root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k2 < root.data){
            printElementsBetweenK1K2(root.left, k1, k2);
        }
        else if(k1 > root.data){
            printElementsBetweenK1K2(root.right, k1, k2);
        }
        else{
            printElementsBetweenK1K2(root.left, k1, k2);
            System.out.println(root.data);
            printElementsBetweenK1K2(root.right, k1, k2);
        }
    }

    public static BTNode<Integer> constructBSTFromSortedArray(int[] arr, int startIndex, int endIndex){
        if(startIndex > endIndex){
            return null;
        }
        int midIndex = (startIndex + endIndex) / 2;
        BTNode<Integer> root = new BTNode<>(arr[midIndex]);
        root.left = constructBSTFromSortedArray(arr, startIndex, midIndex-1);
        root.right = constructBSTFromSortedArray(arr, midIndex + 1, endIndex);
        return root;
    }

    public static int minimum(BTNode<Integer> root){
//        Edge Case
        if(root == null){
            return -1;
        }
//        Base Case
        if(root.left == null){
            return root.data;
        }
        return minimum(root.left);
    }

    // Time complexity - O(n*h)
    public static boolean isBST(BTNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftMax = BTUse.largest(root.left);
        if(root.data <= leftMax){
            return false;
        }
        int rightMin = minimum(root.right);
        if(root.data > rightMin){
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    // Time complexity - O(h)
    private static isBSTReturn isBSTBetterHelper(BTNode<Integer> root){
        if(root == null){
            return new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        isBSTReturn leftOutput = isBSTBetterHelper(root.left);
        isBSTReturn rightOutput = isBSTBetterHelper(root.right);

        boolean isBST = leftOutput.isBST && rightOutput.isBST;
        if (isBST) {
            if(leftOutput.max >= root.data){
                isBST = false;
            }
            if(rightOutput.min < root.data){
                isBST = false;
            }
        }

        int min = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
        int max = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));

        return new isBSTReturn(min, max, isBST);
    }

    public static boolean isBSTBetter(BTNode<Integer> root){
        return isBSTBetterHelper(root).isBST;
    }

    // checking the root data every time lies in given limit or not
    // TOP to DOWN recursive approach
    private static boolean isBSTSimplerHelper(BTNode<Integer> root, int min , int max){
        if(root == null){
            return true;
        }

        if(root.data < min || root.data > max){
            return false;
        }
        boolean leftOutput = isBSTSimplerHelper(root.left, min, root.data-1);
        boolean rightOutput = isBSTSimplerHelper(root.right, root.data, max);
        return leftOutput && rightOutput;

    }
    public static boolean isBSTSimpler(BTNode<Integer> root){
        return isBSTSimplerHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // using PairOfHeadTail class from Linked List contains pair of head and tail
    private static PairOfHeadTail bstToLLHelper(BTNode<Integer> root){
        if(root == null){
            return new PairOfHeadTail();
        }
        PairOfHeadTail leftOutput = bstToLLHelper(root.left);
        PairOfHeadTail rightOutput = bstToLLHelper(root.right);

        // creating a ll node with root data
        SLLNode<Integer> rootNode = new SLLNode<>(root.data);

        // joining the left output linked list , root and right output linked list
        if(leftOutput.tail != null){
            leftOutput.tail.next = rootNode;
        }
        rootNode.next = rightOutput.head;

        SLLNode<Integer> head = leftOutput.head;
        SLLNode<Integer> tail = rightOutput.tail;

        if(head == null){
            head = rootNode;
        }
        if(tail == null){
            tail = rootNode;
        }

        return new PairOfHeadTail(head, tail);
    }
    public static SLLNode<Integer> bstToLL(BTNode<Integer> root){
        return bstToLLHelper(root).head;
    }

    private static BTNode<Integer> getLCAHelper(BTNode<Integer> root, int a, int b){
        if(root == null || root.data == a || root.data == b){
            return root;
        }

        BTNode<Integer> leftOutput = getLCAHelper(root.left, a, b);
        BTNode<Integer> rightOutput = getLCAHelper(root.right, a, b);

        if(leftOutput != null && rightOutput != null){
            return root;
        }
//        If out of 2 nodes only one node is present, return that node.
        else if (leftOutput != null) {
            return leftOutput;
        }
        return rightOutput;

    }

    public static int getLCA(BTNode<Integer> root, int a, int b){
        BTNode<Integer> ansNode = getLCAHelper(root, a, b);
        return (ansNode == null) ? -1: ansNode.data;
    }

    // TODO: Assignment: BTS1 q3
    // Replace with sum of greater nodes


    public static ArrayList<Integer> givePathFromRootToXInBST(BTNode<Integer> root, int x){
        // Base Case
        if(root == null){
            return null;
        }
        if(root.data == x){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(0,root.data);
            return path;
        }
        if(x < root.data){
            ArrayList<Integer> path = givePathFromRootToXInBST(root.left, x);
            if(path != null){
                path.add(0,root.data);
                return path;
            }
            return null;
        }

        ArrayList<Integer> path = givePathFromRootToXInBST(root.right, x);
        if(path != null){
            path.add(0,root.data);
            return path;
        }
        return null;
    }



    public static int bstHeight(BTNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftHeight = bstHeight(root.left);
        int rightHeight = bstHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }


//    Time complexity - O(n*n)
    public static int largestBSTHeight(BTNode<Integer> root){
        if(root == null){
            return 0;
        }
        // if root is bst so return its height
        if (isBSTSimpler(root)){
            return bstHeight(root);
        }

        int leftOutput = largestBSTHeight(root.left);
        int rightOutput = largestBSTHeight(root.right);

        return Math.max(leftOutput, rightOutput);
    }

    public static largestBSTHeightReturn largestBSTHeightBetterHelper(BTNode<Integer> root){
        if(root == null){
            return new largestBSTHeightReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }

        largestBSTHeightReturn leftOutput = largestBSTHeightBetterHelper(root.left);
        largestBSTHeightReturn rightOutput = largestBSTHeightBetterHelper(root.right);

        boolean isBst = leftOutput.isBST && rightOutput.isBST;
        if(isBst){
            if(leftOutput.max >= root.data || rightOutput.min < root.data){
                isBst = false;
            }
        }
        int min = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
        int max = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));

        int maxHeightOfLeftRight = Math.max(leftOutput.height, rightOutput.height);
        int height = (isBst) ? maxHeightOfLeftRight + 1 : maxHeightOfLeftRight;

        return new largestBSTHeightReturn(min, max, isBst, height);
    }

    public static int largestBSTHeightBetter(BTNode<Integer> root){
        return largestBSTHeightBetterHelper(root).height;
    }


    // TODO:
//    Pair sum in a BST
//    Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).



    public static void main(String[] args) {
        BTNode<Integer> root = BTUse.takeTreeInputLevelWise();
//        System.out.println(searchInBST(root, 100));
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter k1 and k2 seperated by space");
//        int k1 = sc.nextInt();
//        int k2 = sc.nextInt();
//        printElementsBetweenK1K2(root, k1 , k2);

//        int arr[] = {1,2,3,4,5,6,7,8};
//        BTNode<Integer> root = constructBSTFromSortedArray(arr, 0, arr.length-1);
////        System.out.println(root);
//        BTUse.printTreeLevelWiseBetter(root);
//        System.out.println(isBSTSimpler(root));

//        Node<Integer> head = bstToLL(root);
//        printLinkedList(head);

//        System.out.println(getLCA(root, 2, 10));

//        ArrayList<Integer> path = givePathFromRootToXInBST(root, 2);
//        for(int i: path){
//            System.out.println(i);
//        }

//        System.out.println(bstHeight(root));
        System.out.println(largestBSTHeight(root));
        System.out.println(largestBSTHeightBetter(root));

    }
}
