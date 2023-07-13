package HashMap;

import Array.*;

import java.util.HashMap;
import java.util.Map;

public class PairWithDiffK {
//    Given an array of integers, count the number of unique pairs of integers that have difference k.
//    Input: [1, 7, 5, 9, 2, 12, 3] K=2
//    Output: 4
//    We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9). Note that we only want the number of these pairs, not the pairs themselves.

//1 5 4 1 2
//    11 6 10 5 11 16

    public static void main(String[] args) {
        int[] arr = ArrayUse.take_array_input();
        System.out.println(numOfPairsWithDiffK(arr, 0));
    }

    public static int numOfPairsWithDiffK(int[] arr, int k) {
        // App1: BruteForce
        // App2: Sorting and Binary Search
        // App2: Hashmap

        Map<Integer, Integer> freq = new HashMap<>();

        for(int i: arr){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
//        System.out.println(freq);

        int count = 0;
        for(int i:arr){
            if(!freq.containsKey(i)){
                continue;
            }
            if(k==0){ // handing the case when k is 0
                if(freq.get(i) >= 2){
                    count++;
                    freq.remove(i);
                }
                continue;
            }
            int t1 = i-k;
            int t2 = i+k;
            if(freq.containsKey(t1)){
                count++;
            }
            if(freq.containsKey(t2)){
                count++;
            }
            freq.remove(i);
//            System.out.println(i + "," + t2 + " " + freq);
        }
        return count;
    }

    public static int numOfPairsWithDiffK1(int[] arr, int k){
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int elem: arr){
            fmap.put(elem, fmap.getOrDefault(elem,0) + 1);
        }
        int count = 0;
        for(int key: fmap.keySet()){
            // both case if differece greater than zero or equal to zero
            // if k==0 then count that keys which have frequency >= 2
            if((k>0 && fmap.containsKey(key+k)) || (k==0 && fmap.get(key) > 1)){
                count++;
            }
        }
        return count;
    }

}
