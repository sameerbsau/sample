package TwentyAlgo.SlidingWindow;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum/

public class SubArraySum {
    // Function to find a continuous sub-array which adds up
    // to a given number.
    static ArrayList<Integer> bruteForce(int[] arr, int n, long sum) {

        // To store the result
        ArrayList<Integer> res = new ArrayList<>();

        // Flag to indicate if the subarray is found
        boolean flag = false;

        for (int i = 0; i < n; i++) {

            // Initialize the current sum
            int currentSum = arr[i];

            // Check if the single element is the sum
            if (currentSum == sum) {
                res.add(i + 1);
                res.add(i + 1);
                flag = true;
                break;
            } else {
                // Try all subarrays starting with 'i'
                for (int j = i + 1; j < n; j++) {
                    currentSum += arr[j];

                    if (currentSum == sum) {
                        res.add(i + 1);
                        res.add(j + 1);
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
        }
        if (flag) return res;
        res.add(-1); // If no subarray is found
        return res;
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, long sum) {
        int last = 0;
        int start = 0;
        long currsum = 0;
        boolean flag = false;
        ArrayList<Integer> res = new ArrayList<>();

        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // Store sum up to current element
            currsum += arr[i];

            // Check if current sum is greater than or equal to given number
            if (currsum >= sum) {
                last = i;

                // Start from starting index till current index
                while (sum < currsum && start < last) {
                    // Subtract the element from left
                    currsum -= arr[start];
                    ++start;
                }

                // If current sum becomes equal to given number
                if (currsum == sum) {
                    res.add(start + 1);
                    res.add(last + 1);
                    flag = true;
                    break;
                }
            }
        }

        // If no subarray is found, store -1 in result
        if (!flag) res.add(-1);

        // Return the result
        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        long sum = 23;
        ArrayList<Integer> result = subarraySum(arr, n, sum);
        for (int i : result)
            System.out.print(i + " ");
    }
}
