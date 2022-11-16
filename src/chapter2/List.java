package chapter2;

public class List<I extends Number> {
    private Node head = null;

    public List() {

    }

    private static class Node {
        private int elem;
        private Node address;

        public Node(int elem) {
            this.elem = elem;
            this.address = null;
        }
    }

    public void addItem(int elem) {
        var node = new Node(elem);
        if (this.head == null) {
            this.head = node;
        }

    }

}
