package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaConcept {
    public static void main(String[] args) {
        //seperate even and odd number
        List<Integer> numbers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Map<Boolean, List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(result);
        Optional<List<Integer>> ans = result.entrySet().stream().filter(r -> r.getKey()).map(r -> r.getValue()).findFirst();
        System.out.println(ans.get());


        //remove duplicate elements from a list
        List<String> listOfString = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> result1 = listOfString.stream().distinct().collect(Collectors.toList());
        System.out.println(result1);

        //find the frequency of each character in the given input string
        String inputString = "Java Concept Of The Day";
        Map<String, Long> newans = Stream.of(inputString.toLowerCase().replace(" ", "").split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(newans);

        Map<Character, Long> asp = inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(asp);

        //find the frequesncy of each element in the list
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> newcs = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(newcs);

        //how do you sort the given list of decimals in the reverse order
        List<Double> decimals = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decimals.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //joining
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        System.out.println(listOfStrings.stream().collect(Collectors.joining(",", "[", "]")));

        //print multiples of 5
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println(listOfIntegers.stream().filter(i -> i % 5 == 0).collect(Collectors.toList()));

        //max and min of the numbers
        System.out.println(listOfIntegers.stream().max(Comparator.naturalOrder()).get());
        System.out.println(listOfIntegers.stream().min(Comparator.naturalOrder()).get());

        //merge two unsortted arrays
        int[] a = new int[]{4, 2, 7, 1};
        int[] b = new int[]{8, 3, 9, 5};
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().forEach(System.out::print);

        //merge two unsorted arrays to sorted array without duplicates
        int[] aa = new int[]{4, 2, 5, 1};
        int[] bb = new int[]{8, 1, 9, 5};
        IntStream.concat(Arrays.stream(aa), Arrays.stream(bb)).distinct().sorted().forEach(System.out::print);

        //get three max and three min from the given list
        List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println(listOfIntegers1.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));
        System.out.println(listOfIntegers1.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList()));

        //program to check if two strings are anagram or not
        String s1 = "RaceCar";
        String s2 = "CarRace";
        s1 = Stream.of(s1.toUpperCase().split("")).sorted().collect(Collectors.joining());
        System.out.println(s1);
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        System.out.println(s1.equals(s2));

        //find the sum of all digits in stream
        int i = 15623;
        int r = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).reduce(0, (f, g) -> f + g);
        System.out.println(r);
        System.out.println(Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt)));
        System.out.println(Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum());

        //fins the second largest numberin the list
        System.out.println(listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).collect(Collectors.toList()));
        System.out.println(listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        //sort strings based on the incerasing order of their length
        List<String> listOfStrings1 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        System.out.println(listOfStrings1.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()));


        //find sum and average of all numbers

        System.out.println(Arrays.stream(a).sum());
        System.out.println(Arrays.stream(a).average().getAsDouble());


        //How do you find common elements between two arrays
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);

        System.out.println(list1.stream().filter(x -> list2.contains(x)).collect(Collectors.toList()));

        //reverse each word in string using
        String str = "Java Concept Of The Day";
        System.out.println(Stream.of(str.split(" ")).map(x -> new StringBuffer(x).reverse()).collect(Collectors.joining(" ")));

        //find sum of first 10 natural numbers

        System.out.println(IntStream.range(1, 10).sum());

        //reverse and integer array
        int[] array = new int[]{5, 1, 7, 3, 9, 6};
        System.out.println(Arrays.toString(IntStream.rangeClosed(1, array.length).map(X -> array[array.length - X]).toArray()));

        //print first 10 even numbers
        IntStream.rangeClosed(1, 10).map(m -> m * 2).forEach(System.out::println);

        //find the most repeated element in an array
        List<String> listOfStrings2 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        System.out.println(listOfStrings2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

        //palindrom of string
        String str3 = "ROTATOR";
        System.out.println(IntStream.range(0, str3.length() / 2).noneMatch(f -> str3.charAt(f) != str3.charAt(str3.length() - f - 1)));

        //give the list of string find the numbers that start with number
        List<String> listOfStrings4 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfStrings4.stream().filter(x -> Character.isDigit(x.charAt(0))).forEach(System.out::println);

        //how to extract duplicate elements from arays
        List<Integer> listOfIntegers6 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> set = new HashSet<>();
        listOfIntegers6.stream().filter(x -> !set.add(x)).forEach(System.out::println);

        //print duplicate charchters in the string
        String inputString3 = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

        Set<String> uniqueChars = new HashSet<>();

        Set<String> duplicateChars = Arrays.stream(inputString3.split("")).filter(ch -> !uniqueChars.add(ch)).collect(Collectors.toSet());

        //find first repeated charcter in a string
        System.out.println(Stream.of(inputString3.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(f -> f.getValue() > 1).map(Map.Entry::getKey).findFirst().get());

        //find first non repeated character
        System.out.println(Stream.of(inputString3.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(f -> f.getValue() == 1).map(Map.Entry::getKey).findFirst().get());

        //fibonace series
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).map(f -> f[0]).forEach(x -> System.out.print(x + " "));

        //first 10 odd numbers
        Stream.iterate(new int[]{1, 3}, f -> new int[]{f[1], f[1] + 2}).limit(10).map(f -> f[0]).forEach(x -> System.out.print(x + " "));

        //get the last element of the array
        List<String> listOfStrings9 = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        System.out.println(listOfStrings9.stream().skip(listOfStrings9.size() - 1).findFirst().get());


        String failed = "Java developer";
//      failed.chars().allMatch(Character::isLetter);
        String rieroge = Arrays.stream(failed.split(" ")).collect(Collectors.joining());
        System.out.println(rieroge);


    }
}