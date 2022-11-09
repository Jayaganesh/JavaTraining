package chapter4;

import chapter2.Employee;

public class Inheritance {
    public static void main(String[] args) {
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
        double sum = 0;
        for (Employee empl1 : staff)
            sum += empl1.getSal();

        // Ambiguity
        Manager[] bosses = new Manager[10];
        Employee[] empls = bosses; // Legal in Java
        empls[0] = new Employee(123.00); // Runtime error

        //    Casts
        Employee empl2 = new Manager(1234.00);
//        empl2.setBonus(10000); // Compile-time error

        if (empl2 instanceof Manager mgr) {
            mgr.setBonus(10000);
        }



    }


}
