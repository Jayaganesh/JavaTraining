package chapter3;

public interface IntSequence {
    boolean hasNext();

    int next();

    default int time() {
        cross();
        return 1;
    }

    private void cross() {
        System.out.println("sdksdkn");
        System.out.println("sdsd");
    }

}
