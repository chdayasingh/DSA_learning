package SearchingAndSorting;

public class BinarySearch {
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

    public static int giveFirstOccurrance(int[] arr, int startIndex, int endIndex, int x){
        if(startIndex > endIndex){
            return -1;
        }
        int midIndex = (startIndex + endIndex ) / 2;

        if(x < arr[midIndex]){
            return giveFirstOccurrance(arr, startIndex, midIndex-1, x);
        }
        if(x > arr[midIndex]){
            return giveFirstOccurrance(arr, midIndex+1, endIndex, x);
        }
        // if control are here that's means x == arr[midIndex]
        if(midIndex==0 ||  (x != arr[midIndex-1])){
            return midIndex;
        }
        return giveFirstOccurrance(arr, startIndex, midIndex-1, x);

    }

    // input array always contain sorted 0 and 1
    public static int indexOfFirst1(int arr[], int si, int ei){
        if (si > ei){
            return -1;
        }
        int mid = (si+ei) / 2;

        // if the arr[mid] is equal to first 1
        if(arr[mid] == 1 && (mid == 0 || arr[mid-1] == 0)){
            return mid;
        }
        if(arr[mid] == 0){
            return indexOfFirst1(arr, mid+1, ei);
        }
        return indexOfFirst1(arr, si, mid-1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 6, 6, 6, 8, 9, 9, 10};

//        System.out.println(binarySearch(arr, 9));
//        System.out.println(binarySearchR(arr, 6));

//        System.out.println(giveFirstOccurrance(arr, 0, arr.length-1, 6));

//        int[] arr1 = {1,1,1,1};
//        System.out.println(indexOfFirst1(arr1, 0, 3));
    }
}
