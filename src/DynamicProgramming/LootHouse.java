package DynamicProgramming;

//  Loot Houses
//
//  A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.

import java.util.Arrays;

public class LootHouse {

    public static int maxLoot(int[] arr, int i){
        if(i >= arr.length){
            return 0;
        }

        int ans1 = arr[i] + maxLoot(arr, i+2);
        int ans2 = maxLoot(arr, i+1);
        return Math.max(ans1, ans2);
    }

    // Recursive , Memoization
    public static int maxLootDP(int[] arr, int i, int[] memo){
        if(i >= arr.length){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }

        int ans1 = arr[i] + maxLootDP(arr, i+2, memo);
        int ans2 = maxLootDP(arr, i+1, memo);

        memo[i] = Math.max(ans1, ans2);
        return memo[i];
    }

    public static int maxLootDPIterative(int[] arr){
        // fill the memo array from either left to right or right to left;
        // assuming that till ith index , i know my maxLoot

        int[] memo = new int[arr.length];
        for(int i=0; i<memo.length-2; i++){
            memo[i] = -1;
        }

        // for last element - after that array is empty so maxLoot is lastElem
        memo[memo.length-1] = arr[arr.length-1];
        // for second last element - max of that element and last element will be the max loot
        memo[memo.length-2] = Math.max(arr[arr.length-1], arr[arr.length-2]);

        for(int i=memo.length-3; i>=0; i--){
            int ans1 = memo[i+1];
            int ans2 = arr[i] + memo[i+2];
            memo[i] = Math.max(ans1, ans2);
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        int[] arr1 = {10, 2, 30, 20, 3, 50};

        int[] memo = new int[arr.length];
        for(int i=0; i<memo.length; i++){
            memo[i] = -1;
        }

//        System.out.println(maxLootDP(arr, 0, memo));
//        System.out.println(Arrays.toString(memo));

        System.out.println(maxLootDP(arr1, 0, memo));
        System.out.println(Arrays.toString(memo));

        System.out.println(maxLootDPIterative(arr1));
    }
}
