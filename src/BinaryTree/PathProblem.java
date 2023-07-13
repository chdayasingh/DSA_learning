package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PathProblem {

    public static void printRootToLeafPathSumToK(BTNode<Integer> root, int k){
        printRootToLeafPathSumToKHelper(root, "", k);
        ArrayList<Integer> path = new ArrayList<>();
    }

    private static void printRootToLeafPathSumToKHelper(BTNode<Integer> root, String path, int k) {
        if(root == null){
            return;
        }
        if(root.data == k && root.left == null && root.right == null){
            System.out.println(path + "" + root.data);
            return;
        }

        printRootToLeafPathSumToKHelper(root.left, path+root.data+" ", k - root.data);
        printRootToLeafPathSumToKHelper(root.right, path+root.data+" ", k - root.data);
    }


    // return an array list containing the path from root to x
    // Approach: at  each node
    // if root is x then return path containing x
    // else Ask left subtree to give path if path exist return the path with added root
    // else same for right subtree
    // else return no path

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
            path.add(0, root.data);
            return path;
        }
        path = givePathFromRootToX(root.right, x);
        if(path != null){
            path.add(0, root.data);
            return path;
        }
        return null;
    }


    // return true or false and fill the path data structure if path exist
    private static boolean givePathFromRootToX1(BTNode<Integer> root, int x, ArrayList<Integer> path) {
        if(root == null){
            return false;
        }
        path.add(root.data);

        if(root.data == x || givePathFromRootToX1(root.left, x, path) || givePathFromRootToX1(root.right, x, path)){
            return true;
        }

        path.remove(path.size()-1);  // Backtracking
        return false;
    }

    // useless function
    public static ArrayList<Integer[]> givePathFromRootToXWithDir(BTNode<Integer> root, int x){
        // Base Case
        if(root == null){
            return null;
        }
        if(root.data == x){
            ArrayList<Integer[]> path = new ArrayList<>();
            Integer[] a = {root.data, -1};
            path.add(a);
            return path;
        }
        ArrayList<Integer[]> path = givePathFromRootToXWithDir(root.left, x);
        if(path != null){
            Integer[] a = {root.data, 0};
            path.add(a);
            return path;
        }
        path = givePathFromRootToXWithDir(root.right, x);
        if(path != null){
            Integer[] a = {root.data, 1};
            path.add(a);
            return path;
        }
        return null;
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


    //  print/return all nodes distance k from the given node
    //  solved in leetcode

//    T.C - O(h)
    public static ArrayList<Integer> givePathFromRootToXInBST(BTNode<Integer> root, int x){
        if(root == null){
            return null;
        }
        if(root.data == x){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }
        ArrayList<Integer> path;
        if(x < root.data ){
            path = givePathFromRootToXInBST(root.left, x);
            if(path != null){
                path.add(0, root.data);
            }
            return path;
        }
        path = givePathFromRootToXInBST(root.right, x);
        if(path != null){
            path.add(0, root.data);
        }
        return path;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTNode<Integer> root = BTUse.takeTreeInputLevelWise(); // Dummy value : 2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
        BTUse.printDetailedTreeLevelWise(root);
//        printRootToLeafPathSumToK(root, 13);

        // 1 2 3 4 5 -1 -1 -1 -1 6 7 -1 -1 -1 -1
        // 7
        int x = sc.nextInt();
//        System.out.println(givePathFromRootToX(root, x));
//
//        ArrayList<Integer> path = new ArrayList<>();
//        System.out.println(givePathFromRootToX1(root, x, path) + ": " + path);

//        ArrayList<Integer[]> pathwithdir = givePathFromRootToXWithDir(root, x);
//        for(Integer[] a: pathwithdir){
//            System.out.print(Arrays.toString(a) + " ");
//        }
//        System.out.println();

        System.out.println(givePathFromRootToXInBST(root, x));
    }


}
