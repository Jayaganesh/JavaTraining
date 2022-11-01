public class Main {
    public void main(String[] args) throws Exception {
        Employee jay = new Employee("f", "l", 1200.00);
        jay.getSal();
        Employee lu = new Employee("", "", 1323.0);
        Test test = new Test(10);
        Test1 test1 = new Test1(10);
        System.out.println(Employee.count);
        System.out.println(Employee.count);


    }

    public class Test {
        private final int x;
        public Test(int x) {
            this.x = x;
        }
    }

    record Test1(int x) {};


}
