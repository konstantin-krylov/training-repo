package tasks;

import simply_linked_list.MyArrayList;
import simply_linked_list.MyLists;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RowsCounter {
    public static void readingFromFile(String filename) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while ((str = reader.readLine()) != null) {
            if ((str.charAt(str.length()-1) == '-')) {
                str = str.substring(0, str.length() - 1);
                str += reader.readLine();
            }
            String[] result = str.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");

            for (int i = 0; i < result.length; i++) {
                Integer tempInt = result[i].length();
                if (!map.containsKey(tempInt)) {
                    map.put(tempInt, 1);
                } else {
                    map.put(tempInt, map.get(tempInt) + 1);
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println("Слово длинной " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
        }

    }

    public static void main(String[] args) throws IOException {
        String filename = "//Users/irina/git/training-repo/src/main/java/tasks/File.txt";

        RowsCounter.readingFromFile(filename);
    }
}
