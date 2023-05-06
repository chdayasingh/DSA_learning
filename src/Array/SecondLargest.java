package Array;

public class SecondLargest {
    public static int giveSecLargest(int[] arr){
        // In single scan
        int lar = arr[0];
        int sec_lar = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > lar){
                sec_lar = lar;
                lar = arr[i];
            } else if (arr[i] != lar && arr[i] > sec_lar) {
                sec_lar = arr[i];
            }
        }
        return sec_lar;
    }

    public static void main(String[] args) {
        int[] arr = {90, 8, 90, 5};
        System.out.println(giveSecLargest(arr));
    }
}
