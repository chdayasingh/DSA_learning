package SearchingAndSorting;

import java.util.ArrayList;

public class Searching {
    public static int linearSearchR(int arr[], int x){
        return linearSearchRHelper(arr, x, 0);
    }

    private static int linearSearchRHelper(int[] arr, int x, int i) {
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == x){
            return i;
        }
        return linearSearchRHelper(arr, x, i+1);
    }

    // return all indexes
    public static ArrayList<Integer> giveIndexOfAllOccuranceR(int[] arr, int x){
        return giveIndexOfAllOccuranceRHelper(arr, x, 0);
    }
    private static ArrayList<Integer> giveIndexOfAllOccuranceRHelper(int[] arr, int x, int index){
        if(index == arr.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = giveIndexOfAllOccuranceRHelper(arr, x, index+1);
        if(arr[index] == x){
            ans.add(0,index);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 5, 6, 7, 8,9,9,9, 10};

        System.out.println(linearSearchR(arr, 9));

        ArrayList<Integer> allIndexes = giveIndexOfAllOccuranceR(arr, 9);

        for(int i: allIndexes){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
