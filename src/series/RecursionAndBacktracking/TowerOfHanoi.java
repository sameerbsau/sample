package series.RecursionAndBacktracking;

import java.util.Arrays;

public class TowerOfHanoi {

    // Recursive function to solve the Tower of Hanoi problem
    public static void solveHanoi(int n, char source, char destination, char auxiliary, long[] moves) {
        // Base case: If there's only 1 disk, move it from source to destination
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        moves[0]++;
        // Move top n-1 disks from source to auxiliary, using destination as auxiliary
        solveHanoi(n - 1, source, auxiliary, destination, moves);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move the n-1 disks from auxiliary to destination, using source as auxiliary
        solveHanoi(n - 1, auxiliary, destination, source, moves);
    }

    public static void main(String[] args) {
        // Number of disks
        int n = 3;
long moves[] = new long[1];        // A, B, and C are the names of the rods
        solveHanoi(n, 'A', 'C', 'B',moves);  // Move n disks from A (source) to C (destination) using B (auxiliary)
        System.out.println(Arrays.toString(moves));
    }
}
