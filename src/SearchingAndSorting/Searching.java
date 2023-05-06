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

    private static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            int mid = (start + end)/2;
//            System.out.println(start + " " + end +" "+ mid);

            if(arr[mid] == x){
                return mid;
            }
            else if(x < arr[mid]){
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchR(int[] arr, int x){
        return binarySearchRHelper(arr, x , 0 , arr.length-1);
    }

    private static int binarySearchRHelper(int[] arr, int x, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(arr[mid] == x){
            return mid;
        }
        if(arr[mid] > x){
            return binarySearchRHelper(arr, x, start, mid-1);
        }
        return binarySearchRHelper(arr, x, mid+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 5, 6, 7, 8,9,9,9, 10};

        System.out.println(linearSearchR(arr, 9));
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearchR(arr, 9));

        ArrayList<Integer> allIndexes = giveIndexOfAllOccuranceR(arr, 9);

        for(int i: allIndexes){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
