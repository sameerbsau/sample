import java.util.HashMap;
import java.util.Map;

 class PalindromePermutation {
    public static void main(String[] args) {
        String input = "taco cat";
        boolean isPalindromePermutation = checkPalindromePermutation(input);
        System.out.println("Is palindrome permutation: " + isPalindromePermutation);
    }

    public static boolean checkPalindromePermutation(String input){
        input = input.replace(" ", "").toLowerCase();
        Map<Character, Integer> haspmap = new HashMap<>();
        for(char c : input.toCharArray()){
            haspmap.put(c, haspmap.getOrDefault(c,0)+1);

        }

        boolean firstOddcharfound = false;
        for(int count: haspmap.values()){

            if(count % 2 !=0){
                if(firstOddcharfound){
                    return false;
                }

                firstOddcharfound = true;
            }
        }
        return true;
    }
}
