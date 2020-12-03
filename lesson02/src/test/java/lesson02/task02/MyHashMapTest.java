package lesson02.task02;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void size() {
        MyHashMap<String, Object> myHashMap = new MyHashMap<>();
        myHashMap.put("1", new Object());
        assertEquals(1, myHashMap.size());
    }

    @Test
    void containsKey() {
        MyHashMap<String, Object> myHashMap = new MyHashMap<>();
        myHashMap.put("1", new Object());
        assertTrue(myHashMap.containsKey("1"));
    }

    @Test
    void containsValue() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("1", 1);
        assertTrue(myHashMap.containsValue(1));
    }

    @Test
    void get() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("1", 2);
        int i = myHashMap.get("1");
        assertEquals(2, i);
    }

    @Test
    void put() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("1", 2);
        assertEquals(2, myHashMap.get("1"));
    }

    @Test
    void remove() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("1", 2);
        myHashMap.remove("1");
        assertFalse(myHashMap.containsKey("1"));
    }

    @Test
    void putAll() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        Exception e = assertThrows(UnsupportedOperationException.class,
                () -> myHashMap.putAll(new HashMap<>()));

        String expected = "is not realised";
        assertTrue(e.getMessage().contains(expected));
    }

    @Test
    void clear() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        Exception e = assertThrows(UnsupportedOperationException.class,
                () -> myHashMap.putAll(new HashMap<>()));

        String expected = "is not realised";
        assertTrue(e.getMessage().contains(expected));
    }
}