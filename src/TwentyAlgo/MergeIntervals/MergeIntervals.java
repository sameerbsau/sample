package TwentyAlgo.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        int[][] arr2 ={{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<int[]> result = bruteForce(arr);
        int newSize = mergeOverlap(arr2);
    }

    private static int mergeOverlap(int[][] arr) {
        int resIdx = 0;
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));
        for (int i=1; i< arr.length;i++){
            if(arr[resIdx][1]>= arr[i][0]){
                arr[resIdx][1] = Math.max(arr[resIdx][1],arr[i][1]);
                System.out.println();
            }else {
                resIdx++;
                arr[resIdx] = arr[i];
                System.out.println();
            }
        }
        return resIdx+1;
    }

    private static List<int[]> bruteForce(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] curr = arr[i];
            if (curr[0] < last[1]) {
                last[1] = Math.max(curr[1], last[1]);
                System.out.println();
            } else {
                result.add(curr);
            }
        }
        return result;
    }
}
