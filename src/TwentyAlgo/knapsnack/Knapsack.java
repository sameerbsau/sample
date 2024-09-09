package TwentyAlgo.knapsnack;
//chat GPT
public class Knapsack {

    // Function to solve the 0/1 Knapsack problem
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length;

        // Create a DP table to store the maximum value for each capacity and item count
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the table in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Take the maximum of including the current item or excluding it
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // If the current item's weight exceeds the current capacity, exclude it
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The last cell of the table contains the maximum value for the given capacity
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // Example usage
        int[] values = {60, 100, 120};   // values of the items
        int[] weights = {10, 20, 30};    // weights of the items
        int capacity = 50;               // capacity of the knapsack

        int maxValue = knapsack(weights, values, capacity);

        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
