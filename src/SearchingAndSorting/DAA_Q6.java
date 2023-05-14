package SearchingAndSorting;

// Divide and conquer

public class DAA_Q6 {
    public static int firstOccurance(int[] arr, int key, int si, int ei){
        return -1;
    }
    public static int lastOccurance(int[] arr, int key, int i, int i1) {
        return -1;
    }

    public static int giveFrequency(int[] arr, int key){
        int firstOccur = firstOccurance(arr, key, 0, arr.length-1);
        int lastOccur = lastOccurance(arr, key, 0, arr.length-1);
        if(firstOccur == -1){
            return 0;
        }
        return lastOccur - firstOccur + 1;
    }

    public static void main(String[] args) {

    }
}
