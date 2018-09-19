package tasks;

import simply_linked_list.MyArrayList;
import simply_linked_list.MyLists;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RowsCounter {
    public static void readingFromFile(String filename) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        StringBuilder sb = new StringBuilder();
        String str = reader.readLine();

        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(str);
        }
        String[] result = sb.toString().replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");

        MyLists list = new MyArrayList();
        for (int i = 0; i < result.length; i++) {
            list.addLast(result[i].length());
        }

//        MyCollections.sort(list,false);

        RowsCounter.print(list);
    }

    // как еще можно сделать этот метод, только не с помощью HashMap????
    public static void print(MyLists list) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < list.getSize(); i++) {
            Integer tempInt = list.getElement(i);
            if (!map.containsKey(tempInt)) {
                map.put(tempInt, 1);
            } else {
                map.put(tempInt, map.get(tempInt) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Слово длинной " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Konstantin\\git\\training-repo\\src\\main\\java\\simply_linked_list\\File.txt";

        RowsCounter.readingFromFile(filename);
    }
}
