package TwentyAlgo.TwoPointer;

public class ClosestPair2 {
    public static void main(String[] args) {
        int[] arr = { 10, 22, 28, 29, 30, 40 };
        int x = 54;
        bruteForce(arr, x);

    }

    private static void bruteForce(int[] arr, int x) {
        int n = arr.length;
        int diff = Integer.MAX_VALUE;
        int res1=0,res2=0;
        for (int i = 0; i< n-1; i++){
            for (int j = i+1; j< n; j++){

                if(Math.abs(arr[i]+arr[j]-x)< diff){
                    res1 = arr[i];
                    res2=arr[j];
                    diff = Math.abs(arr[i]+arr[j]-x);
                }


            }
        }

        System.out.println("closest pair to "+x+"is --"+ res1+" "+res2);
    }
}
