package TwentyAlgo.CyclicSort;

public class CycleSort {
    public static void main(String[] args) {
        int arr[] = {2, 7, 1, 5, 4, 6, 3};
        //cycleSort0ToN(arr);
        //cycleSort1ToN(arr);

        cycleSort(arr);
        System.out.println();
    }

    private static void cycleSort(int[] arr) {
        int n = arr.length;
        for (int cycles = 0; cycles < n - 1; cycles++) {
            int pos = cycles;
            int item = arr[cycles];

            //find smaller no of elements
            for (int i = cycles + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            //if element is at correct position
            if (pos == cycles) {
                continue;
            }

            //ignore duplicates
            while (arr[pos] == item) {
                pos++;
            }

            //if smaller elements are found then perform swapping
            if (pos != cycles) {
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }

            //check if more swaps are required
            while (pos != cycles) {
                pos = cycles;
                //find smaller number of elements
                for (int i = cycles + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                //ignore duplicates
                while (arr[pos] == item) {
                    pos++;
                }
                if (item != arr[pos]) {
                    int temp = arr[pos];
                    arr[pos] = item;
                    item = temp;
                }
            }
        }
    }

    private static void cycleSort1ToN(int[] arr) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            int actualPosition = element - 1;

            if (arr[index] < n && arr[index] != arr[actualPosition]) {
                swap(arr, index, actualPosition);
            } else {
                index++;
            }
        }
    }

    private static void cycleSort0ToN(int[] arr) {
        int n = arr.length;
        int index = 0;

        while (index < n) {
            int element = arr[index];
            int actualPosition = element;
            if (arr[index] < n && arr[index] != arr[actualPosition]) {
                swap(arr, index, actualPosition);
            } else {
                index++;
            }
        }

    }

    private static void swap(int[] arr, int index, int actualPosition) {
        int temp = arr[index];
        arr[index] = arr[actualPosition];
        arr[actualPosition] = temp;
    }
}
