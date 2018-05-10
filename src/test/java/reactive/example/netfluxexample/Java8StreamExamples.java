package reactive.example.netfluxexample;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Reactive programming using Java8 Streams
 */
public class Java8StreamExamples {

    List<String> dogs = Arrays.asList("ABC", "Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt", "ABC");

    @Test
    public void simpleStreamExample() {
        dogs.stream()
                .forEach(System.out::println);
    }

    @Test
    public void parallelStreamExample() {
        dogs.parallelStream()
                .forEach(System.out::println);
    }

    @Test
    public void mapStreamExample() {
        dogs.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

    @Test
    public void filterStreamExample() {
        dogs.stream()
                .filter(s -> s.length() == 6)
                .limit(3)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void filterAndSortStreamWithCollectorExample() {
        String dogString = dogs.stream()
                .filter(s -> s.length() == 6)
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println(dogString);
    }

    @Test
    public void filterAndSortStreamWithFunctionaComp() {
        String dogString = dogs.stream()
                .filter(s -> s.length() == 6)
                .limit(3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println(dogString);
    }

    @Test
    public void testStats() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        IntSummaryStatistics statistics = numbers.stream()
                .mapToInt(x -> x + x)
                .summaryStatistics();

        System.out.println(statistics.toString());
    }

    @Test
    public void testGetMax() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        OptionalInt max = numbers.stream()
                .mapToInt(x -> x)
                .max();
        System.out.println("Max = " + max.getAsInt());
    }

    @Test
    public void testCollector() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer collect = numbers.stream()
                .collect(Collectors.summingInt(value -> value * 2));

        System.out.println(collect);
    }

    @Test
    public void testGroupingBy() {
        Map<Integer, Set<String>> groupedMap = dogs.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));

        groupedMap.forEach((k, v) -> System.out.println("Key = " + k + " Value = " + v));
    }

    @Test
    public void testFlatMap() {
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        List<Integer> numbers = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        numbers.forEach(System.out::println);
    }

    @Test
    public void testReduction(){
        String reducedString = dogs.stream()
                .reduce((a, b) -> a + "-" + b)
                .get();
        
        System.out.println(reducedString);
    }
}