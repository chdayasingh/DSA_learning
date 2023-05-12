package SearchingAndSorting;

//    Given a sorted array A[1,..., n] such that elements are all distinct. Give an O(lg(n) time algorithm that finds out if there exists a 'k' such that A[k] = k. The algorithm returns 'k' if such an index exists, else -1.

public class BS_Assign_Q3 {
    public static int algo(int[] arr, int startIndex, int endIndex){
        if(startIndex > endIndex){
            return -1;
        }
        int midIndex = (startIndex + endIndex)/2;
        if(arr[midIndex] == midIndex){
            return midIndex;
        }
        if(arr[midIndex] > midIndex){
            return algo(arr, startIndex, midIndex-1);
        }
        return algo(arr, midIndex+1, endIndex);
    }

    public static void main(String[] args) {
         int[] arr = {-1,1,3,6,9};

        System.out.println(algo(arr, 0, arr.length));
    }
}
