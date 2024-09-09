package streams;


interface FunctInt{
    int apply(int a, int b);
}

public class FunctionalInter {



    public static void main(String[] args) {
        FunctInt functInt = ((a, b) -> a+b);

        int result = functInt.apply(2,2);
        System.out.println(result);
    }

}
