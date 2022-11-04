package chapter3;

public interface Identified {
    default int getId() { return Math.abs(hashCode()); }
}