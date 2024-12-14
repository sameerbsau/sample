package UdemyCourse;

import java.util.Arrays;

public class DynamicProgramming {
    static int counter = 0;
    public static int fib(int n) {
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;

        for (int index = 2; index <= n; index++) {
            counter++;
            fibList[index] = fibList[index - 1] + fibList[index - 2];
        }
        return fibList[n];
    }
    static Integer[] memo = new Integer[100];

    public static int fib2(int n) {
        counter++;

        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }

        memo[n] = fib(n - 1) + fib(n - 2);

        return memo[n];
    }


    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int[] findMaxMin(int[] myList) {
        int maximum = myList[0];
        int minimum = myList[0];
        for (int num : myList) {
            if (num > maximum) {
                maximum = num;
            } else if (num < minimum) {
                minimum = num;
            }
        }
        return new int[] {maximum, minimum};
    }

    public static String findLongestString(String[] stringList){

        String longest = "";

        for (String s: stringList){
            if(s.length() > longest.length()){
                longest =s;
            }
        }

        return longest;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int writePointer = 1;

        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }

        return writePointer;
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        // Reverse the first part
        for (int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the second part
        for (int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the whole array
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public static int maxSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
      int result =   removeElement(new int[]{0,1,2,4,4,6,2,3}, 2);
      removeDuplicates(new int[]{0,1,2,4,4,6,2,3});
      maxProfit(new int[]{0,1,2,4,4,6,2,3});
      int[] r = new int[]{1, 2, 3, 4, 5, 6, 7};
       // rotate(r,3);
        maxSubarray(r);
        System.out.println(result);
    }
}