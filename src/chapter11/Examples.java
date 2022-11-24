package chapter11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Examples {
    public static void main(String[] argv) throws ClassNotFoundException {

        Class<?> c = Class.forName("java.lang.String");
        Constructor<?>[] cons = c.getConstructors();
        printList("Constructors", cons);
        Method[] meths = c.getMethods();
        printList("Methods", meths);
    }
    static void printList(String s, Object[] o) {
        System.out.println("*** " + s + " ***");
        for (int i=0; i<o.length; i++)
            System.out.println(o[i].toString());
    }
}
