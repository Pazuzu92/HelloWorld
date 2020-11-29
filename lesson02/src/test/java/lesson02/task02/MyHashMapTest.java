package lesson02.task02;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

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
    void containsKey() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", new Object());
        assertEquals(true, myHashMap.containsKey("1"));
    }

    @Test
    void containsValue() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", 1);
        assertEquals(true, myHashMap.containsValue(1));
    }

    @Test
    void get() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", 2);
        assertEquals(2, myHashMap.get("1"));
    }

    @Test
    void put() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", 2);
        assertEquals(2, myHashMap.get("1"));
    }

    @Test
    void remove() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", 2);
        myHashMap.remove("1");
        assertEquals(false, myHashMap.containsKey("1"));
    }

    @Test
    void putAll() {
        MyHashMap myHashMap = new MyHashMap();
        Exception e = assertThrows(UnsupportedOperationException.class,
                () -> myHashMap.putAll(new HashMap()));

        //myHashMap.putAll(new HashMap());
        String expected = "is not realised";
        assertTrue(e.getMessage().contains(expected));
    }

    @Test
    void clear() {
    }
}