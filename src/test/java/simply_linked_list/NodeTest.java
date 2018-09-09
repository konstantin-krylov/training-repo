package simply_linked_list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class NodeTest {

    int[] array = {1, 2, 3, 4, 5, 6, 7};
    Node top = Node.putIntoList(array);

    @Test
    public void putIntoList() {
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null", Node.listToString(Node.putIntoList(array)));
    }

    @Test
    public void deleteElement() {
        Node.deleteElement(top, 3);
        String result = Node.listToString(top);
        assertEquals("1 -> 2 -> 3 -> 5 -> 6 -> 7 -> null", result);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getElement() {
        assertEquals(4, Node.getElement(top, 3));
        assertEquals(7, Node.getElement(top, 6));

        exception.expect(IndexOutOfBoundsException.class);
        Node.getElement(top, 17);
    }


    @Test
    public void addLast() {
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 45 -> null", Node.listToString(Node.addLast(top, 45)));
    }

    @Test
    public void addFirst() {
        assertEquals("45 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null", Node.listToString(Node.addFirst(top, 45)));
    }

    @Test
    public void addMiddle() {
        assertEquals("1 -> 2 -> 3 -> 67 -> 4 -> 5 -> 6 -> 7 -> null", Node.listToString(Node.addMiddle(top, 67, 3)));
        assertEquals("67 -> null", Node.listToString(Node.addMiddle(null, 67, 3)));

        exception.expect(IndexOutOfBoundsException.class);
        Node.addMiddle(top, 67, 12);
    }

    @Test
    public void reverse() {
        assertEquals("7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null", Node.listToString(Node.reverse(top)));
    }
}