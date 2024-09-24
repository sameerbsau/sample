package code.javatpoint;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        int temp, pos;
        for (int i = 0; i < a.length; i++) {
            pos = smallest(a, i);

            temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;

        }
        System.out.println(Arrays.toString(a));

    }

    private static int smallest(int[] a, int ind) {
        int pos = ind;
        int small = a[ind];
        for (int i = ind+1; i < a.length; i++) {
            if (a[i] < small) {
                small = a[i];
                pos = i;
            }
        }
        return pos;
    }
}
