package TwentyAlgo.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
         subSets(nums,res);
        System.out.println(res);
    }

    private static void subSets(int[] nums,List<List<Integer>> res ) {

        findSubsets(nums, 0 , new ArrayList<>(), res);
    }

    private static void findSubsets(int[] nums, int index, List<Integer> sublist, List<List<Integer>> res) {

        if(index == nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }

        sublist.add(nums[index]);
        findSubsets(nums, index+1, sublist,res);
        sublist.remove(sublist.size()-1);
        findSubsets(nums, index+1, sublist,res);

    }
}
