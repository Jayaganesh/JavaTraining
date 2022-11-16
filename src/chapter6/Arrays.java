package chapter6;

import chapter2.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Arrays {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


//    ArrayList<PrintStream> is not subclass for ArrayList<AutoCloseable>
//    PrintStream is a subclass of AutoCloseable

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems)
            throws Exception {
        for (T elem : elems) elem.close();
    }

    //    PrintStream Array is a subclass of AutoCloseable Array

    public static void closeAll(AutoCloseable[] elems) throws Exception {
        for (AutoCloseable elem : elems) elem.close();
    }

    public static void printNames(ArrayList<? extends Employee> staff) { // unknown type is a subclass of EMployee
        for (int i = 0; i < staff.size(); i++) {
            Employee e = staff.get(i);
            System.out.println(e.getName());
        }
    }

    public static void printAll(Employee[] staff, Predicate<? super Employee> filter) {
        for (Employee e : staff)
            if (filter.test(e))
                System.out.println(e.getSal());
    }

}
