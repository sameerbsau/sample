package series.RecursionAndBacktracking;
//https://github.com/Tiwarishashwat/Ultimate-Recursion-Series/tree/main
public class General {
    public static void main(String[] args) {
        System.out.println("Hello World");
        fun(5);
        //get the binary for the given input
        //toBinary(100);
        reverseNumber(543210);
        int num = 0;
        //reverseNumber(543210, num);
        reverseString("543210", "", 0);

    }

    public static void reverseString(String input, String res, int index) {

        if (input.length() == index) {
            return;
        }
        res = input.charAt(index) + res;
        System.out.println(res);
        reverseString(input, res, ++index);

    }

    public static void reverseNumber(int N, int result) {
        if (N == 0) {
            return;
        }


        result = result * 10 + (N % 10);
        System.out.println(result);
        reverseNumber(N / 10, result);


    }

    public static void reverseNumber(int N) {
        if (N == 0) {
            return;
        }

        System.out.print(N % 10);

        reverseNumber(N / 10);


    }

    public static void toBinary(int N) {
        if (N == 0) {
            return;
        }

        toBinary(N / 2);
        System.out.print(N % 2);


    }

    public static void fun(int n) {
        if (n <= 0) {
            return;
        }
        fun(n - 1);
        System.out.println(n);


    }
}