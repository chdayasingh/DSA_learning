package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    private static class AVLNode{
        int data;
        AVLNode left;
        AVLNode right;
        int height;

        public AVLNode(int data, int height) {
            this.data = data;
            this.height = height;
        }

        @Override
        public String toString(){
            return "data="+data;
        }
    }

    private AVLNode root;
    private int size;

    public AVLTree() {

    }

    public void insert(int x) {
        root = insertHelper(root, x);
    }

    private AVLNode insertHelper(AVLNode root, int x) {
        AVLNode newNode = new AVLNode(x, 1);
        if(root == null){
            return newNode;
        }
        if(x < root.data){
            root.left = insertHelper(root.left, x);
        }
        else{
            root.right = insertHelper(root.right, x);
        }

        // update height
        setHeight(root);

        return balance(root);
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private AVLNode balance(AVLNode root) {
        int bf = balanceFactor(root);
        if(bf > 1){ // left heavy
//            System.out.println(root.data + " is left heavy");
            if(balanceFactor(root.left) < 0){
//                System.out.println("left rotation on " + root.left.data);
                root.left = rotateLeft(root.left);
            }
//            System.out.println("right rotation on " + root.data);
            root = rotateRight(root);
        } else if (bf < -1) { // right heavy
//            System.out.println(root.data + " is right heavy");
            if(balanceFactor(root.right) > 0){
//                System.out.println("right rotation on " + root.right.data);
                root.right = rotateRight(root);
            }
//            System.out.println("left rotation on " + root.data);
            root = rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }
    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }


    // give height of given node by accessing height property
    private int height(AVLNode node){
        return (node == null) ? 0 : node.height;
    }

    private int balanceFactor(AVLNode node){
        return height(node.left) - height(node.right);
    }

    @Override
    public String toString(){
        if(root == null){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        Queue<AVLNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            AVLNode front = pendingNodes.poll();
            ans.append(front.data).append("(H-"+ front.height + ") : ");
            if(front.left != null){
                ans.append("L-").append(front.left.data).append(", ");
                pendingNodes.add(front.left);
            }

            if(front.right != null){
                ans.append("R-").append(front.right.data);
                pendingNodes.add(front.right);
            }
            ans.append("\n");
        }
        return ans.toString();
    }

}
