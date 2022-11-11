package chapter4;

import chapter2.Employee;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inheritance {
    public static void main(String[] args) throws ClassNotFoundException {
        //    *** Extending a Class ***

//        Super- and Subclasses
//        Manager and Employees
//        Defining and Inheriting Subclass Methods
//        Method Overriding
//        Subclass Construction

//        Superclass Assignments
        Manager boss = new Manager(12000.00);
        Employee empl = boss; // OK to assign to superclass variable

        double salary = empl.getSal();

//        Dynamic dispatch

        Employee[] staff = new Employee[3];
        staff[0] = new Employee(233.99);
        staff[1] = new Manager(1233.00); // OK to assign to superclass variable
//        staff[2] = new Janitor(...);
//        double sum = 0;
//        for (Employee empl1 : staff)
//            sum += empl1.getSal();

        // Ambiguity
//        Manager[] bosses = new Manager[10];
//        Employee[] empls = bosses; // Legal in Java
//        empls[0] = new Employee(123.00); // Runtime error

        //    Casts
        Employee empl2 = new Manager(1234.00);
//        empl2.setBonus(10000); // Compile-time error

        if (empl2 instanceof Manager mgr) {
            mgr.setBonus(10000);
        }

//        Anonymous Subclasses

        var names = new ArrayList<String>(100) {
            public void add(int index, String element) {
                super.add(index, element);
                System.out.println(element);
            }
        };

        names.add(0, "jay");
        names.add(1, "jay");
        System.out.println(names);

        var friends = new ArrayList<String>();
        friends.add("Harry");
        friends.add("Sally");
        invite(friends);

        invite(new ArrayList<String>() {
            {
                add("Harry"); add("Sally");
            }
        });

        // best
        invite(List.of("Harry", "Sally"));

//        Method Expressions with super
        class Worker {
            public void work() {
                for (int i = 0; i < 100; i++) System.out.println("Working");
            }
        }

        class ConcurrentWorker extends Worker {
            public void work() {

                var t = new Thread(super::work);
                t.start();
            }
        }

//        *** Inheritance Hierarchies ***

//        Final Methods and Classes

        class Employee {
            private String name;
            public final String getName() {
                return name;
            }
        }

//        public final class Executive extends Manager {
//    ...
//        }

//        Abstract Methods and Classes

        abstract class Person {
            private String name;
            protected double salary;

            public Person(String name) { this.name = name; }
            public final String getName() { return name; }

            public abstract int getId();
        }

        class Student extends Person {
            private int id;

            public Student(String name, int id) { super(name); this.id = id; }
            public int getId() { return id; }
        }

//        new Student("", 1);
//        new Person("");

//        Protected Access


//        Sealed Types

//        class Student1 {
//
//        }
//
//        sealed class Person1
//                permits Student1 {
//
//        }


//
//        }
//        subclass from superclass, subclass would create only in the same package
        // Person - this can be extended, only within the same package



//        Inheritance and Default Methods

//        public interface Named {
//            default String getName() { return ""; }
//        }
//
//        public class Person {
//    ...
//            public String getName() { return name; }
//        }
//
//        public class Student extends Person implements Named {
//    ...
//        }

//        A, B, C

//        class A extends B, C // not possible
//

        // possible B, C getName
//        class B extends C
//        class A extends B

        // class A => class A extends Object
//        class A extends B => class A extends B, Object

//        the superclass implementation always wins over the interface implementation.
//        There is no need for the subclass to resolve the conflict

//        *** Object: The Cosmic Superclass ***

//        public class Employee { ... } => public class Employee extends Object { ... }

//        String toString()
//        boolean equals(Object other)
//        int hashCode()
//        Class<?> getClass()
//        protected Object clone()
//        protected void finalize()
//        wait, notify, notifyAll

//        System.out.println(new Student("", 1));

//        The toString Method
//        public String toString() {
//            return getClass().getName() + "[name=" + name + ",salary=" + salary + "]";
//        }

//        public class Manager extends Employee {
//    ...
//            public String toString() {
//                return super.toString() + "[bonus=" + bonus + "]";
//            }
//        }
//
//        var pos = new Point(10, 20);
//        String message = "The current position is " + pos;
//        // Concatenates with pos.toString()

        int[] primes = { 2, 3, 5, 7, 11, 13 };
        System.out.println(primes.toString());
        System.out.println(Arrays.toString(primes));

//        The equals Method

        // var a = new Employee(1), var b = new Employee(1)
        // a == a
//
//        public class Item {
//            private String description;
//            private double price;
//    ...
//            public boolean equals(Object otherObject) {
//                // A quick test to see if the objects are identical
//                if (this == otherObject) return true;
//
//                // Must return false if the argument is null
//                if (otherObject == null) return false;
//                // Check that otherObject is an Item
//                if (getClass() != otherObject.getClass()) return false;
//                // Test whether the instance variables have identical values
//                var other = (Item) otherObject;
//                return Objects.equals(description, other.description)
//                        && price == other.price;
//            }
//
//            public int hashCode() { ... }
//        }

//        public class DiscountedItem extends Item {
//            private double discount;
//    ...
//            public boolean equals(Object otherObject) {
//                if (!super.equals(otherObject)) return false;
//                var other = (DiscountedItem) otherObject;
//                return discount == other.discount;
//            }
//
//            public int hashCode() { ... }
//        }

//        The hashCode Method

//        class Item {
//    ...
//            public int hashCode() {
//                return Objects.hash(description, price);
//            }
//        }

//        Cloning Objects
//
//        Employee cloneOfFred = fred.clone();
//        cloneOfFred.raiseSalary(10); // fred unchanged

//        *** Enumerations ***
        var price = new Pricing();
        price.price(123.00, Size.SMALL);

        enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE };

        Size notMySize = Size.valueOf("SMALL");

        Size[] allValues = Size.values();

        for (Size s : Size.values()) { System.out.println(s); }


        enum Planet {
            MERCURY, EARTH
        }

//        Constructors, Methods, and Fields

        enum Size1 {
            SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

            private String abbreviation;

            Size1(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getAbbreviation() { return abbreviation; }
        }

        System.out.println(Size1.SMALL.getAbbreviation());

//        Bodies of Instances

        enum Operation {
            ADD {
                public int eval(int arg1, int arg2) { return arg1 + arg2; }
            },
            SUBTRACT {
                public int eval(int arg1, int arg2) { return arg1 - arg2; }
            },
            MULTIPLY {
                public int eval(int arg1, int arg2) { return arg1 * arg2; }
            },
            DIVIDE {
                public int eval(int arg1, int arg2) { return arg1 / arg2; }
            };

            public abstract int eval(int arg1, int arg2);
        }

        System.out.println(Operation.ADD.eval(1, 2));

//        Static Members

        enum Modifier {
            PUBLIC, PRIVATE, PROTECTED, STATIC, FINAL, ABSTRACT;
            private static int maskBit = 1;
            private int mask;
            Modifier() {
//                mask = maskBit; // Error—cannot access static variable in constructor
//                maskBit *= 2;
            }

        }

//        public enum Modifier {
//            PUBLIC, PRIVATE, PROTECTED, STATIC, FINAL, ABSTRACT;
//            private int mask;
//
//            static {
//                int maskBit = 1;
//                for (Modifier m : Modifier.values()) {
//                    m.mask = maskBit;
//                    maskBit *= 2;
//                }
//            }
//    ...
//        }

//        Switching on an Enumeration

//        enum Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE };
//
//        public static int eval(Operation op, int arg1, int arg2) {
//            return switch (op) {
//                case ADD -> arg1 + arg2;
//                case SUBTRACT -> arg1 - arg2;
//                case MULTIPLY -> arg1 * arg2;
//                case DIVIDE -> arg1 / arg2;
//            }
//        }

//        Reflection

        System.out.println(price.getClass());

//        Class<?> cl = obj.getClass();

//        Class<?> cl = Class.forName(className);

//        Class Loaders

//        *** Reflection ***
//        Enumerating Class Members

//        Class<?> cl = Class.forName("Manager");
//        while (cl != null) {
//            for (Method m : cl.getDeclaredMethods()) {
//                System.out.println(
//                        Modifier.toString(m.getModifiers()) + " " +
//                                m.getReturnType().getCanonicalName() + " " +
//                                m.getName() +
//                                Arrays.toString(m.getParameters()));
//            }
//            cl = cl.getSuperclass();
//        }

//        Inspecting Objects

//        obj = ...;
//        for (Field f : obj.getClass().getDeclaredFields()) {
//            f.setAccessible(true);
//            Object value = f.get(obj);
//            System.out.println(f.getName() + ":" + value);
//        }

//        Invoking Methods
//        Constructing Objects

    }


    private static void invite(List<String> elems) {
        elems.forEach(System.out::println);
    }

}
