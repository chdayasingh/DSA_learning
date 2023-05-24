package Recursion;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;

public class Subset {

    // Bottom up apprach
    // spliting 123 => 12 3
    // solved in Leetcode also
    public static ArrayList<ArrayList<Integer>> returnAllSubset(int[] arr, int ei){
        if(ei < 0){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        ArrayList<ArrayList<Integer>> ans = returnAllSubset(arr, ei-1);
        int n = ans.size();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[ei]);
        ans.add(temp);

        for(int i=1; i<n; i++){
            ArrayList<Integer> clone = (ArrayList<Integer>) ans.get(i).clone();
            clone.add(arr[ei]);
            ans.add(clone);
        }
        return ans;
    }


    // string output so far
    public static void printAllSubset(int[] arr, int si, String outputSorFar){
        if(si == arr.length){
            System.out.println(outputSorFar);
            return;
        }

        printAllSubset(arr, si+1, outputSorFar);
        printAllSubset(arr, si+1, outputSorFar + arr[si]);
    }

    // output so far is interger array
    public static void printAllSubset1(int[] arr, int si, ArrayList<Integer> outputSorFar){
        if(si == arr.length){
            System.out.println(outputSorFar.toString());
            return;
        }

        printAllSubset1(arr, si+1, outputSorFar);
        outputSorFar.add(arr[si]);
        printAllSubset1(arr, si+1, outputSorFar);
        // Actually changes are happened in the arraylist object on each recursion call so we need to revert it back state
        outputSorFar.remove(outputSorFar.size()-1);  // Backtracking
    }


    // return 2d array (jagged array) of subsets with sum to k
    public static int[][] returnAllSubsetSumToK(int[] arr, int si, int k){
        if(si == arr.length){
            if(k == 0){
                return new int[1][0];
            }
            return new int[0][0];
        }

        // storing the subset sum to k without including arr[si]
        int[][] withoutInclude = returnAllSubsetSumToK(arr, si+1, k);
        // storing the subset sum to k-arr[si] with including arr[si]
        int[][] withInclude = returnAllSubsetSumToK(arr, si+1, k-arr[si]);

        int[][] output = new int[withInclude.length + withoutInclude.length][];

        int index = 0;
        for(int i=0; i<withoutInclude.length; i++){
            output[index++] = withoutInclude[i];
        }
        for(int i=0; i<withInclude.length; i++){
            output[index] = new int[withInclude[i].length + 1];
            output[index][0] = arr[si];
            for(int j=0; j<withInclude[i].length; j++) {
                output[index][j + 1] = withInclude[i][j];
            }
            index++;
        }

        return output;
    }


    public static void printAllSubsetSumToK(int[] arr, int si, int k, ArrayList<Integer> outputSoFar){
        if(si == arr.length){
            if(k == 0){
                System.out.println(outputSoFar.toString());
            }
            return;
        }

        printAllSubsetSumToK(arr, si+1, k, outputSoFar);
        outputSoFar.add(arr[si]);
        printAllSubsetSumToK(arr, si+1, k-arr[si], outputSoFar);
        outputSoFar.remove(outputSoFar.size()-1); // Backtracking , going to previous state for next call
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> subset = returnAllSubset(arr, arr.length-1);
        for(ArrayList<Integer> i: subset){
            System.out.println(i.toString());
        }

//        printAllSubset(arr, 0, "");
//        printAllSubset1(arr, 0, new ArrayList<Integer>());
//        System.out.println();
//
//        int[][] targetSubset = returnAllSubsetSumToK(arr, 0, 5);
//        for(int[] i :targetSubset){
//            System.out.println(Arrays.toString(i));
//        }
//        System.out.println();
//        printAllSubsetSumToK(arr, 0, 5, new ArrayList<>());
    }
}
