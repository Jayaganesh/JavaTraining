package chapter6;

import chapter2.Employee;
import chapter2.List;
import chapter4.Manager;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Generics {

    public static void main(String[] args) {
//        *** Generic Classes ***

//        Example - Entry Class
        Entry<String, Integer> entry = new Entry<>("Fred", 42);
        Entry<Integer, Double> entry12 = new Entry<>(42, 42.00);


        System.out.println(entry.getKey());
        System.out.println(entry.getValue());

//        *** Generic Methods ***

//        Example - Arrays Class

        String[] friends = {"jg1", "jg2", "jg3"};
        Arrays.swap(friends, 0, 1);
        System.out.println(java.util.Arrays.toString(friends));

//        supply the type explicitly
        Arrays.<String>swap(friends, 0, 1);

//        Type Bounds
//        Example - Arrays class, closeAll

        // {file1, file2, file3}

        try {
            Arrays.closeAll(new ArrayList<PrintStream>() {
                {
                    try (var out = new PrintStream("sample.txt")) {
                        System.out.println("");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            Arrays.closeAll(new PrintStream[]{new PrintStream("sample1.txt")});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        Multiple bounds

//        T extends Runnable & AutoCloseable

//        Type Variance and Wildcards

//        public static void process(Employee[] staff) { ... }
//        process(Manager[])


//        Pretend that it is legal to assign an ArrayList<Manager> to a variable of type ArrayList<Employee>

//        ArrayList<Manager> bosses = new ArrayList<>();
//        ArrayList<Employee> empls = bosses; // Not legal, but suppose it is...
//        empls.add(new Employee(23.33)); // A nonmanager in bosses!

        Manager[] bosses = { new Manager(123.00) };
        Employee[] empls = bosses;
//        empls[0] = new Employee(23.00);


//        Subtype Wildcards

//        Read operation never creates inconsistency

        ArrayList<Employee> employees = new ArrayList<>();
        try {
            employees.add(new Employee("jg", "jg", 1212.00));
            employees.add(new Manager(2323.00));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Arrays.printNames(employees);

        ArrayList<Manager> managers = new ArrayList<>();
        try {
            managers.add(new Manager("jg", "jg", 1212.00));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        Invariant, covariant, contravariant
        Arrays.printNames(managers);

//        Java can convert type <? extends Employee> to Employee
//        Java can't' convert type Employee to <? extends Employee>

//        Supertype Wildcards as lower bound

        Employee[] employees1 = {new Employee(222223.00)};
        Arrays.printAll(employees1, e -> e.getSal() > 100000);

        Predicate<Object> evenLength = e -> e.toString().length() % 2 == 0;
        Arrays.printAll(employees1, evenLength);

//        public static void printAll(Employee[] staff, Predicate<? super Employee> filter) {
//            for (Employee e : staff)
//                if (filter.test(e))
//                    System.out.println(e.getName());
//        }


//        Wildcards with Type Variables


//        public static <T> void printAll(T[] elements, Predicate<T> filter) {
//            for (T e : elements)
//                if (filter.test(e))
//                    System.out.println(e.toString());
//        }

//        public static <T> void printAll(T[] elements, Predicate<? super T> filter)

//        public boolean addAll(Collection<? extends E> c)
        Collection<Integer> ints = new LinkedList<>();
//        public boolean addAll(Collection<? extends Integer> c)

//        public static <T extends Comparable<? super T>> void sort(List<T> list)

//        Unbounded Wildcards

//        public static boolean hasNulls(ArrayList<?> elements) {
//            for (Object e : elements) {
//                if (e == null) return true;
//            }
//            return false;
//        }

//        Wildcard Capture


//        public static void swap(ArrayList<?> elements, int i, int j) {
//            ? temp = elements.get(i); // Won't work
//            elements.set(i, elements.get(j));
//            elements.set(j, temp);
//        }

//        public static void swap(ArrayList<?> elements, int i, int j) {
//            swapHelper(elements, i, j);
//        }
//
//        private static <T> void swapHelper(ArrayList<T> elements, int i, int j) {
//            T temp = elements.get(i);
//            elements.set(i, elements.get(j));
//            elements.set(j, temp);
//        }

//        *** Generics in the Java Virtual Machine ***

//        List li = new List();

//        List li1 = new List();
//        List li1 = new List();
//        List<Integer> li2 = li1;

//        Type Erasure

//        Cast Insertion

        Entry<String, Integer> entry1 = new Entry<>("", 1);
        String key = entry1.getKey();

//        String key = (String) entry.getKey();

//        Bridge Methods


//        public class WordList extends ArrayList<String> {
//            public boolean add(String e) {
//                return isBadWord(e) ? false : super.add(e);
//            }
//    ...
//        }


//        public class WordList extends ArrayList<String> {
//            public boolean add(String e) {
//                return isBadWord(e) ? false : super.add(e);
//            }
//    ...
//        }


//        public class WordList extends ArrayList<String> {
////            public boolean add(String e) {
////                return isBadWord(e) ? false : super.add(e);
////            }
////    ...
////        }


//        public boolean add(Object e) {
//            return add((String) e);
//        }

//        public class WordList extends ArrayList<String> {
//            public String get(int i) {
//                return super.get(i).toLowerCase();
//            }
//    ...
//        }

        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee(232.00));
        emps.add(new Manager(233.00));

    }

}
