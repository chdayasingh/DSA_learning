package SearchingAndSorting;

// Divide and conquer
public class DAA_Q7 {
    public static int giveIndex(int[] arr,int si,int ei){
        if (si>ei){
            return -1;
        }
        int mid = (si + ei)/2;

        if(arr[mid] == mid){
            return mid;
        }
        if(arr[mid] > mid){
            return giveIndex(arr, si, mid-1);
        }
        return giveIndex(arr, mid-1, ei);
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 5, 6, 7, 10, 12};

        System.out.println(giveIndex(arr, 0, arr.length-1));
    }
}
