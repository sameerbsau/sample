package TwentyAlgo.TwoPointer;

public class ClosestPair {
    public static void main(String[] args) {
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int x = 38;
        bruteForce(ar1, ar2, x);
    }

    private static void bruteForce(int[] ar1, int[] ar2, int x) {
        int diff = Integer.MAX_VALUE;
        int res1=0, res2 = 0;

        int l = 0, r = ar2.length - 1;
        while (l < ar1.length && r>=0) {

            if (Math.abs(ar1[l] + ar2[r] - x) < diff) {
                res1 = ar1[l];
                res2 = ar2[r];
                diff = Math.abs(ar1[l] + ar2[r] - x);
            }
            if (ar1[l] + ar2[r] < x) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println("closet pair "+res1+" "+ res2);
    }

    // there is another approach which includes binary search of an array2 for the each element in array1
}
