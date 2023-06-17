package BinarySearch;

import Array.ArrayUse;

import java.util.Scanner;

// Binary Search
public class SearchSingleElement {
    // Linear
    // compare every ith elem with prev and next
    public static int searchSingleElement(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            if(i == 0){
                if(arr[i] != arr[i+1]){
                    return arr[i];
                }
            }else if(i == n-1){
                if(arr[i-1] != arr[i]){
                    return arr[i];
                }
            }
            else{
                if(arr[i-1] != arr[i] && arr[i] != arr[i+1]){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static int searchSingleElement1(int[] arr) {
        int i=0;
        while(i < arr.length-1){
            int curr = arr[i];
            if(curr == arr[i+1]){
                i+=2;
            }
            else{
                return arr[i];
            }
        }
        return arr[i];
    }

    // using XOR
    public static int searchSingleElement2(int[] arr){
        int single = 0;
        for(int i=0; i<arr.length-1; i++){
            single ^= arr[i];
        }
        return single;
    }


    // logn
    public static int searchSingleElementOptimise(int[] nums){
        // input array have one target (single elem)
        // left part - 1st instance (even), 2nd (odd)
        // right part - 1st instance (odd), 2nd (even)
        // goal : when low > high , means left part has ended and nums[low] is our ans

        // edge case : target at the endpoints

        int low = 0, high = nums.length-2; //(low and high is limits of left part)

        while(low <= high){
            int mid = (low+high)/ 2;
            if(mid%2 == 0){
                if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else{
                if(nums[mid] == nums[mid-1]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return nums[low];
    }


//    (even, odd) -> we are at left half -> target at right half
//    (odd, even) -> we are at right half -> target at left half

    public static int searchSingleElementOptimise1(int[] arr){
        int n = arr.length;
        if(n == 1) return arr[0];
        // Edge cases
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1, high = n-2;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            if((mid%2 == 0 && arr[mid] == arr[mid+1]) || (mid%2 == 1 && arr[mid] == arr[mid-1])){
                // we are at left half so elem will at right half
                low = mid+1;
            }
            else{
                // we are at left half so elem will at right half
                high = mid-1;
            }
        }
        // Never come here
        return -1;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUse.take_array_input();
        System.out.println(searchSingleElementOptimise1(arr));
    }
}
