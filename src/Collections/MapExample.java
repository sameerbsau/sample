package Collections;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        Map map = new Hashtable();
        List list = new LinkedList();
        Collections.synchronizedList(list);
        Collections.reverse(list);
        Collections.unmodifiableCollection(Collections.EMPTY_LIST);

        String input = "sameer is a java backed developer";

        Arrays.stream(input.split(" ")).collect(Collectors.groupingBy(String::length))
                .entrySet().stream().sorted((e1,e2)-> e2.getKey().compareTo(e1.getKey())).skip(1)
                .findFirst().map(Map.Entry::getValue).get().stream().sorted().findFirst().get();

    }
}