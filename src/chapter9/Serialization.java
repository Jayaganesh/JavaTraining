package chapter9;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Serializable interface
        var emp = new Employee("jg", 23232.00);

        var out = new ObjectOutputStream(Files.newOutputStream(Path.of("ser.txt")));
        out.writeObject(emp);
        out.flush();
        out.close();

        var in = new ObjectInputStream(Files.newInputStream(Path.of("ser.txt")));


        var e1 = (Employee) in.readObject();
        var e2 = (Employee) in.readObject();


        in.close();
        System.out.println(e1);






    }
}
