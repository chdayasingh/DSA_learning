package SearchingAndSorting;

//2. Given a sorted array A[1,..., n] such that elements may not be distinct. The array is rotated around some random position. Modify binary search such that for a given 'key', it returns the index where 'key' is present (if it exists) in (log n) time.


public class DAA_BS_Assign_Q2 {

    private static int indexOfPivot(int[] arr, int startIndex, int endIndex) {
        if(startIndex == endIndex){
            return startIndex;
        }

        int midIndex = (startIndex + endIndex) / 2;

        if(arr[midIndex] < arr[endIndex]){
            return indexOfPivot(arr, startIndex, midIndex);
        }
        return indexOfPivot(arr, midIndex+1, endIndex);
    }
    public static int indexOfInRotatedArray(int[] arr, int x) {
        // Get the index of min element in log-n
        int pivotIndex = indexOfPivot(arr, 0, arr.length-1);
//        System.out.println(pivotIndex);

        int startIndex = 0;
        int endIndex = arr.length -1;
        if(x >= arr[pivotIndex] && x <= arr[endIndex]){
            startIndex = pivotIndex;
        }
        else{
            endIndex = pivotIndex-1;
        }
//        System.out.println(startIndex +" " + endIndex);

        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if(arr[midIndex] == x){
                return midIndex;
            } else if (arr[midIndex] > x) {
                endIndex = midIndex-1;
            } else {
                startIndex = midIndex+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {50, 55, 79, 2, 4, 11, 40, 49};

        System.out.println(indexOfInRotatedArray(arr, 55));
    }
}
