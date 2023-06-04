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

//    As we go
//    through the array, every element before zeroPos is a 0 and every element after twoPos
//    is a 2. Also, every element after zeroPos but before current is a 1. Therefore, all these
//    elements are ‘sorted’. The element that remain to be sorted are the ones that lie
//    between the indices current and twoPos . Therefore our loop will terminate when
//    current reaches the value of twoPos .

    public static void sort012(int[] arr) {
        int current = 0, zeroPos = 0;
        int twoPos = arr.length-1;

        while(current <= twoPos){
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
