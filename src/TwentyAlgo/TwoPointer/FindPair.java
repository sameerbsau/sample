package TwentyAlgo.TwoPointer;

public class FindPair {
    //Find pair in the array for the given sum
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 8, 9, 10, 11};
        int sum = 17;
        //System.out.println(findPairBruteForce(arr, sum));
        System.out.println(findPairTwoPointer(arr, sum));
    }

    private static boolean findPairBruteForce(int[] arr, int sum) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                //this condition will never be met as the j = i+1
                if (i == j)
                    continue;

                if (arr[i] + arr[j] == sum) {
                    return true;
                }

                if (arr[i] + arr[j] > sum)
                    break;
            }
        }
        return false;
    }

    public static boolean findPairTwoPointer(int[] arr, int sum) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == sum)
                return true;
            else if (arr[i] + arr[j] < sum)
                i++;
            else
                --j;
        }
        return false;
    }

}
