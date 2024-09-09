package TwentyAlgo.Monotonic;

import java.util.*;

public class Decreasing {

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        List<Integer> result = monotonicDecreasing(nums);
        System.out.println("Monotonic decreasing stack: " + result);
    }
    public static List<Integer> monotonicDecreasing(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        // Traverse the array
        for (int num : nums) {
            // While stack is not empty AND top of stack is less than the current element
            while (!stack.isEmpty() && stack.peek() < num) {
                // Pop the top element from the stack
                stack.pop();
            }

            // Construct the result array
            if (!stack.isEmpty()) {
                result.add(stack.peek());
            } else {
                result.add(-1);
            }

            // Push the current element into the stack
            stack.push(num);
        }

        return result;
    }
}
