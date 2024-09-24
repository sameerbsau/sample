package code.javatpoint;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 23, 15, 8, 4, 3, 25, 30, 34, 2, 19};

        int res = search(arr, 25);
        System.out.println(res);
    }

    private static int search(int[] arr, int item) {

        for(int i=0; i< arr.length;i++){
            if(arr[i]==item){
                return i;
            }
        }
        return -1;
    }
}
