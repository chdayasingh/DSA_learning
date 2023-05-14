package SearchingAndSorting;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BucketSort {
    // Bucket Sort algo varies according to the input
    // but concept are the same

    // Ques - Sort an array having numbers in range[0.0, 1.0) with uniform distn. Efficient way to sort

    public static <ArraysList> void bucketSort(double[] arr){
        int n = arr.length;
        // buckets
        ArrayList<Double>[] buckets= new ArrayList[n];

        // create empty bucket
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<Double>();
        }

        // adding elements into our buckets
        for(int i=0; i<n; i++){
            int digit = (int) (arr[i]*n);
            buckets[digit].add(arr[i]);
        }

        // sorting each bucket
        for(int i=0; i< buckets.length; i++){
            Collections.sort(buckets[i]);
        }

        // Joining each bucket to form sorted array
        int index = 0;
        for(int i=0; i< buckets.length; i++){
            for(int j=0; j<buckets[i].size(); j++){
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        double[] arr = new double[10];
        for(int i=0; i<arr.length; i++){
            double randomNumber = (int)(Math.random() * 100) / 100.0;
            arr[i] = randomNumber;
        }

        System.out.println(Arrays.toString(arr));
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
