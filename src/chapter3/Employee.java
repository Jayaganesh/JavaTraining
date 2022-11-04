package chapter3;

public class Employee implements Person, Identified, Comparable<Employee> {
    private double salary;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }

    @Override
    public int getId() {
//        return super.getId();
        return Person.super.getId();
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }

}
