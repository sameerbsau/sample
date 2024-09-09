package TwentyAlgo.Bitwise;
//https://www.youtube.com/watch?v=W3k-M8OuSpA
public class SubsetXOR {
    public static void main(String[] args) {
        int [] nums = {1,3};
   int result =  findXORTotal(nums,0,0);
        System.out.println(result);
    }

    private static int findXORTotal(int[] nums, int index, int xor) {
        //base case
        if(index == nums.length ){
            return  xor;
        }
        int pick = findXORTotal(nums, index+1, xor^nums[index]);
        int noPick = findXORTotal(nums, index+1, xor);
        return pick+noPick;
    }
}
