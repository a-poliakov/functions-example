package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamExample {
    public static void main(String[] args) {
        User vasya = new User("Moscow", "Vasya", 20);
        User petya = new User("St.Petersburg", "Petya", 30);
        User nikolay = new User("Moscow", "Nikolay", 15);

        List<User> users = asList(vasya, petya, nikolay);

//        int count = 0;
//        for (User user : users) {
//            if ("Moscow".equals(user.getCity())) {
//                count++;
//            }
//        }
//        System.out.println(count);

//        int count = 0;
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User user = iterator.next();
//            if ("Moscow".equals(user.getCity())) {
//                count++;
//            }
//        }
//        System.out.println(count);

        long count = users.stream()
                .filter(user -> "Moscow".equals(user.getCity()))
                .count();
        System.out.println(count);

        // collect()
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        System.out.println(collected);

        // forEach()
        users.stream()
                .forEach(user -> System.out.println(user.getName()));

        // map()
        collected = Stream.of("a", "b", "c")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected);

        // filter()
        collected = Stream.of("a", "1abc", "abc1")
                .filter(string -> Character.isDigit(string.charAt(0)))
                .collect(Collectors.toList());
        System.out.println(collected);

        // flatMap()
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        System.out.println(together);

        // max and min
        User userWithMinAge = users.stream()
                .min(Comparator.comparing(user -> user.getAge()))
                .get();
        System.out.println(userWithMinAge.getName() + " " + userWithMinAge.getAge());

        // reduction
//        Object accumulator = initialValue;
//        for(Object element: collection) {
//            accumulator = combine(accumulator, element);
//        }

        Integer sum = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(sum);

        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int reduceSum = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2
                ), 3
        );
        System.out.println(reduceSum);
    }
}
