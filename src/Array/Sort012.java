package Array;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = ArrayUse.take_array_input();
        sort012(arr);
        ArrayUse.printArray(arr);
    }

    private static void swapInArray (int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // explanation in google doc (Array DS)
    public static void sort012(int[] arr) {
        int current = 0, zeroPos = 0;
        int twoPos = arr.length-1;

        while(current < twoPos){
            if(arr[current] == 0){
                swapInArray(arr, zeroPos, current);
                current++;
                zeroPos++;
            } else if (arr[current] == 2) {
                swapInArray(arr, twoPos, current);
                twoPos--;
            } else {
                current++;
            }
        }
    }
}
