package Recursion;

public class PermutationOfString {

    public static String swapCharacterInString(String str, int i, int j){
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    public static void printAllPermutation(String str, int low, int high){
        if(low == high){
            System.out.println(str);
            return;
        }
        for(int i=low; i<=high; i++){
            str = swapCharacterInString(str, low, i);
            printAllPermutation(str, low+1, high);
            str = swapCharacterInString(str, low, i);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        printAllPermutation(str, 0, str.length()-1);
    }
}
