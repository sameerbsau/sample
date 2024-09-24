package TwentyAlgo.SlidingWindow;

//https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
public class SmallestArray {
    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 0, 19};
        int k = 51;
        int result = bruteForce(arr, k);
        result=  smallest(arr, k);
        System.out.print(result);

    }


    public static int smallest(int arr[], int k){
        int l = arr.length;
        int minLength = l+1;
        int start=0, end =0, currSum=0;

        while(end<l){

            while(currSum<= k && end <l){
                currSum += arr[end++];
            }

            while(currSum>k && start < l){
                if(end-start <minLength){
                    minLength = end-start;
                }

                currSum -= arr[start++];
            }

        }


        return minLength;
    }
    public static int bruteForce(int arr[], int k) {
        int l = arr.length;
        int minLength = l + 1;
        for (int start = 0; start < l; start++) {

            int currSum = arr[start];

            //base case
            if (currSum > k) {
                return 1;
            }

            for (int end = start + 1; end < l; end++) {
                currSum += arr[end];

                if (currSum > k && (end - start + 1) < minLength) {
                    minLength = end - start + 1;
                }
            }

        }

        return minLength;
    }
}

