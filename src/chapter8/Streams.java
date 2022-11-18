package chapter8;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// what, how
public class Streams {
    public static void main(String[] args) {
//        From Iterating to Stream Operations

        List<String> words = List.of("jg1", "jg2");
        int count = 0;
        for (String w : words) {
            if (w.length() > 1) count++;
        }
        System.out.println(count);


        long count1 = words.stream()
                .filter(w -> w.length() > 1)
                .count();

        System.out.println(count1);

        long count2 = words.parallelStream()
                .filter(w -> w.length() > 1)
                .count();

        System.out.println(count2);


//        *** Stream Creation ***

        Stream<String> song = Stream.of("gently", "down", "the", "stream");

        Stream<String> echos = Stream.generate(() -> "Echo");

        echos.limit(10).forEach(System.out::println);

        Stream<Double> randoms = Stream.generate(Math::random);

        Stream<BigInteger> integers
                = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        var limit = new BigInteger("10000000");
        Stream<BigInteger> integers1
                = Stream.iterate(BigInteger.ZERO,
                n -> n.compareTo(limit) < 0,
                n -> n.add(BigInteger.ONE));

        Stream<String> greetings = "Hello\nGuten Tag\nBonjour".lines();

        greetings.forEach(System.out::println);

        Stream<String> words1 = Pattern.compile("\\PL+").splitAsStream("Hello\nGuten Tag\nBonjour");

        words1.forEach(System.out::println);

//        The filter, map, and flatMap Methods


        Stream<String> longWords = words.stream().filter(w -> w.length() > 12);

        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);

        Stream<String> firstLetters = words.stream().map(s -> s.substring(0, 1));

//        Extracting Substreams and Combining Streams


        Stream<String> combined = Stream.concat(Stream.of("Hello"), Stream.of("World"));

//        Other Stream Transformations

        Stream<String> uniqueWords
                = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        // Only one "merrily" is retained

        Stream<String> longestFirst
                = words.stream().sorted(Comparator.comparing(String::length).reversed());

        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();

//        Simple Reductions


//        String str = "sdsd";
//        str = null;
//        if (str != null) {
//            str.length();
//        }
//


        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
//        largest.get();
        System.out.println("largest: " + largest.orElse(""));


        Optional<String> startsWithQ
                = words.stream().filter(s -> s.startsWith("Q")).findFirst();

        Optional<String> startsWithQq
                = words.stream().parallel().filter(s -> s.startsWith("Q")).findAny();

        boolean aWordStartsWithQ
                = words.stream().parallel().anyMatch(s -> s.startsWith("Q"));

//        The Optional Type

//        Producing an Alternative

        Optional<String> optionalString = Optional.ofNullable(null);

        String result = optionalString.orElse("");
        // The wrapped string, or "" if none


        String result1 = optionalString.orElseGet(() -> System.getProperty("myapp.default"));
        // The function is only called when needed

//        String result2 = optionalString.orElseThrow(IllegalStateException::new);
        // Supply a method that yields an exception object


//        Consuming the Value If Present

//        Optional.ofNullable(Set.of("hello")).ifPresent(v -> v.add("world"));

        Optional.ofNullable(Set.of("hello")).ifPresentOrElse(
                v -> System.out.println("Found " + v),
                () -> System.out.println("No match"));

//        Pipelining Optional Values


//        Optional<String> optionalString =  Optional.ofNullable("hello");

        Optional<String> transformed = optionalString.map(String::toUpperCase);

        Optional<String> transformed1 = optionalString
                .filter(s -> s.length() >= 8)
                .map(String::toUpperCase);

//        Optional<String> result1 = optionalString.or(() -> // Supply an Optional
//                alternatives.stream().findFirst());

//        How Not to Work with Optional Values

//        Optional<T> optionalValue = ...;
//        optionalValue.get().someMethod()

//        if (optionalValue.isPresent()) optionalValue.get().someMethod();

//        Creating Optional Values

//        Optional.ofNullable()
//        Optional.of()
//        Optional.empty()

//        Composing Optional Value Functions with flatMap

        class Manager {
            private String name;

            public Manager(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        class Department {
            private Manager boss;

            public Optional<Manager> getBoss() {
                return Optional.ofNullable(boss);
            }

            public void setBoss(Manager boss) {
                this.boss = boss;
            }
        }

        Manager mrSlate = new Manager("Mr. Slate");

        Department d = new Department();
        d.setBoss(mrSlate);
        System.out.println("Boss: " + d.getBoss());


        Department d1 = new Department();
        System.out.println("Boss: " + d1.getBoss());

        System.out.println("Name: " +
                d.getBoss().orElse(new Manager("Unknown")).getName());
        System.out.println("Name: " +
                d1.getBoss().orElse(new Manager("Unknown")).getName());

        System.out.println("Name: " + d.getBoss().map(Manager::getName));
        System.out.println("Name: " + d1.getBoss().map(Manager::getName));

        class Company {
            private Department department;

            public Optional<Department> getDepartment() {
                return Optional.ofNullable(department);
            }

            public void setDepartment(Department department) {
                this.department = department;
            }
        }

        Company co = new Company();
        co.setDepartment(d);

        System.out.println("Company Dept: " + co.getDepartment());

        System.out.println("Company Dept Manager: " + co.getDepartment()
                .map(Department::getBoss));

        System.out.println(
                co.getDepartment()
                        .flatMap(Department::getBoss)
                        .map(Manager::getName));


        Optional<Company> company = Optional.of(co);

        System.out.println(
                company
                        .flatMap(Company::getDepartment)
                        .flatMap(Department::getBoss)
                        .map(Manager::getName)
        );


//        Collecting Results
        var stream = Stream.of("1", "2", "3");
        stream.forEach(System.out::println);
//
//        String[] result2 = stream.toArray(String[]::new);
//        Set<String> result3 = stream.collect(Collectors.toSet());
//        TreeSet<String> result4 = stream.collect(Collectors.toCollection(TreeSet::new));
//
//        String result5 = stream.collect(Collectors.joining());
//
//        String result6 = stream.collect(Collectors.joining(", "));
//
//        String result7 = stream.map(Object::toString).collect(Collectors.joining(", "));
//
//        IntSummaryStatistics summary = stream.collect(
//                Collectors.summarizingInt(String::length));
//        double averageWordLength = summary.getAverage();
//        double maxWordLength = summary.getMax();

//        Collecting into Maps

        class Person {
            private int id;
            private String name;

            Person(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int id() {
                return id;
            }

            public String name() {
                return name;
            }
        }

        var people = Stream.of(new Person(1, "1"), new Person(2, "2"));

//        Map<Integer, String> idToName = people.collect(
//                Collectors.toMap(Person::id, Person::name));
//
//        System.out.println("idToName: " + idToName);

        Map<Integer, Person> idToPerson = people.collect(
                Collectors.toMap(Person::id, Function.identity()));

        System.out.println("idToPerson: "+ idToPerson);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

//        Grouping and Partitioning
//        Map<String, List<Locale>> countryToLocales = locales.collect(
//                Collectors.groupingBy(Locale::getCountry));
//
//        List<Locale> swissLocales = countryToLocales.get("CH");
//
//        System.out.println(swissLocales);

        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
                Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        List<Locale> englishLocales = englishAndOtherLocales.get(true);

        System.out.println(englishLocales);


    }




}
