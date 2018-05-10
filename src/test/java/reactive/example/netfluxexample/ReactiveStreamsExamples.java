package reactive.example.netfluxexample;

import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReactiveStreamsExamples {
    //List<String> dogs = Arrays.asList("ABC", "Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt", "ABC");
    Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

    @Test
    public void simpleStreamExample() {
        dogs.toStream()
                .forEach(d -> System.out.println(d));
    }

    @Test
    public void simpleStreamExample2() {
        dogs.subscribe(s -> System.out.println(s));
    }

    @Test
    public void simpleStreamExample3() {
        // the last item will be NULL - which is ON COMPLETION
        dogs.doOnEach(d -> System.out.println(d.get()))
                .subscribe();
    }

    @Test
    public void simpleStreamExampleWithSubscriber() {
        dogs.subscribe(
                (s) -> {
                    System.out.println(s);
                },
                null,
                () -> System.out.println("Woot... All Done !!"));
    }

    @Test
    public void simpleStreamExampleWithSubscriberConsumers() {
        // Subscriber lambda
        Consumer<String> consumer = x -> System.out.println(x);
        Consumer<Throwable> errorHandler = e -> System.out.println("Some Error Occured " + e.getMessage());
        Runnable allDone = () -> System.out.println("All done !!");

        // trigger the subscription
        dogs.subscribe(consumer, errorHandler, allDone);
    }

    @Test
    public void mapStreamExample() {
        // there is a NULL coming at the end - need to figure out how to stop this guy
        dogs.map(s -> s.length())
                .doOnEach(d -> System.out.println("On Each -> " + d.get()))
                //  .collect()
                .subscribe(s -> System.out.println("This is from Subscribe -> " + s), null, () -> System.out.println("On Complete !!"));
    }

    @Test
    public void filterStreamExample() {
        dogs.filter(s -> s.length() == 6)
                .subscribe(s -> System.out.println(s));
    }

    @Test
    public void filterAndLimitStreamExample() {
        dogs.filter(s -> s.length() == 6)
                .take(2) // limit elements to 2
                .subscribe(System.out::println);
    }

    @Test
    public void filterAndSortExample() {
        dogs.filter(s -> s.length() == 6)
                .sort()
                .subscribe(x -> System.out.println(x));
    }

    @Test
    public void filterAndSortStreamWithCollectorExample() {
        dogs.filter(s -> s.length() == 6)
                .take(3)
                .sort()
                .collect(Collectors.joining(",")) // converts to Mono<String>
                .subscribe(System.out::println);
    }

    @Test
    public void testFlatMap() {
        Flux<List<Integer>> listFlux = Flux.just(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        listFlux.flatMap(lists -> Flux.fromIterable(lists))
                .filter(x -> x % 2 == 0)
                //.flatMap(lists -> Flux.fromIterable(lists))
                .subscribe(System.out::println);
    }

    @Test
    public void testReduction() {
        Flux<List<Integer>> listFlux = Flux.just(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        dogs.reduce((a, b) -> a + " - " + b)
                .subscribe(System.out::println);
    }


}