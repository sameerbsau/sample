package TwentyAlgo.Bitwise;
//https://www.youtube.com/watch?v=IAAkxO9n3co
public class BItwiseAND {
    public static void main(String[] args) {

     int result =    rangeBitwiseAND(5, 7);
        System.out.println(result);
    }

    private static int rangeBitwiseAND(int left, int right) {
        int shifts = 0;
        while (left<right){
            left = left>>1;
            right = right>>1;
            shifts++;
        }
        return left<<shifts;
    }
}
