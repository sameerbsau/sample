package series.RecursionAndBacktracking;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        char [] s = {'h','e','l','l','o'};
        recur(s,0);
        System.out.println(Arrays.toString(s));
    }

    private static void recur(char[] s, int i) {
        if(s.length/2==i){
            return;
        }

        swap(s, i, s.length-i-1);
        recur(s, i+1);
    }

    private static void swap(char[] s, int i1, int i2) {
        char temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }
}
