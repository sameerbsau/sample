package java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();

        for(int i =0 ; i< 100;i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        parallelStream.filter(d -> d > 90).forEach( p -> System.out.println("parallel::"+ p));

        sequentialStream.filter(d -> d>90).forEach(s -> System.out.println("sequential::"+s));
    }
}