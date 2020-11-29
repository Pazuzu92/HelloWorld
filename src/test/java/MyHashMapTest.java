import lesson02.task02.MyHashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {

    @Test
    void size() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", new Object());
        assertEquals(1, myHashMap.size());
        myHashMap.remove("1");
        assertEquals(0, myHashMap.size());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void containsKey() {
    }

    @Test
    void containsValue() {
    }

    @Test
    void get() {
    }

    @Test
    void put() {
    }

    @Test
    void remove() {
    }

    @Test
    void putAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void keySet() {
    }

    @Test
    void values() {
    }

    @Test
    void entrySet() {
    }
}