package hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class DemoHashMapTest {

    @Test
    public void insert() {
        DemoHashMap demo = new DemoHashMap();
        assertEquals(true, demo.insert("Krylov", "Konstantin"));
    }
}