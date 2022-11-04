package chapter3;

public class SquareSequence implements IntSequence, Closeable {
    private int i;

    public boolean hasNext() {

        return true;
    }

    public int next() {
        i++;
        return i * i;
    }

    @Override
    public int time() {
        return IntSequence.super.time();
    }
}