package Array;

import java.util.Arrays;

public class FirstMissingPositive {

    // answer will always be between 1 to N+1
    public static int firstMissingN2(int[]arr, int n){
        // Naive approach
        for (int i=1; i<=n+1; i++){
            boolean isPresent = false;
            for(int j=0; j<n; j++){
                if(arr[j] == i){
                    isPresent = true;
                }
            }
            if(!isPresent){
                return i;
            }
        }
        return 1;
    }
    public static int firstMissingNLogN(int[] arr, int n) {
        // nlogn Time
        Arrays.sort(arr);

        int lowPosNum = 0;
        for(int i=0; i<n; i++){
         	if(arr[i] > lowPosNum && arr[i]-lowPosNum == 1){
         		lowPosNum++;
         	}
        }
        return lowPosNum+1;
    }

//    Time Complexity: O(N), Only two traversals are needed.
//    Auxiliary Space: O(N), using the list will require extra space
    public static int firstMissingN(int[] arr, int n){
        int temp[] = new int[n+1];
        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                temp[arr[i]] = 1;
            }
        }
        for(int i=1; i<temp.length; i++){
            if(temp[i] == 0){
                return i;
            }
        }
        return temp.length;
    }

    // using swapping - solved in leetcode
//    https://leetcode.com/problems/first-missing-positive/description/

    public static void main(String[] args) {
        int[] arr = ArrayUse.take_array_input();
        System.out.println(firstMissingN2(arr, arr.length));
        System.out.println(firstMissingNLogN(arr, arr.length));
        System.out.println(firstMissingN(arr, arr.length));
    }
}
