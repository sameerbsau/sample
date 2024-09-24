package RoughSpace;

public class Practise {
    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
      int result =  findMax(arr, k);
        System.out.print(result);
    }

    public static int findMax(int arr[], int k){
        int l = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<=l-k; i++ ){
            int sum = 0;
            for(int j= i; j< i+k; j++){
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
