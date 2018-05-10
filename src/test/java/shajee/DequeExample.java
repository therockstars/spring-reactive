package shajee;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque deque = new LinkedList();

        // We can add elements to the queue in various ways
        deque.add("1 (Tail)"); // add to tail
        deque.addFirst("2 (Head)");
        deque.addLast("3 (Tail)");
        deque.push("4 (Head)"); //add to head
        deque.offer("5 (Tail)");
        deque.offerFirst("6 (Head)");
        deque.offerLast("7 (Tail)");

        System.out.println(deque + "\n");

        // Iterate through the queue elements.
        System.out.println("Standard Iterator");
        Iterator iterator = deque.iterator();
        while (iterator.hasNext())
            System.out.println("\t" + iterator.next());


        // Reverse order iterator
        Iterator reverse = deque.descendingIterator();
        System.out.println("Reverse Iterator");
        while (reverse.hasNext())
            System.out.println("\t" + reverse.next());

        // Peek returns the head, without deleting
        // it from the deque
        System.out.println("Peek " + deque.peek());
        System.out.println("After peek: " + deque);

        // Pop returns the head, and removes it from
        // the deque
        System.out.println("Pop " + deque.pop());
        System.out.println("After pop: " + deque);

        // We can check if a specific element exists
        // in the deque
        System.out.println("Contains element 3: " +
                deque.contains("Element 3 (Tail)"));

        // We can remove the first / last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing " +
                "first and last: " + deque);

        String x=new String("a");
        String y = x;//new String("a");
        System.out.println("x.equals(y) ==> " + x.equals(y));
        System.out.println("What ? " + (x==y));

    }
}
