package chapter5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Exception {
    public static void main(String[] args) throws IOException {
//      ***  Exception Handling ***

//        Throwing Exceptions with randInt method

//        if (low > high)
//            throw new IllegalArgumentException(
//                    "low should be <= high but low is %d and high is %d".formatted(low, high));

//        The Exception Hierarchy

//                         Throwable
//                      ^             ^
//                     /               \
//                   Error           Exception
//                     ^                 ^
//                    /                /   \
//                   /           Runtime    \
//                  /            ^           \
//                 /            /             \
//              Subclass of Error     Subclass of Exception



        class FileFormatException extends IOException {
            public FileFormatException() {}
            public FileFormatException(String message) {
                super(message);
            }
        }

//        var file = new File();
//        try {
//            file.write("sdsds");
//        } catch (IOException e) {
//            logger.info("There is an error in method Read() {0}", e)
//            throw new RuntimeException(e);
//        }

//        Declaring Checked Exceptions

//        public void write(Object obj, String filename)
//        throws IOException, ReflectiveOperationException

//        throws can be super class as well

        // when override method
//        public void write(Object obj, String filename)
//        throws FileNotFoundException

//        Also, If the superclass method has no throws clause,
//        then no overriding method can throw a checked exception.

        // Java doc

//        @throws NullPointerException if filename is null
//        @throws FileNotFoundException if there is no file with name filename

//        Exception for lambda
//        list.forEach(obj -> write(obj, "output.dat"));

//        public interface Consumer<T> {
        // This method not having throws clause
//            void accept(T t);
//        }

//        Catching Exceptions

        // syntax

//        try {
//            statements
//        } catch (ExceptionClass ex) {
//            handler
//        }

//        try {
//            statements
//        } catch (ExceptionClass1 ex) {
//            handler1
//        } catch (ExceptionClass2 ex) {
//            handler2
//        } catch (ExceptionClass3 ex) {
//            handler3
//        }

//        try {
//            statements
//        } catch (ExceptionClass1 | ExceptionClass2 | ExceptionClass3 ex) {
//            handler
//        }

//        The Try-with-Resources Statement


        ArrayList<String> lines = new ArrayList<String>() {{add("jg");}};
        PrintWriter out = null;
        try {
            out = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            out.println(line.toLowerCase());
        }
        out.close();

        try (var out1 = new PrintWriter("output.txt")) { // Variable declaration
            for (String line : lines)
                out1.println(line.toLowerCase());
        }


        var out2 = new PrintWriter("output.txt");
        try (out2) { // Effectively final variable
            for (String line : lines)
                out2.println(line.toLowerCase());
        }

//        The AutoCloseable interface has a single method
//
//        public void close() throws Exception

        try (var in = new Scanner(Path.of("/usr/share/dict/words"));
             var out3 = new PrintWriter("output.txt")) {
            while (in.hasNext())
                out3.println(in.next().toLowerCase());
        }

//        The resources are closed in reverse order of their initialization—that is,
//        out3.close() is called before in.close().

//        The finally Clause

//        try {
//            Do work
//        } finally {
//            Clean up
//        }

//        Error scenario

//        public static int parseInt(String s) {
//            try {
//                return Integer.parseInt(s);
//            } finally {
//                return 0; // Error
//            }
//        }

        // try catch finally

//        BufferedReader in = null;
//        try {
//            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
//            Read from in
//        } catch (IOException ex) {
//            System.err.println("Caught IOException: " + ex.getMessage());
//        } finally {
//            if (in != null) {
//                in.close(); // Caution—might throw an exception
//            }
//        }

//        Rethrowing and Chaining Exceptions

//        try {
//            Do work
//        }
//        catch (Exception ex) {
//            logger.log(level, message, ex);
//            throw ex;
//        }

        // chaining exceptions

//        try {
//            Access the database
//        }
//        catch (SQLException ex) {
//            throw new ServletException("database error", ex);
//        }


        // getSuppressed();

//        try {
//            Access the database
//        }
//        catch (SQLException ex) {
//            var ex2 = new CruftyOldException("database error");
//            ex2.initCause(ex);
//            throw ex2;
//        }

//        Custom exception

//        public class FileFormatException extends IOException {
//    ...
//            public FileFormatException(Throwable cause) { initCause(cause); }
//            public FileFormatException(String message, Throwable cause) {
//                super(message);
//                initCause(cause);
//            }
//        }

//        Uncaught Exceptions and the Stack Trace
//
//        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
//            Record the exception
//        });

//        try {
//            Class<?> cl = Class.forName(className);
//    ...
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }

//        API Methods for Throwing Exceptions

//        Null check

//        public void process(String direction) {
//            this.direction = Objects.requireNonNull(direction);
//    ...
//        }

//        this.direction = Objects.requireNonNull(direction, "direction must not be null");


//        this.direction = Objects.requireNonNullElse(direction, "North");


//        this.direction = Objects.requireNonNullElseGet(direction,
//                () -> System.getProperty("com.horstmann.direction.default"));

//        index check API
//        this.index = Objects.checkIndex(index, length);

//        *** Assertions ***


//        Using Assertions

//        assert condition;
//        assert condition : expression;

//        assert x >= 0;
//        assert x >= 0 : x;

//        Enabling and Disabling Assertions

//        java -da MainClass

//        *** Logging ***

        // logging basics

        //        log.info("sdskjd");

//        debug, info, warning, error, critical

        randInt(30, 4);

    }




    public static int randInt(int low, int high) {
        if (low > high)
            throw new IllegalArgumentException(
                    "low should be <= high but low is %d and high is %d".formatted(low, high));
        return low + (int) (Math.random() * (high - low + 1));
    }
}
