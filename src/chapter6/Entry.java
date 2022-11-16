package chapter6;

public class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

//public class Entry {
//    private Object key;
//    private Object value;
//
//    public Entry(Object key, Object value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public Object getKey() { return key; }
//    public Object getValue() { return value; }
//}
//
//public class Entry<K extends Comparable<? super K> & Serializable,
//        V extends Serializable>