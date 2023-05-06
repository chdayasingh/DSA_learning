package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class InbuiltHashMapUse {
    public static String extractUniqueCharacters(String str){
        String ans = "";
//        T.C - O(n2)
//        for(int i=0; i<str.length(); i++){
//            boolean found = false;
//            for(int j=0; j<ans.length(); j++){
//                if(str.charAt(i) == ans.charAt(j)){
//                    found = true;
//                    break;
//                }
//            }
//            if(!found){
//                ans += str.charAt(i);
//            }
//        }

//        Using HashMap T.C - O(n)
        HashMap<Character, Boolean> charMap = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            if(!charMap.containsKey(str.charAt(i))){
                ans += str.charAt(i);
                charMap.put(str.charAt(i), true);
            }
        }
        return ans;
    }

    public static int[] longestConsecutiveSequence(int arr[]){
        // You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
        // You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.
        int[] output = new int[2];
        output[0] = arr[0];
        output[1] = arr[0];

        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i: arr){
            map.put(i, true);
        }
        System.out.println(map.toString());
        int maxLength = 1;
        int length = 1;
        for(int i: arr){
            if(map.containsKey(i)){
                map.remove(i);
                int temp1 = i-1;
                int temp2 = i+1;
                while(map.containsKey(temp1)){
                    map.remove(temp1);
                    length++;
                    temp1--;
                }
                while(map.containsKey(temp2)){
                    map.remove(temp2);
                    length++;
                    temp2++;
                }
                if (length > maxLength){
                    maxLength = length;
                    output[0] = temp1+1;
                    output[1] = temp2-1;
                }
                length = 1;
            }
        }
        return output;

    }


    public static void main(String[] args) {
        String str = "abcde";
//        System.out.println(extractUniqueCharacters(str));

        int arr[] = {2 ,12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        int[] output = longestConsecutiveSequence(arr);
        for(int i: output){
            System.out.println(i);
        }
    }
}
