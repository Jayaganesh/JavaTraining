package chapter11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Annotation {
    public static void main(String[] args) {
//        Using Annotations

//        public class CacheTest {
//            @Test public void checkRandomInsertions()
//        }

//        @Bean

//        Annotation Elements
//        @Test(timeout=10000)


//        An annotation element is one of the following:

//        A primitive type value
//        A String
//        A Class object
//        An instance of an enum
//        An annotation
//        An array of the preceding (but not an array of arrays)

//        @BugReport(showStopper=true,
//                assignedTo="Harry",
//                testCase=CacheTest.class,
//                status=BugReport.Status.CONFIRMED)

//        @SuppressWarnings(value="unchecked") => @SuppressWarnings("unchecked")

//        @BugReport(reportedBy={"Harry", "Fred"})
//        @BugReport(reportedBy="Harry") // Same as {"Harry"}
//        @BugReport(ref=@Reference(id=11235811), ...)

//        Multiple and Repeated Annotations

//        @Test
//        @BugReport(showStopper=true, reportedBy="Joe")
//        public void checkRandomInsertions()

//        @BugReport(showStopper=true, reportedBy="Joe")
//        @BugReport(reportedBy={"Harry", "Carl"})
//        public void checkRandomInsertions()

//        Annotating Declarations

//        Classes (including enum) and interfaces (including annotation interfaces)
//        Methods
//        Constructors
//        Instance variables (including enum constants)
//        Local variables (including those declared in for and try-with-resources statements)
//        Parameter variables and catch clause parameters
//        Type parameters
//        Packages

//        @Entity public class User { ... }

//        @SuppressWarnings("unchecked") List<User> users = ...;
//        public User getUser(@Param("id") String userId)

//        public class Cache<@Immutable V> { ... }

//        /**
//         Package-level Javadoc
//         */
//        @GPL(version="3")
//        package com.horstmann.corejava;
//        import org.gnu.GPL;

//        Annotating Type Uses


//        public User getUser(@NonNull String userId)

//        Type use annotations can appear in the following places:
//
//        With generic type arguments: List<@NonNull String>, Comparator.<@NonNull String> reverseOrder().
//
//        In any position of an array: @NonNull String[][] words (words[i][j] is not null), String @NonNull [][] words (words is not null), String[] @NonNull [] words (words[i] is not null).
//
//        With superclasses and implemented interfaces: class Warning extends @Localized Message.
//
//        With constructor invocations: new @Localized String(...).
//
//        With nested types: Map.@Localized Entry.
//
//        With casts and instanceof checks: (@Localized String) text, if (text instanceof @Localized String). (The annotations are only for use by external tools. They have no effect on the behavior of a cast or an instanceof check.)
//
//        With exception specifications: public String read() throws @Localized IOException.
//
//        With wildcards and type bounds: List<@Localized ? extends Message>, List<? extends @Localized Message>.
//
//        With method and constructor references: @Localized Message::getText.

//        Making Receivers Explicit

//        public class Point {
//            public boolean equals(@ReadOnly Object other) { ... }
//        }

//        p.equals(q)

//        public class Point {
//            public boolean equals(@ReadOnly Point this, @ReadOnly Object other) { ... }
//        }

//        different hidden parameter is passed to the constructor of an inner class, namely the reference to the enclosing class object

//        static class Sequence {
//            private int from;
//            private int to;
//
//            class Iterator implements java.util.Iterator<Integer> {
//                private int current;
//
//                public Iterator(@ReadOnly Sequence Sequence.this) {
//                    this.current = Sequence.this.from;
//                }
//        ...
//            }
//    ...
//        }

//        Defining Annotations

//        @Target(ElementType.METHOD)
//        @Retention(RetentionPolicy.RUNTIME)
//        public @interface Test {
//            long timeout();
//        }
//
//
//        @Target({ElementType.TYPE, ElementType.METHOD})
//        public @interface BugReport

//        Element type	Annotation applies to
//        ======================================
//        ANNOTATION_TYPE	Annotation type declarations
//        PACKAGE	Packages
//        TYPE	Classes (including enum) and interfaces (including annotation types)
//        METHOD	Methods
//        CONSTRUCTOR	Constructors
//        FIELD	Instance variables (including enum constants)
//        PARAMETER	Method or constructor parameters
//        LOCAL_VARIABLE	Local variables
//        TYPE_PARAMETER	Type parameters
//        TYPE_USE	Uses of a type

//        default element value

//        public @interface Test {
//            long timeout() default 0L;
//    ...
//        }

//        public @interface BugReport {
//            String[] reportedBy() default {};
//            // Defaults to empty array
//            Reference ref() default @Reference(id=0);
//            // Default for an annotation
//    ...
//        }

//        The @Retention meta-annotation specifies where the annotation can be accessed. There are three choices.
//
//        RetentionPolicy.SOURCE:
//        The annotation is available to source processors, but it is not included in class files.
//
//        RetentionPolicy.CLASS:
//        The annotation is included in class files, but the virtual machine does not load them.
//        This is the default.
//
//        RetentionPolicy.RUNTIME:
//        The annotation is available at runtime and can be accessed through the reflection API.

//        Standard Annotations


//        Annotation            interface	        Applicable to	Purpose
//        =================================================================
//        Override	            Methods	            Checks that this method overrides a superclass method.
//        Serial	            Methods	            Checks that this method is a correct serialization method.
//        Deprecated	        All declarations	Marks item as deprecated.
//        SuppressWarnings	    All declarations except packages	Suppresses warnings of a given type.
//        SafeVarargs	        Methods and constructors	Asserts that the varargs parameter is safe to use.
//        FunctionalInterface	Interfaces	        Marks an interface as functional (with a single abstract method).
//        Generated	            All declarations	Marks an item as source code that has been generated by a tool.
//        Target	            Annotations	        Specifies the locations to which this annotation can be applied.
//        Retention	            Annotations	        Specifies where this annotation can be used.
//        Documented	        Annotations	        Specifies that this annotation should be included in the documentation of annotated items.
//        Inherited	            Annotations	        Specifies that this annotation is inherited by subclasses.
//        Repeatable	        Annotations	        Specifies that this annotation can be applied multiple times to the same item.
//


//        Annotations for Compilation
//        Meta-Annotations

//        Processing Annotations at Runtime

        @ToString(includeName=false)
        class Point {
            @ToString(includeName=false) private int x;
            @ToString(includeName=false) private int y;
        }

        @ToString
        class Rectangle {
            @ToString(includeName=false) private Point topLeft;
            @ToString private int width;
            @ToString private int height;
        }

        class ToStrings {
            public static String toString(Object obj) {
                if (obj == null) return "null";
                Class<?> cl = obj.getClass();
                ToString ts = cl.getAnnotation(ToString.class);
                if (ts == null) return obj.toString();
                var result = new StringBuilder();
                if (ts.includeName()) result.append(cl.getName());
                result.append("[");
                boolean first = true;
                for (Field f : cl.getDeclaredFields()) {
                    ts = f.getAnnotation(ToString.class);
                    if (ts != null) {
                        if (first) first = false; else result.append(",");
                        f.setAccessible(true);

                        if (ts.includeName()) {
                            result.append(f.getName());
                            result.append("=");
                        }
                        try {
                            result.append(ToStrings.toString(f.get(obj)));
                        } catch (ReflectiveOperationException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                result.append("]");
                return result.toString();
            }
        }

        System.out.println(new ToStrings().toString(new Rectangle()));


//        Source-Level Annotation Processing
//        Annotation Processors


//        javac -processor ProcessorClassName1,ProcessorClassName2,... sourceFiles


//        public class ToStringAnnotationProcessor extends AbstractProcessor {
//            @Override
//            public boolean process(Set<? extends TypeElement> annotations,
//                                   RoundEnvironment currentRound) {
//        ...
//            }
//        }



    }




}
