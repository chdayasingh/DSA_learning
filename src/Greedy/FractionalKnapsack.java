package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static int maximumValue(int[] weight, int[] value, int capacity){
//        first we calculate ratio of value by weight (value per kg)
//        we want ratio in sorted order so that we can fill the wight which has higher value

//        creating a 2d array with 2 col - index, ratio
        double[][] ratio = new double[weight.length][2];

        for(int i=0; i<weight.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double) weight[i];
        }

//        sorting ratio by their ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for(double[] i : ratio){
            System.out.println(Arrays.toString(i));
        }
//        now the ratio array are sorted in the increasing ratio
//        but we want to sort as decreasing fashion - either reverse the array or traverse from last to first

        int maxValue = 0;

        for(int i= ratio.length-1; i>=0; i--){
            int index = (int)ratio[i][0];

            if(capacity >= weight[index]){
                // total include
                maxValue += value[index];
                capacity -= weight[index];
            }
            else{
                // fractional include
                maxValue += ratio[i][1] * capacity;
                break;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] weight = {20, 10, 30};
        int[] value = {100, 60, 120};
        int capacity = 50; // in kg

        System.out.println(maximumValue(weight, value, capacity));
    }
}