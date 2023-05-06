package DAA;
import Array.ArrayUse;

public class DAA1b {

    public static void insert(int[] arr, int i){
        int temp = arr[i];
        int j=i-1;
        while(j>=0 && temp < arr[j]){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;
    }
    public static void insertion_sort(int[] arr){
        for(int i=1; i<arr.length; i++){
            insert(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUse.take_array_input();
        ArrayUse.printArray(arr);
        insertion_sort(arr);
        ArrayUse.printArray(arr);
    }
}
