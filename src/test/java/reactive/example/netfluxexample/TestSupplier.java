package reactive.example.netfluxexample;

import reactive.example.netfluxexample.domain.Person;

import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {
        Supplier<Person> supplier = () -> {
            return new Person("Varun", 30, "Programmer");
        };

        Person p = supplier.get();
        String x = p.toString();
        System.out.println(x);
    }
}
