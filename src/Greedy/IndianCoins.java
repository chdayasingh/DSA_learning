package Greedy;

public class IndianCoins {
    // You are given an infinite supply of denominations
    // find min no. of coins/notes to make change for a value V.

    // Indian currency is canonical coin system which means, this question can solved using greedy approach

    public static int minNumOfCurr(int[] denomination, int value){
        // Assuming denomination is sorted in decreasing order

        int amount = value;
        int count = 0;

        for(int i=0; i<denomination.length; i++){
            while(amount >= denomination[i]){
                count++;
                amount -= denomination[i];
                if(amount == 0)
                    break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] denomination = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int value = 548;

        System.out.println(minNumOfCurr(denomination, value));
    }
}
