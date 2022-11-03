package chapter2;

public class Count {
    private int id;
    private static int countInstances;
    // stack (compile time) and heap (run time)
    // static variables as class variables
    // static constants
    // static initializers
    // static methods as class methods
    // static class
    static {
        countInstances = 0;
    }
    public Count(int id) {
        this.id = id;
        countInstances += 1;
    }

    public int getCountInstances() {
//        Test test1 = new Test(10);
//        Test test2 = new Test(20);
//        System.out.println(test1);
//        System.out.println(test2);
//        System.out.println(test1 == test2);
        Test test1 = new Count.Test(10);
        Test test2 = new Count.Test(20);
        TestInner testInner = new Count.TestInner(10);
        return test1.test;
    }

    public static class Test {
        public int test = 10;
        public Test(int test) {
            this.test = test;
        }

    }

    public class TestInner {
        public int test = 10;
        public TestInner(int test) {
            this.test = test;
        }

    }

}
