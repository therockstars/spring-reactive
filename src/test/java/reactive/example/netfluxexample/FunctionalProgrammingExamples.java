package reactive.example.netfluxexample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FunctionalProgrammingExamples {
    /**
     * There are 4 Properties of a Function
     * 1. Name
     * 2. Return type
     * 3. parameter list
     * 4. body
     */

    @Test
    public void functionWith4Things() throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" In thread t1");
            }
        });

        t1.start();
        System.out.println("In Main Test");
    }

    @Test
    public void lambdaExpression() throws Exception {
        Thread t1 = new Thread(() -> System.out.println("Silence of the lambdas!!"));
        // ^ Constructor is a higher order function
        t1.start();
        System.out.println("In Main Test !!");
    }

    @Test
    public void listInternalIterConsumer() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");
        System.out.println("=============== Before ================");
        dogs.forEach(s -> System.out.println(s));

        dogs.forEach(x->{
            x.length();
        });
        System.out.println("================ After ================");
        dogs.forEach(System.out::println);
    }

    @Test
    public void countDogsWith6Chars() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");
        int dogCount = 0;

        for (String dog : dogs) {
            if (dog.length() == 6) {
                dogCount++;  // dogCount is Mutating
            }
        }
        System.out.println("=============== Before ================");
        System.out.println(dogCount);

        // Immutable
        int cnt = dogs.stream()
                .filter(dog -> dog.length() == 6)
                .collect(Collectors.toList())
                .size();
        System.out.println("=============== After ================");
        System.out.println(cnt);

    }


}