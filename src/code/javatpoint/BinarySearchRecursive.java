package code.javatpoint;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] arr = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};
        int result = binarySearch(arr, 0, arr.length, 78);
        System.out.println(result);
    }

    private static int binarySearch(int[] arr, int start, int end, int item) {
        if(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == item){
                return mid;
            } else if (arr[mid]< item) {
              return   binarySearch(arr, mid+1, end,item);
            }
            else{
              return   binarySearch(arr, start, mid-1,item);
            }

        }
  return -1;
    }
}

