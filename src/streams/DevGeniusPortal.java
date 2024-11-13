package streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
public class DevGeniusPortal {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 23, 45, 44, 67, 89, 87);
        //find even numbers
        list.stream().filter(d -> d % 2 == 0).forEach(r -> System.out.println(r));
        list.stream().filter(d -> d % 2 == 0).forEach(System.out::println);
        int[] nums = {10, 23, 45, 44, 67, 89, 87};
        Map<Boolean, List<Integer>> result = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(r -> r % 2 == 0));
        System.out.println(result);


        //find out numbers starting with 1
        list.stream().filter(r -> r.toString().startsWith("1")).forEach(System.out::println);
        list.stream().map(r -> r + "").filter(r -> r.startsWith("1")).forEach(System.out::println);


        //find duplicates in the list of integers
        List<Integer> list2 = Arrays.asList(10, 23, 45, 44, 67, 89, 87, 10, 23);
        list2.stream().distinct().forEach(System.out::print);
        System.out.println();
        Set<Integer> set = new HashSet<>();
        list2.stream().filter(r -> !set.add(r)).forEach(System.out::println);

        //find first from the list
        list2.stream().findFirst().ifPresent(System.out::println);

        //find the total count
        list2.stream().count();
        System.out.println(list2.stream().count());

        //find the maximum element
        System.out.println(list2.stream().max(Integer::compare).get());
        list2.stream().max(Integer::compare).get();
        System.out.println(list.stream().max(Comparator.naturalOrder()).get());


        //find first non-repeated character
        String input = "Java articles are Awesome";
        Character resultC = input.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(k -> k.getValue() == 1L).map(entry -> entry.getKey()).findFirst().get();
        System.out.println(resultC);
        System.out.println(input.chars().mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c)).findFirst().orElse(null));

        //find first repeated character
        resultC = input.chars()
                .mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst().get();
        System.out.println(resultC);

        //sort the values present in the stream
        list2.stream().sorted().forEach(System.out::println);

        //sort the values in the reverse order
        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);

        //if any value appeared atleast twice

        Set<Integer> duplicate = new HashSet<>();
        System.out.println(list2.stream().anyMatch(r -> !duplicate.add(r)));

        //get the current date time using java 8
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());


        //java 8 progrma to concatinate two streams
        List<String> l1 = Arrays.asList("Java", "8");
        List<String> l2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(l1.stream(), l2.stream());
        concatStream.forEach(System.out::println);

        //Java 8 program to perform cube on list elements and filter numbers greater than 50
        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        integerList.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);

        //Write a Java 8 program to sort an array and then convert the sorted array into Stream

        int arr[] = {99, 55, 203, 99, 4, 91};
        Arrays.parallelSort(arr);
        Arrays.stream(arr).boxed().forEach(System.out::println);


        // How to use map to convert object into Uppercase in Java 8

        List<String> names = Arrays.asList("sameer", "super");
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order


        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));
        noteLst.add(new Notes(6, "note4", 66));

        Map<String, Integer> records = noteLst.stream().sorted(Comparator.comparingInt(Notes::getTagId).reversed()).collect(Collectors.toMap(Notes::getTagName, Notes::getTagId, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(records);


        //How to count each element/word from the String ArrayList in Java8
        List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names1.stream().collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        System.out.println(namesCount);

        //How to find only duplicate elements with its count from the String ArrayList in Java8
        namesCount = names1.stream().filter(x -> Collections.frequency(names1, x) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namesCount);

        namesCount = names1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(namesCount);

        //How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object

        Optional.of(noteLst).orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Notes::getTagName)
                .forEach(System.out::println);

        //Write a Program to find the Maximum element in an array?

        System.out.println( Arrays.stream(new int[]{12,19,20,88,00,9}).max().getAsInt());

        //Write a program to print the count of each character in a String?
        String s = "string data to count each character";
      namesCount= Arrays.stream(s.split(""))
               .map(String::toLowerCase)
               .collect(Collectors.groupingBy(str->str,LinkedHashMap::new, Collectors.counting()));
        namesCount= Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(namesCount);

    }


    private static class Notes {
        private int id;
        private String tagName;
        private int tagId;

        public Notes(int id, String tagName, int tagId) {
            this.id = id;
            this.tagName = tagName;
            this.tagId = tagId;
        }

        public int getId() {
            return id;
        }

        public String getTagName() {
            return tagName;
        }

        public int getTagId() {
            return tagId;
        }
    }
}
