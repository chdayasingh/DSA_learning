package Greedy;

import java.util.ArrayList;
import java.util.Collections;

// apna clg- greedy v10
public class JobSequencing {

    // static class- because this is inner class, so we cannot instantiate without parent class therefore to directly instantiate we created this static class
    static class Job{
         char id;
         int deadline, profit;
         Job(char id, int deadline, int profit){
             this.id = id;
             this.deadline = deadline;
             this.profit = profit;
         }
    }


    // TC - O(n)
    private static int maxDeadline(ArrayList<Job> jobs){
        int ans = Integer.MIN_VALUE;

        for(Job curr : jobs){
            if(curr.deadline > ans){
                ans = curr.deadline;
            }
        }
        return ans;
    }

    public static int maxProfit(ArrayList<Job> jobs){

//        Sorting the jobs arraylist based on their profit in decreasing order
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        // to store sequence
        ArrayList<Character> seq = new ArrayList<>();

        // maximum deadline among all jobs be the total number of time slot available
        int numOfTimeSlot = maxDeadline(jobs);
        boolean[] timeSlot = new boolean[numOfTimeSlot];

        int maxProfit = 0;

        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
//            Find a free slot for this job
            for(int j= curr.deadline-1; j>=0; j--){
                if(timeSlot[j] == false){
                    timeSlot[j] = true;
                    maxProfit += curr.profit;
                    seq.add(curr.id);
                    break;
                }
            }
        }

        System.out.println(seq.toString());

        return maxProfit;
    }

    public static void main(String[] args) {

//        int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
      int jobsInfo[][] = {{1,20}, {1,10}, {4,40}, {1,30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobsInfo.length; i++){
            jobs.add(new Job((char) (i+65), jobsInfo[i][0], jobsInfo[i][1]));
        }

        System.out.println(maxProfit(jobs));

    }
}
