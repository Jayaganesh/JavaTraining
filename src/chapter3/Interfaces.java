package chapter3;

import java.util.*;
import java.util.random.RandomGenerator;

public class Interfaces {

    //SO(Open for extension, and closed for modification) LID

//    Interfaces
//    Static, Default, and Private Methods
//    Examples of Interfaces
//    Lambda Expressions
//    Method and Constructor References
//    Processing Lambda Expressions
//    Lambda Expressions and Variable Scope
//    Higher-Order Functions
//    Local and Anonymous Classes

//    *** Interfaces ***
//    Using Interfaces

    // class
    Random random = new Random();
    int id = random.nextInt(1_000_000);

    //interface
    RandomGenerator generator = RandomGenerator.getDefault();
    int dieToss = 1 + generator.nextInt(6);
    double randomPercentage = 100 * generator.nextDouble();

//    Declaring an Interface

//    Interface for sequence

//    {1,2,3}
//    A sequence of integers supplied by a user
//
//    A sequence of random integers
//
//    The sequence of prime numbers
//
//    The sequence of elements in an integer array
//
//    The sequence of code points in a string
//
//    The sequence of digits in a number

    //    All sequence have 2 methods in common,
//    1. whether there is a next element
//    2. Get the next element
    public static double average(IntSequence seq, int n) {
        int count = 0;
        double sum = 0;
        while (seq.hasNext() && count < n) {
            count++;
            sum += seq.next();
        }
        return count == 0 ? 0 : sum / count;
    }


    public static void main(String[] args) {
        var squares = new SquareSequence();
        double avg = average(squares, 100);
        System.out.println(avg);
        var digits = new DigitSequence(100);
        while (digits.hasNext()) {
            System.out.println("*****" + digits.next());
        }
        avg = average(digits, 100);
        System.out.println(avg);

//  Converting to an Interface Type
        IntSequence sequence = new DigitSequence(123);
        double avg1 = average(sequence, 100);

//  Casts and the instanceof Operator
        DigitSequence digits1 = (DigitSequence) sequence;
        System.out.println(digits1.rest());

//        String digitString = (String) sequence;
// Cannot possibly work—IntSequence is not a supertype of String
//        SquareSequence squares1 = (SquareSequence) sequence;
// Could work, throws a class cast exception if not
//        System.out.println(squares1);

        if (sequence instanceof DigitSequence) {
            DigitSequence digits2 = (DigitSequence) sequence;
        }

        // The “Pattern-Matching” Form of instanceof
        if (sequence instanceof DigitSequence digits3) {
            // Here, you can use the digits variable
        }

        if (sequence instanceof DigitSequence digits4 && digits4.rest() >= 100) {

        }

//        if (sequence instanceof DigitSequence digits5 || digits5.rest() >= 100) {
//        }

        double rest = sequence instanceof DigitSequence digits6 ? digits6.rest() : 0;

//        Switch based pattern matching

        String description = switch (sequence) {
            case DigitSequence digits_ -> "A digit sequence with rest " + digits.rest();
            case SquareSequence squares_ -> "A square sequence";
            default -> "Some other sequence";
        };

        // Extending Interfaces
//        Implementing Multiple Interfaces
//        public class FileSequence implements IntSequence, Closeable {
//        }

        // Constants
//        public interface SwingConstants {
//            int NORTH = 1;
//            int NORTH_EAST = 2;
//            int EAST = 3;
//        }

//        *** Static, Default, and Private Methods ***
//        Static  Methods
//        IntSequence digits = IntSequence.digitsOf(1729);

//        public interface IntSequence {
//    ...
//            static IntSequence digitsOf(int n) {
//                return new DigitSequence(n);
//            }
//        }

//        Default Methods (can be overridden)

//        public interface IntSequence {
//            default boolean hasNext() { return true; }
//            // By default, sequences are infinite
//            int next();
//        }

//        Resolving Default Method Conflicts

//        Private Methods
//        private static IntSequence makeFiniteSequence(int... values) { ... }


//        *** Examples of Interfaces ***

//        The Comparable Interface

//        public interface Comparable<T> {
//            int compareTo(T other);
//        }

        var listOfEmployees = new ArrayList<Employee>();
        listOfEmployees.add(new Employee(12000.00));
        listOfEmployees.add(new Employee(8000.00));
        Collections.sort(listOfEmployees);
        System.out.println(listOfEmployees);

//        The Comparator Interface

        class LengthComparator implements Comparator<String> {
            public int compare(String first, String second) {
                return first.length() - second.length();
            }
        }

//        Comparator<String> comp = new LengthComparator();
//        if (comp.compare(names[i], names[j]) > 0) ...
//
        String[] names = {"Peter", "Paul", "Mary"};
        Arrays.sort(names, new LengthComparator());
        for (String name : names) {
            System.out.println(name);
        }

//        Runnable Interface

        class HelloTask implements Runnable {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Hello, World!");
                }
            }
        }

//        Runnable task = new HelloTask();
//        Thread thread = new Thread(task);
//        thread.start();

//        User Interface Callbacks

//        public interface ActionListener {
//            void actionPerformed(ActionEvent event);
//        }
//
//        class ClickAction implements ActionListener {
//            public void actionPerformed(ActionEvent event) {
//                System.out.println("Thanks for clicking!");
//            }
//        }
//
////        var button = new JButton("Click me!");
////        button.addActionListener(new ClickAction());
//
//        var button = new JButton("Click me!");
//        button.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

//        *** Lambda Expressions ***

//        (String first, String second) -> first.length() - second.length()

//        (String first, String second) -> {
//            int difference = first.length() < second.length();
//            if (difference < 0) return -1;
//            else if (difference > 0) return 1;
//            else return 0;
//        }

//        Runnable task = () -> { for (int i = 0; i < 1000; i++) doWork(); }

//        Comparator<String> comp
//                = (first, second) -> first.length() - second.length();
//        // Same as (String first, String second)
//
//        If a method has a single parameter with inferred type, you can even omit the parentheses

//        ActionListener listener = event ->
//                System.out.println("Thanks for clicking!");
//        // Instead of (event) -> or (ActionEvent event) ->

//        Functional Interfaces => An interface with single abstract method

        Arrays.sort(names,
                (first, second) -> first.length() - second.length());

        System.out.println(names);

//        *** Method and Constructor References ***

//        Method References


//        from
//        Arrays.sort(strings, (x, y) -> x.compareToIgnoreCase(y));

//        to
//        Arrays.sort(strings, String::compareToIgnoreCase);

//        list.forEach(x -> System.out.println(x)); => list.forEach(System.out::println);

//        There are three variations:
//
//        Class::instanceMethod
//        Class::staticMethod
//        object::instanceMethod

//        Constructor References
//        Stream<Employee> stream = names.stream().map(Employee::new);

//        Employee[] staff = stream.toArray(Employee[]::new);

//        *** Processing Lambda Expressions ***



    }



}
