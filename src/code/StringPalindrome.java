package code;

import java.util.HashMap;
import java.util.Map;

public class StringPalindrome {


    public static void main(String[] args) {
        String input = "tacoocat";
        boolean result = checkPermutation(input);
        System.out.println("result"+ result);
    }

    private static boolean checkPermutation(String input) {
        input = input.replace(" ","").toLowerCase();
        Map<Character, Integer> hashmap = new HashMap<>();
        for(char c: input.toCharArray()){
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }

        boolean firstOddcharfound = false;
        for(int count: hashmap.values()){
            if(count%2 !=0){
                if(firstOddcharfound){
                    return false;
                }
                firstOddcharfound = true;
            }
        }
        return true;
    }
}
