package code;

public class FibonaciSeries {

    public static void main(String[] args) {
        int n = 10;

        //generateFibonaciSerieswitharray(10);
        fibonaciBasic();
    }

    private static void fibonaciBasic() {
        int n1=0,n2=1,n3;
        System.out.println(n1);
        System.out.println(n2);
        for(int i = 2; i< 12;i++){
            n3 = n1+n2;
            System.out.println(n3);
            n1=n2;
            n2 = n3;
        }

    }

    private static void generateFibonaciSerieswitharray(int i) {

        int[] arr = new int[i];
        arr[0]=0;
        arr[1]=1;

        for (int j = 2; j<i; j++){
            arr[j] = arr[j-1]+ arr[j-2];
        }

        for (int num: arr){
            System.out.println(num);
        }
    }
}
