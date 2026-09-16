package com.amigoscode._7_streams._3_minmax;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Exercise: Min and Max
 *
 * Learn how to find minimum and maximum elements in a stream
 * using min(), max(), and reduce(). These operations return Optional
 * since the stream might be empty.
 */
public class MinMax {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(45, 12, 89, 3, 67, 34, 91, 23, 56);
        List<String> words = List.of("Java", "Streams", "Hi", "Programming", "API", "Go");
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Diana", 22),
                new Person("Eve", 28)
        );
        List<Integer> emptyList = List.of();

        // TODO: 1 - Find the minimum value in 'numbers' using stream min()
        //           Use Comparator.naturalOrder() or Integer::compareTo
        //           Print the result
        Integer min = numbers.stream().min((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println(min);

        // TODO: 2 - Find the maximum value in 'numbers' using stream max()
        //           Print the result

        Integer max = numbers.stream().max((o1, o2) -> o1.compareTo(o2)).get();

        // TODO: 3 - Find the shortest string in 'words' by comparing string length
        //           Use Comparator.comparingInt(String::length)
        //           Print the result
        words.stream().min((o1, o2) -> o1.compareTo(o2)).ifPresent(System.out::println);


        // TODO: 4 - Find the youngest person from 'people'
        //           Use Comparator.comparingInt(Person::age)
        //           Print the person's name and age
        people.stream().min(Comparator.comparing(Person::age)).ifPresent(p -> System.out.println(p.name + " is " + p.age););


        // TODO: 5 - Find the maximum value in 'numbers' using reduce() instead of max()
        //           Use Integer::max as the binary operator
        //           Print the result

        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);




        // TODO: 6 - Handle the empty stream case: try to find min of 'emptyList'
        //           Use orElse() to provide a default value of -1
        //           Print the result

        numbers.stream()
                .min(Integer::compareTo)
                .orElse(-1);

    }
}
