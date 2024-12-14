package series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayQuestions {

    //https://leetcode.com/problems/insert-interval/?envType=daily-question&envId=2024-03-17
    //Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    //Output: [[1,5],[6,9]]
    //Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //Output: [[1,2],[3,10],[12,16]]
    public static int[][] insertInterval(int[][] intervals, int[] newIntervals){
        ArrayList<int[]> result = new ArrayList<>();
        int i =0;
        int n = intervals.length;
        while (i< n && intervals[i][1]<newIntervals[0]){
            result.add(intervals[i]);
            i++;
        }
        //merge overlapping intervals if any
        while (i<n && newIntervals[1]>= intervals[i][0]){
            newIntervals[0]= Math.min(newIntervals[0],intervals[i][0] );
            newIntervals[1]=Math.max(newIntervals[1],intervals[i][1]);
            i++;
        }
        result.add(newIntervals);
        while (i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }

    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=daily-question&envId=2024-03-18
    //Input: points = [[10,16],[2,8],[1,6],[7,12]]
    //Output: 2
    public int findMinArrowShots(int[][] points) {
     int n = points.length;
     if (n==1) return 1;
     int arrows = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0]) return -1;
                if(o1[0]==o2[0]) return 0;
                return 1;
            }
        });
        int[] overlapping = points[0];
        for (int i=1; i< n; i++){
            int curS = points[i][0];
            int curE = points[i][1];
            //if intervals are overlapping then we can use the existing arrow to burst it
            if(curS< overlapping[1]){
                overlapping[0]= Math.max(curS, overlapping[0]);
                overlapping[1]= Math.min(curE, overlapping[1]);
            }else{
                overlapping[0]= curS;
                overlapping[1]= curE;
                arrows++;
            }
        }
     return arrows;
    }

    public static List<Integer> findDuplicates(int [] input){
        List<Integer> result = new ArrayList<>();
        //brut force approach
        for(int i = 0; i< input.length; i++){
            for(int j = i+1; j< input.length; j++){
                if(input[i]== input[j]){
                    result.add(input[i]);
                }
            }
        }
        return result;
    }


    public static List<Integer> findDuplicates2(int [] input){
        List<Integer> result = new ArrayList<>();
        //sorted array Approach
        Arrays.sort(input);
        //int j = 0;
        for(int i = 1; i< input.length; i++){
            if(input[i]==input[i-1]){
                result.add(input[i]);

            }
            //j++;
        }
        return result;
    }

    public static List<Integer> findDuplicates3(int [] input){
        List<Integer> result = new ArrayList<>();
        //without sorted array Approach only for positive numbers
        for(int element: input){
            element = Math.abs(element);
            int seat = element-1;
            if(input[seat]<0){
                result.add(element);
            }else{
                input[seat] = -input[seat];
            }
        }


        return result;
    }
}