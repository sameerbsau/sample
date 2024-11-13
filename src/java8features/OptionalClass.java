package java8features;

import java.util.Optional;

//https://www.naukri.com/code360/library/what-is-optional-class-in-java-8
public class OptionalClass {

    public static void main(String[] args) {
        Optional<String> optionalString = Optional.empty();
        Optional<Integer> optionalInteger = Optional.of(10);
        Optional<Double> optionalDouble = Optional.ofNullable(null);

        String[] words = new String[5];
        words[0] = "Hello";
        words[1] = "Optional";
        words[2] = "Class";
        words[3] = "in";
        words[4] = "Java 8";

        Optional<String> optionalWord = Optional.ofNullable(words[2]);
        if (optionalWord.isPresent()) {
            String word = optionalWord.get();
            System.out.println("the word is::" + word);
        } else {
            System.out.println("word not found");
        }

        Optional<String> emptyOptional = Optional.ofNullable(words[5]);
        emptyOptional.ifPresent(word -> System.out.println("The word is::" + word));

        // some of the commonly used methods

        Optional<String> emptyOptional1 = Optional.empty();

        Optional<Integer> optionalInt = Optional.of(10);

        Optional<String> optionalString1  = Optional.ofNullable(null);

        Optional<Double> optionalDouble1 = Optional.of(3.14);
        boolean isPresent = optionalDouble1.isPresent();

        Optional<String> optionalString2 = Optional.of("hello");
        String value = optionalString2.get();

        optionalInt.ifPresent(word -> System.out.println(word));

        optionalString1.orElse("Default");

        optionalInt.orElseGet(()->0);
    }
}