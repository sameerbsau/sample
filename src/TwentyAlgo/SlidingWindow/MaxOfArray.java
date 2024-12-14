package TwentyAlgo.SlidingWindow;
//https://www.geeksforgeeks.org/window-sliding-technique/
public class MaxOfArray {
    public static void main(String[] args) {
        int arr[] = {1,4,2,10,2,3,1,0,20};
        int k = 4;
       int result1 = bruteForce(arr, k);
       // int result1 = anotherApproach(arr,k);
        System.out.println(result1);
    }

    private static int anotherApproach(int[] arr, int k) {
        int n = arr.length;
        int MaxSUM = 0;
        if(n< k){
            return -1;
        }
        for (int i = 0; i< k; i++){
            MaxSUM += arr[i];
        }
        int windowSum = MaxSUM;
        for (int i = k ; i< n; i++){
            windowSum += arr[i]-arr[i-k];
            MaxSUM = Math.max(MaxSUM,windowSum);
        }
        return MaxSUM;
    }

    private static int bruteForce(int[] arr, int k) {
        int n = arr.length;
        int MAX_SUM = Integer.MIN_VALUE;
        for (int i = 0; i<= n-k;i++){
            int currentSum = 0;
            for (int j = i; j<k+i; j++){
                currentSum += arr[j];
            }
            MAX_SUM = Math.max(MAX_SUM, currentSum);
        }
        return MAX_SUM;
    }
}