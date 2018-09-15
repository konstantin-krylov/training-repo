package simply_linked_list;

public class MyCollections {

    public static void sort(MyLists list, boolean growing) {
        for (int i = list.getSize() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (growing) {
                    if (list.getElement(j) > list.getElement(j + 1)) {
                        int tmp = list.getElement(j);
                        list.setElement(j, list.getElement(j + 1)); // меняем элемент по индексу j на элемент по индексу j+1
                        list.setElement(j + 1, tmp);
                    }
                } else {
                    if (list.getElement(j) < list.getElement(j + 1)) {
                        int tmp = list.getElement(j);
                        list.setElement(j, list.getElement(j + 1));
                        list.setElement(j + 1, tmp);
                    }
                }
            }
        }
    }
}
