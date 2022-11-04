package chapter3;

public class DigitSequence implements IntSequence {

    private int number;

    public DigitSequence(int n) {
        number = n;
    }

    public boolean hasNext() {
        // This and the following method are declared in the interface
        return number != 0;
    }

    public int next() {
        int result = number % 10;
        number /= 10;
        return result;
    }

    public int rest() {
        // This method is not declared in the interface
        return number;
    }
}