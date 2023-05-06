package Trees;

import Queue.QueueEmptyException;
import Queue.QueueUsingLL;
import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.SortedMap;

public class TreeUse {
    public static TreeNode<Integer> takeDummyTree(){
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(9);
        TreeNode<Integer> node4 = new TreeNode<>(6);
        TreeNode<Integer> node5 = new TreeNode<>(7);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        return root;
    }
    public static TreeNode<Integer> takeInput(Scanner sc){
//        System.out.println("Enter the next node: ");
        int data = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(data);
//        System.out.println("Enter the number of children of " + data);
        int children = sc.nextInt();
        for(int i=0; i<children; i++){
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root element : ");
        int data = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(data);
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            try {
                TreeNode<Integer> rootNode = pendingNodes.dequeue();
                System.out.println("Enter no. of children of " + rootNode.data + " :");
                int children = sc.nextInt();
                for(int i=1; i<=children; i++){
                    System.out.println("Enter " + i + "th child of " + rootNode.data + " :");
                    int child = sc.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    rootNode.children.add(childNode);
                    pendingNodes.enqueue(childNode);
                }

            } catch (QueueEmptyException e) {
                throw new RuntimeException(e);
            }
        }

        return root;

    }

    public static void printTree(TreeNode<Integer> root){
        String s = root.data + ": ";
        for(int i=0; i<root.children.size(); i++){
            s += root.children.get(i).data + ",";
        }
        System.out.println(s);
        for(int i=0; i<root.children.size(); i++){
            printTree(root.children.get(i));
        }
    }

    public static void printTreeLevelWise(TreeNode<Integer> root) throws QueueEmptyException {
//        String s = root.data + ": ";

        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> rootNode = pendingNodes.dequeue();
            String s = rootNode.data + ": ";
            for(int i=0; i<rootNode.children.size(); i++){
                TreeNode<Integer> childNode = rootNode.children.get(i);
                s +=  childNode.data + ",";
                pendingNodes.enqueue(childNode);
            }
            System.out.println(s);
        }
    }

    public static int numNodes(TreeNode<Integer> root){
        // Edge case
        if (root == null) return 0;

        int count = 1;
        for(int i=0; i<root.children.size(); i++){
            count += numNodes(root.children.get(i));
        }
        return count;
    }

    public static int largest(TreeNode<Integer> root){
        if(root == null) return Integer.MIN_VALUE;

        int largest = root.data;
        for(int i=0; i<root.children.size(); i++){
            int childLargest = largest(root.children.get(i));
            if(childLargest > largest){
                largest = childLargest;
            }
        }
        return largest;
    }

    public static int height(TreeNode<Integer> root) {
        if(root == null) return 0;

        int height = 0;
        for(int i=0; i<root.children.size(); i++){
            int childHeight = height(root.children.get(i));
            height = Math.max(height,childHeight);
        }
        return height+1;
    }

    public static void printAtKDepth(TreeNode<Integer> root, int k) {
        // Edge case
        if(k < 0){
            return;
        }
        // Base case
        if(k == 0){
            System.out.println(root.data);
            return;
        }
        for(int i=0; i<root.children.size(); i++){
            printAtKDepth(root.children.get(i), k-1);
        }
    }

    public static void printPreOrder(TreeNode<Integer> root){
        if(root == null) return;

        System.out.print(root.data + " ");
        for(int i=0; i<root.children.size(); i++){
            printPreOrder(root.children.get(i));
        }
    }

    public static void printPostOrder(TreeNode<Integer> root){
        if(root == null) return;

        for(int i=0; i<root.children.size(); i++){
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }

    public static int countLeafNodes(TreeNode<Integer> root){
        if(root == null) return 0;

        //Base case
        if(root.children.size() == 0){
            return 1;
        }
        int count = 0;
        for(int i=0; i<root.children.size(); i++){
            count += countLeafNodes(root.children.get(i));
        }
        return count;
    }

    public static void main(String[] args) throws QueueEmptyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data for Tree in correct format : ");
        TreeNode<Integer> root = takeInputLevelWise();
//        printTree(root);
        printTreeLevelWise(root);
        System.out.println("Number of Nodes : " + numNodes(root));
        System.out.println("Largest : " + largest(root));
        System.out.println("Height of the Tree: " + height(root));
//        System.out.println("Nodes at level 2: ");
//        printAtKDepth(root,2);1 2 2 3 2 4 5 1 8 0 2 6 7 1 9 0 0 0
        System.out.println("Num of leaf Nodes : " + countLeafNodes(root));
        System.out.println("Pre order : ");
        printPreOrder(root);
        System.out.println("\nPost order : ");
        printPostOrder(root);



//        TreeNode<Integer> root1 = takeDummyTree();
//        printTree(root1);


//
//        System.out.println(root.children.get(1).data);
    }



}
