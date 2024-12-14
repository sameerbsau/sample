package UdemyCourse;

import java.util.*;

class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public boolean compareAny(int[] arr1, int[] arr2) {
        HashMap<Integer, Boolean> unique = new HashMap<>();
        for (int i : arr1) {
            unique.put(i, true);
        }
        for (int j : arr2) {
            if (unique.get(j) != null) return true;
        }
        return false;
    }

    public static List<Integer> findDuplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        HashMap<Integer, Integer> unique = new HashMap<>();
        for (int i : arr) {
            unique.put(i, unique.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : unique.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    public static Character firstNonRepeatingChar(String input) {
        HashMap<Character, Integer> unique = new HashMap<>();

        for (char c : input.toCharArray()) {
            unique.put(c, unique.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : unique.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
//        for (int i = 0; i < string.length(); i++) {
//            char c = string.charAt(i);
//            if (charCounts.get(c) == 1) {
//                return c;
//            }
//        }

        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings) {

        HashMap<String, List<String>> set = new HashMap<>();
        for (String s : strings)  {
            char[] chars = s.toCharArray();

            Arrays.sort(chars);
            String key = new String(chars);
            if (set.get(key) == null) {
                List<String> group = new ArrayList<>();
                group.add(s);
                set.put(key, group);
            } else {
                List<String> list = set.get(key);
                list.add(s);
            }
        }

        return new ArrayList(set.values());
    }

    public static int [] twoSum(int [] input, int target){

        for(int i : input){
            for(int j: input){
                if(i+j == target) return new int[]{i,j};
            }
        }

        return new int[]{};

    }

    public static int [] twoSum2(int [] input, int target){
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int i : input){
            int complement = target-i;

            if(numMap.containsKey(complement)){
                return new int[]{complement, i};
            }

            numMap.put(i,i);
        }
        return new int[]{};
    }
//here we need to return the index
    public static int[] twoSumindex(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(num, i);
        }

        return new int[]{};
    }
//here we are returning the indexes of the target sum
    public static int [] subarraySum(int [] input, int target){
        HashMap<Integer, Integer> numMap = new HashMap<>();
        numMap.put(0,-1);
        int currentSum = 0;
        for(int i = 0; i< input.length; i++){
            currentSum += input[i];
            if(numMap.containsKey(currentSum-target)){
                return new int[]{
                        numMap.get(currentSum-target)+1, i
                };
            }

            numMap.put(currentSum,i);

        }

        return new int[]{};

    }

    public static boolean hasUniqueChars(String string){

        char [] chars = string.toCharArray();

        Set<Character> seen = new HashSet();

        for(char c: chars){

            if(seen.contains(c)){
                return false;
            }else{
                seen.add(c);
            }
        }

        return true;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        List<int[]> result = new ArrayList<>();

        Set<Integer> set = new HashSet();

        for (int num : arr1) {
            set.add(num);
        }

        for(int i: arr2){

            int complement = target - i;

            if(set.contains(complement)){
                result.add(new int[]{complement, i});
            }
        }

        return result;

    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

public class HashTableExample {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.set("nails", 100);
        ht.set("tile", 100);
        ht.set("lumber", 100);
        ht.set("bolts", 100);
        ht.set("screws", 100);
        ht.printTable();
        System.out.println(ht.get("bolts"));
        System.out.println(ht.keys());

        System.out.println(ht.compareAny(new int[]{1, 2, 3}, new int[]{4, 5, 3}));

        System.out.println(Arrays.toString(HashTable.twoSum(new int[]{1,2,3,4,5}, 25)));
        System.out.println(Arrays.toString(HashTable.twoSum2(new int[]{1,2,3,4,5}, 5)));
        System.out.println(HashTable.longestConsecutiveSequence(new int[]{100, 4, 200, 1, 3, 2}));
    }
}