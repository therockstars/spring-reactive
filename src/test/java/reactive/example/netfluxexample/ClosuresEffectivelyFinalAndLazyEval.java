package reactive.example.netfluxexample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates that the variables inside the lambda need to be Effectively Final OR Final
 */
public class ClosuresEffectivelyFinalAndLazyEval {

    @Test
    public void lambdaExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int multiplier = 3;

        numbers.stream()
                .map(n -> n * multiplier)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())
                .forEach(x -> {
                    System.out.println(x);
                });

        // the below code will give an error at line 18 - because the variables inside lambda need to be <b>Effectively</b> Final

        // multiplier = 4;

    }
}