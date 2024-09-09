package code;

public class NumberPalindrome {
    public static void main(String[] args) {
        int num1 = 121;
        int num2 = 12321;

        boolean isPal = checkPalindrome(num1);
        boolean isPal1 = checkPalindrome(num2);
    }

    private static boolean checkPalindrome(int num1) {
        int original = num1;
        int reversed =0;
        while (num1 > 0){

            int digit = num1%10;
            reversed = reversed *10 + digit;
            num1 /=10;
        }

        return original == num1;
    }
}
