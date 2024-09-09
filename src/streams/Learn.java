package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Learn {


    public static void main(String[] args) {

    List<String> names = new ArrayList<>();
    names.add("alice");
    names.add("Bob");
    names.add("Charlie");
    names.add("David");

        List<String> filteredNames = names.stream().filter(n -> n.length() > 3).collect(Collectors.toList());
        System.out.println(filteredNames);
//list sorting
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);

        //mapping
        List<String> mappedNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(mappedNames);

        //matching
        boolean isExist = names.stream().anyMatch(r -> r.contains("a"));
        System.out.println(isExist);

        //reduce
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

       int sum= numbers.stream().reduce(0 ,(a,b) -> a+b);
        System.out.println(sum);

        //grouping by

       Map<Integer, List<String>> group = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(group);

        //flatmap example

        List<List<String>> nested = Arrays.asList(
                Arrays.asList("apple","orange"),
                Arrays.asList("grape","watermellon"),
                Arrays.asList("custard","kiwi")

        );

       List<String> flatmap =nested.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatmap);
//map sorting
        Map<String, Integer> unSortedmap = new HashMap<>();
        unSortedmap.put("John",25);
        unSortedmap.put("Alice",35);
        unSortedmap.put("Bob",29);
        unSortedmap.put("Charlie",43);

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(unSortedmap.entrySet());
        System.out.println(entryList);
        entryList.sort(Map.Entry.comparingByValue());
        System.out.println(entryList);

        Map<String,Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String,Integer>data: entryList){
            sortedMap.put(data.getKey(), data.getValue());
        }
        System.out.println(sortedMap);

        //my own logic
        List keys = new ArrayList<>(unSortedmap.keySet());
        Collections.sort(keys);
        System.out.println(keys);

        //streaming string chars

        String sample ="Hello world";
        sample.chars().mapToObj(d -> (char)d).forEach(System.out::println);

    }
}
