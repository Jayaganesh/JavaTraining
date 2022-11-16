package chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Collections {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        for (Integer i : arr) {
            System.out.println(i);
        }

        arr.stream().forEach(System.out::println);

//    *** An Overview of the Collections Framework ***

//    Collection Interface

//    The Methods of the Collection<E> Interface
//    https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html

//    Collections Utilty Class
//    Useful Methods of the Collections Class
//        java.util.Collections.sort();

//    https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html

//    *** Iterators ***

//    Iterable<T> superinterface of Collection Interface

//    Iterator<T> iterator() as part of Iterable<T>

        Collection<String> coll = Arrays.asList("jg1", "jg2");
        Iterator<String> iter = coll.iterator();
        while (iter.hasNext()) {
            String element = iter.next();
            System.out.println(element);
        }

        for (String element : coll) {
            System.out.println(element);
        }

//      remove method

        while (iter.hasNext()) {
            String element = iter.next();
//            if (Objects.equals(element, "jg1"))
//                iter.remove();
        }

//        coll.removeIf(e -> Objects.equals(e, "jg1"));

        var friends = new LinkedList<String>();
        ListIterator<String> iter1 = friends.listIterator();
        iter1.add("Fred"); // Fred |
        iter1.add("Wilma"); // Fred Wilma |
        System.out.println(iter1.previous());
//        System.out.println(iter1.previous());
        iter1.set("Barney");
//        System.out.println(iter1.next());

//        *** Sets ***


        var languages = new HashSet<String>();
        languages.add("java");
        languages.add("python");
        languages.add("c++");
        if (languages.contains("python".toLowerCase()))
            System.out.println("Please choose a different user name");


        var countries = new TreeSet<String>(); // Visits added countries in sorted order
        countries.add("jg2");
        countries.add("jg1");
//        System.out.println(countries);

//        The TreeSet class implements the SortedSet and NavigableSet interfaces

//        SortedSet<E> Methods

//        https://docs.oracle.com/javase/8/docs/api/java/util/SortedSet.html

//        *** Maps ***

        var counts = new HashMap<String, Integer>();
        counts.put("Alice", 1); // Adds the key/value pair to the map
        counts.put("Alice", 2); // Updates the value for the key

//        System.out.println(counts);

        int count = counts.get("Alice");
//        int count = counts.getOrDefault("Alice", 0);

        counts.merge("Alice", 1, Integer::sum);
        counts.merge("Bob", 1, Integer::sum);
//        System.out.println(counts);


//        Map<K, V> Methods
//        https://docs.oracle.com/javase/8/docs/api/java/util/Map.html


//        *** Other Collections ***

//        Properties

        var settings = new Properties();
        settings.put("width", "200");
        settings.put("title", "Hello, World!");
        try (OutputStream out = Files.newOutputStream(Path.of("config"))) {
            settings.store(out, "Program Properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream in = Files.newInputStream(Path.of("config"))) {
            settings.load(in);
//            System.out.println(settings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String title = settings.getProperty("title", "New Document");

//        Properties class implements Map<Object, Object> even though the values are always strings.
//        Therefore, don’t use the get method—it returns the value as an Object.


//        System.getProperties method yields a Properties object with system properties

//        System.out.println(System.getProperties());

//        Bit Sets


    }


}
