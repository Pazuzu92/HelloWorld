package lesson02.task02;

import java.util.HashMap;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("Black", 1);
        myHashMap.put("Black", 3);
        myHashMap.put("Red", 5);
        myHashMap.put("yellow", 1);
        System.out.println(myHashMap.get("Black"));
        System.out.println(myHashMap.containsValue(1));
        System.out.println(myHashMap.containsKey("Red"));
        myHashMap.putAll(new MyHashMap());
        System.out.println(myHashMap.size);
        myHashMap.remove("Red");
        System.out.println(myHashMap.containsKey("Red"));
        System.out.println(myHashMap.containsKey("White"));
        System.out.println(myHashMap.size);

        HashMap<String, Integer> hashMap = new HashMap<>();

    }
}
