package code.javatpoint;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        int size = a.length;

        for (int i=0; i< size;i++){
            for (int j = 0; j<size;j++){
                if(a[i]<a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(a));

    }
}
