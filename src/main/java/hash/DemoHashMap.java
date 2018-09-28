package hash;


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
        if (size+1>= threshold) {
            threshold*=2;
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

        // !!!!Здесь должна быть проверка на совпадение ключей (перезапись значения)
        // и обработка коллизий.
        // Для этого:

        // вытаскиваем лист нодов из данной ячейки
        // пробегаем по нему
        // проверяем существует ли там такой же ключ как наш
        // ИЛИ существует коллизия (когда по одному хэшу добавляются разные объекты)

        return false;
    }

}
