package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    // Dry run in BigR


    public static int activitySelectionForSortedEndTime(int[] startTime, int[] endTime){
        // Goal: find max num of activities we can do
        // assuming we get sorted end time

        // A0 have early end time we do that surely
        int maxAct = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        // saving last activity end time
        int lastEnd = endTime[0];

        for(int i=1; i<endTime.length; i++){
            if(startTime[i] >= lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd = endTime[i];
            }
        }
        // printing activity that we will do
        System.out.print("Activities: (");
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i) + ", ");
        }
        System.out.println(")");
        return maxAct;
    }

    public static int activitySelection(int[] startTime, int[] endTime){
        // creating 2d array - 1st col(ActivityNum) , 2nd col (startTime), 3rd col (endTime)
        int[][] activities = new int[startTime.length][3];

        for(int i=0; i<activities.length; i++){
            activities[i][0] = i;
            activities[i][1] = startTime[i];
            activities[i][2] = endTime[i];
        }

        for(int[] i : activities){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();

        // Sort 2d array based on 2th column (end Time)
        Arrays.sort(activities, Comparator.comparingDouble(row -> row[2]));

        for(int[] i : activities){
            System.out.println(Arrays.toString(i));
        }

        int maxAct = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);
        // saving last activity end time
        int lastEnd = activities[0][2];

        for(int i=1; i<activities.length; i++){
            if(activities[i][1] >= lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        // printing activity that we will do
        System.out.print("Activities: (");
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i) + ", ");
        }
        System.out.println(")");
        return maxAct;
    }

    public static void main(String[] args) {
//        int[] startTime = {1,3,0,5,8,5};
//        int[] endTime = {2,4,6,7,9,9};

//        System.out.println("Max Activities: " + activitySelectionForSortedEndTime(startTime, endTime));

        int[] startTime = {3,0,1,8,5,5};
        int[] endTime =   {4,6,2,9,7,9};

        System.out.println("Max Activities: " + activitySelection(startTime, endTime));
    }

}
