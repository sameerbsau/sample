package code;

public class FibonaciRecursion {
    public static void main(String[] args) {

        System.out.println(0);
        System.out.println(1);
        printFibonaci(0,1,10);
    }

    private static void printFibonaci(int i, int i1, int i2) {

        if(i2==0)
            return;

        System.out.println(i+i1);

        printFibonaci(i1, i+i1, --i2 );
    }
}
