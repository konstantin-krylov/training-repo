package simply_linked_list;

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

}
