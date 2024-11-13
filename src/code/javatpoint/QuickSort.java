package code.javatpoint;

public class QuickSort {
    public static void main(String[] args) {
        int i;
        int[] arr = {90, 23, 101, 45, 65, 23, 67, 89, 34, 23};
        quickSort(arr, 0, 9);
        System.out.println("\n The sorted array is: \n");
        for (i = 0; i < 10; i++)
            System.out.println(arr[i]);
    }

    public static int partition(int a[], int beg, int end) {

        int left, right, temp, loc, flag;
        loc = left = beg;
        right = end;
        flag = 0;
        while (flag != 1) {
            while ((a[loc] <= a[right]) && (loc != right)) right--;
            if (loc == right) flag = 1;
            else if (a[loc] > a[right]) {
                temp = a[loc];
                a[loc] = a[right];
                a[right] = temp;
                loc = right;
            }
            if (flag != 1) {
                while ((a[loc] >= a[left]) && (loc != left)) left++;
                if (loc == left) flag = 1;
                else if (a[loc] < a[left]) {
                    temp = a[loc];
                    a[loc] = a[left];
                    a[left] = temp;
                    loc = left;
                }
            }
        }
        return loc;
    }

    static void quickSort(int a[], int beg, int end) {

        int loc;
        if (beg < end) {
            loc = partition(a, beg, end);
            quickSort(a, beg, loc - 1);
            quickSort(a, loc + 1, end);
        }
    }

    public static void sort(int arr[], int start, int end) {

        if (start >= end) {
            return;
        }
        int pi = partition(arr, start, end);
        sort(arr, start, pi - 1);
        sort(arr, pi + 1, end);

    }


    public static int partition2(int arr[], int low, int high) {

        int pivot = arr[low];
        int i = low, j = high;

        while (i < j) {
            while (i < high && arr[i] <= pivot) i++;
            while (j > low && arr[j] > pivot) j--;

            if (i < j) {
                swap(arr, i, j);
            }

        }
        swap(arr, low, j);

        return j;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}