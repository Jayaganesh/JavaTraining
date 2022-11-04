package chapter3;

public interface Closeable {
    default int time(){
        return 1;
    }
}
