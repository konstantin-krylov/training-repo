package simply_linked_list;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyCollections {

    public static void sort(MyLists list, boolean growing) {
        for (int i = list.getSize() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {

                if (growing && list.getElement(j) > list.getElement(j + 1) || !growing && list.getElement(j) < list.getElement(j + 1)) {
                    int tmp = list.getElement(j);
                    list.setElement(j, list.getElement(j + 1)); // меняем элемент по индексу j на элемент по индексу j+1
                    list.setElement(j + 1, tmp);
                }
            }
        }
    }

    public static int max(MyLists list) {
        int max = list.getElement(0);
        for (int i = 0; i < list.getSize(); i++) {
            if (max < list.getElement(i)) {
                max = list.getElement(i);
            }
        }
        return max;
    }

    public static int min(MyLists list) {
        int min = list.getElement(0);
        for (int i = 0; i < list.getSize(); i++) {
            if (min > list.getElement(i)) {
                min = list.getElement(i);
            }
        }
        return min;
    }

    public static int binarySearch(MyLists list, int key) {

        int left = 0;
        int right = list.getSize();
        int middle = 0;

        while (!(left >= right)) {
            middle = left + (right - left) / 2;

            if (list.getElement(middle) == key) {
                return middle;

            } else if (list.getElement(middle) > key) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return -1; // значение отсутствует!!
    }

    public static int[] readingFromFile() { // этот метод наверное нужно вынести из класса MyCollections
        File file = new File("C:\\Users\\Konstantin\\git\\training-repo\\src\\main\\java\\simply_linked_list\\File.txt");
        String str;
        String[] array = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((str = reader.readLine()) != null) {
                // считает только слова в первой строке. на следующую строку не опускается.
                // нужно будет еще убрать знаки припенания, что бы они не входили в подсчет длины слова
                array = str.split(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = array[i].length();
        }

        return nums;
    }

    public static void count(MyLists list) {


        // для подсчета одинаковых вхождений взял класс Map
        // ХЗ может можно проще
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < list.getSize(); i++) {
            Integer tempInt = list.getElement(i);

            if (!map.containsKey(tempInt)) {
                map.put(tempInt, 1);
            } else {
                map.put(tempInt, map.get(tempInt) + 1);
            }
        }

        //Вывод строки пока что такой. Подумаю, может можно поместить его в переменную, что бы потом сравнивать в тестах
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Слово длинной " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
        }
    }

}
