package hash;


import java.util.List;
import java.util.Objects;

public class DemoHashMap<K, V> {

    private Node<K, V>[] hashTable;

    private int size;

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    private float threshold;

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
            // нужно как то удвоить массив и перехэшировать данные в таблице
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = getHash(key);

        if (hashTable[index] == null) { // в ячейке пусто
            hashTable[index] = new Node<>(null, null); // создаем пустую ноду
            hashTable[index].getNodes().add(newNode); // вытаскиваем от туда список нодов и добавляем новую ноду
            size++;
            return true;
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes();

        for (Node<K, V> nodeFromList : nodeList) {

            if (isCollisium(nodeFromList, newNode, nodeList) ||
                    isKeyEquals(nodeFromList, newNode, value)) {
                return true;
            }
        }

        return false;
    }

    public boolean isCollisium(Node<K, V> nodeFromList, Node<K, V> newNode, List<Node<K, V>> nodeList) {
        if (nodeFromList.hashCode() == newNode.hashCode() &&
                !Objects.equals(nodeFromList.key, newNode.key) &&
                !Objects.equals(nodeFromList.value, newNode.value)) {
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

}
