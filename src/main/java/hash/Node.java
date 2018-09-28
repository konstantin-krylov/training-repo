package hash;

import java.util.LinkedList;
import java.util.List;

public class Node<K, V> {
    V value;
    K key;
    int hash;
    private List<Node<K, V>> nodes; // лист с нодами, которые хранятся в ячейке массива

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        nodes = new LinkedList<>();
    }

    public List<Node<K, V>> getNodes() {
        return nodes;
    }
}

