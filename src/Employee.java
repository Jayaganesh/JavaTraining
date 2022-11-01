import java.util.Random;

public class Employee {
    public static int count=12;
    private String firstName, lastName;
    private final Double sal;
    private Double bonus;
    private int id;

    { // Initialization block
        System.out.println("Initialization block");
        var generator = new Random();
        id = generator.nextInt(1_000_000);
        // n = n + seed + some alg
    }
    public Employee(Double sal) {
        this.sal = sal;
        System.out.println("Constructor");
    }

    public Employee(String firstName, String lastName, Double sal) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        if (sal <= 0) {
            throw new Exception("sal should be greater than 0");
        }
        this.sal = sal;

    }
    public Employee(String firstName, String lastName, Double sal, Double sal1, Double bonus) throws Exception {
        this(firstName, lastName, sal);
        this.bonus = bonus;

    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public Double getSal() {
        if (this.sal < 0) {
            return 0.0;
        }
//        this.sal = this.sal + 1.2;
        return this.sal;
    }

    public Double getBonus() {
        return this.bonus;
    }
}
