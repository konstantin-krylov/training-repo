package hash;


import java.util.List;

public class DemoHashMap<K, V> {

    private Node<K, V>[] hashTable;

    private int size;

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    private float threshold; // загруженность

    public DemoHashMap() {
        hashTable = new Node[DEFAULT_INITIAL_CAPACITY];
        threshold = hashTable.length * 0.75f;
    }

    public int getHash(final K key) { //функция получения индекса ячейки
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    public int getSize() {
        return size;
    }

    public boolean insert(K key, V value) {
        // если хэш таблица достигла своего максимума
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubly();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = getHash(key);

        // обычное добавление
        if (hashTable[index] == null) { // если в ячейке пусто
            return simpleAdd(newNode, index); // тогда просто вставляем значение в ячейку (в список)
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        // обработка коллизий и перезаписание значений
        for (Node<K, V> nodeFromList : nodeList) {
            if (isCollisium(nodeFromList, newNode, nodeList) ||
                    isKeyEquals(nodeFromList, newNode, value)) {
                return true;
            }
        }

        return false;
    }

    private boolean simpleAdd(Node<K, V> newNode, int index) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    public boolean isCollisium(Node<K, V> nodeFromList, Node<K, V> newNode, List<Node<K, V>> nodeList) {
        if (nodeFromList.hashCode() == newNode.hashCode() &&
                !nodeFromList.key.equals(newNode.key) &&
                !nodeFromList.value.equals(newNode.value)) {
            // Если под один и тот же хэш код устанавливаются разные объекты
            // добавляем в наш лист этот текущий объект
            nodeList.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    public boolean isKeyEquals(Node<K, V> nodeFromList, Node<K, V> newNode, V value) {
        if (nodeFromList.key.equals(newNode.key) &&
                !nodeFromList.value.equals(newNode.value)) {
            //если ключи текущего и нового нода одинаковые, а значения разные
            //меняем значение текущего нода на значение нового нода
            nodeFromList.value = value;
            return true;
        }
        return false;
    }

    private void arrayDoubly() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                // просматриваем список, содержащийся в ячейке
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    // написать метод delete...

}
