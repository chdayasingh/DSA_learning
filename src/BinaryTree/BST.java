package BinaryTree;

import java.util.ArrayList;

public class BST {
    private BTNode<Integer> root;
    private int size;

    public int size(){
        return size;
    }

    public boolean isPresent(int x){
         return isPresentHelper(root, x);
    }

    // this is static method because its independent of object
    private static boolean isPresentHelper(BTNode<Integer> root, int x){
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        if(x < root.data){
            return isPresentHelper(root.left, x);
        }
        return isPresentHelper(root.right, x);
    }

    // Non static
    public void insert(int x){
        size++;
        this.root = insertHelper1(root, x);
    }

    private void insertHelper(BTNode<Integer> root, int x) {
        if(root == null){
            this.root = new BTNode<>(x);
            return;
        }
        // if x is smaller than root data so it will be inserted in the left subtree
        if(x < root.data){
            if(root.left == null){
                root.left = new BTNode<>(x);
                return;
            }
            insertHelper(root.left, x);
        }
        else{
            if(root.right == null){
                root.right = new BTNode<>(x);
                return;
            }
            insertHelper(root.right, x);
        }
    }

//    Static function which return root
    private static BTNode<Integer> insertHelper1(BTNode<Integer> root, int x) {
        if(root == null){
            return new BTNode<>(x);
        }
        if(x < root.data){
            root.left = insertHelper1(root.left, x);
        }
        else{
            root.right = insertHelper1(root.right, x);
        }
        return root;
    }

//    minimum is helper method for deletedata
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

    public boolean deleteData(int x){
        BSTDeleteReturn output = deleteDataHelper(this.root, x);
        if(output.isDeleted){
            size--;
        }
        this.root = output.root;
        return output.isDeleted;
    }

    // this method return pair of new root and isDeleted as True or False
    private static BSTDeleteReturn deleteDataHelper(BTNode<Integer> root, int x) {
//        Case 1
        if(root == null){
            return new BSTDeleteReturn(null,false);
        }
//        Case 2
        if(x < root.data){
            BSTDeleteReturn output = deleteDataHelper(root.left, x);
            root.left = output.root;
//            we don't want to create extra objects that's why we are modify previous output and returning it
            output.root = root;
            return output;
        }
//        Case 3
        else if(x > root.data){
            BSTDeleteReturn output = deleteDataHelper(root.right, x);
            root.right = output.root;
            output.root = root;
            return output;
        }
//        Case 4 : root.data == x , we have to remove this node
        else {
//            There can be 3 case as well
//            case 4.a : root has zero children
            if(root.left == null && root.right == null){
                return new BSTDeleteReturn(null,true);
            }
//            case 4.b : if root has zero children
            if(root.left == null){
                return new BSTDeleteReturn(root.right,true);
            }
            else if(root.right == null){
                return new BSTDeleteReturn(root.left,true);
            }
//            case 4.c : if root has both children i.e left and right are not null
            else{
                // find root replacement
                // find min from right subtree and replace with root data to remain the tree as bst
                int rightMinimum = minimum(root.right);
                root.data = rightMinimum;

                // now delete rightMinimum from right subtree because you already put that data to the current root
                BSTDeleteReturn output = deleteDataHelper(root.right, rightMinimum);
                root.right = output.root;
                output.root = root;
                return output;
            }
        }
    }

    public void printTree(){
        BTUse.printDetailedTreeLevelWise(root);
//        BTUse.printTreeLevelWiseBetter(root);
    }

    public ArrayList<Integer> giveElementsInRange(int k1, int k2){
        return giveElementsInRangeHelper(root, k1, k2);
    }

    private ArrayList<Integer> giveElementsInRangeHelper(BTNode<Integer> root, int k1, int k2) {
        if(root == null){
            return new ArrayList<>();
        }
        if(k1 > root.data){
            return giveElementsInRangeHelper(root.right, k1, k2);
        }
        if(k2 < root.data){
            return giveElementsInRangeHelper(root.left, k1, k2);
        }
        ArrayList<Integer> left = giveElementsInRangeHelper(root.left, k1, k2);
        ArrayList<Integer> right = giveElementsInRangeHelper(root.right, k1, k2);
        left.add(root.data);
        left.addAll(right);
        return left;
    }
}
