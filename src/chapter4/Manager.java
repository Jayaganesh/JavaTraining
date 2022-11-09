package chapter4;

import chapter2.Employee;

public class Manager extends Employee {
    private double bonus;

    public Manager(Double sal) {
        super(sal);
    }

    public Manager(String firstName, String lastName, Double sal) throws Exception {
        super(firstName, lastName, sal);
    }

    public Manager(String firstName, String lastName, Double sal, Double sal1, Double bonus) throws Exception {
        super(firstName, lastName, sal, sal1, bonus);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Double getSal() { // Overrides superclass method
        return super.getSal() + bonus;
    }
}
