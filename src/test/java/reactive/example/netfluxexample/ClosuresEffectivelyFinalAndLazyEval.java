package reactive.example.netfluxexample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ClosuresEffectivelyFinalAndLazyEval {

    @Test
    public void lambdaExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        numbers.stream()
//                .map((number) -> number * 2)
//                .forEach(num -> System.out.println(num));
        int multiplier = 3;

        numbers.stream()
                .map(n -> n * multiplier)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())
                .forEach(x -> {
                    System.out.println(x);
                });
        
//        numbers.stream()
//                .forEach(x -> {System.out.println(x);});
    }
}