import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException {

        Person person;
        Set<String> fieldsToCleanup = new HashSet<String>();
        fieldsToCleanup.add("name");
        fieldsToCleanup.add("age");

        Set<String> fieldsToOutput = new HashSet<String>();
        fieldsToOutput.add("sex");
        fieldsToOutput.add("countKids");

        person = new Person();
        person.setName("Larry"); person.setAge(25); person.setCountKids(2); person.setSex("male");

        cleanup(person, fieldsToCleanup, fieldsToOutput);
        System.out.println(person.getName());

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Henry", 25);
        map.put("Scadi", 28);
        map.put("Kevin", 11);
        map.put("RodgeR", 28);
        map.put("a", 11);
        map.put("b", 11);
        map.put("x", 11);
        map.put("v", 11);

        Set<String> mapFieldsToCleanup = new HashSet<String>();
        mapFieldsToCleanup.add("Kevin");
        mapFieldsToCleanup.add("Henry");
        mapFieldsToCleanup.add("a");


        Set<String> mapFieldsToOutput = new HashSet<String>();
        mapFieldsToOutput.add("Scadi");
        mapFieldsToOutput.add("RodgeR");


        cleanup(map, mapFieldsToCleanup, mapFieldsToOutput);
        System.out.println(map.get("Kevin"));

    }

    public static void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) throws NoSuchFieldException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName(object.getClass().getName());

        if (object instanceof Map) {
            cleanupMap(object, fieldsToCleanup, fieldsToOutput);

        } else {
            Field[] fields = clazz.getDeclaredFields();
            List<String> fieldList = new ArrayList<>();
            for (Field value : fields) {
                fieldList.add(value.getName());
            }
            if (fieldList.containsAll(fieldsToCleanup)) {
                for (String s : fieldList) {
                    if (fieldsToCleanup.contains(s)) {
                        Field field = clazz.getDeclaredField(s);

                        field.setAccessible(true);
                        if (field.getType() == String.class) {
                            field.set(object, null);
                        } else {
                            field.set(object, 0);
                        }
                    }
                }
            } else throw new IllegalArgumentException("fieldList doesn't contains all fields to cleanup");

            if (fieldList.containsAll(fieldsToOutput)) {
                for (String s : fieldList) {
                    if (fieldsToOutput.contains(s)) {
                        Field field = clazz.getDeclaredField(s);
                        field.setAccessible(true);
                        System.out.println(field.get(object));
                    }
                }
            } else throw new IllegalArgumentException("fieldList doesn't contains all fields to output");

        }

    }

    public static void cleanupMap(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        Set<?> keySet = ((Map<?, ?>) object).keySet();
        Object[] fieldsToCleanupAr = fieldsToCleanup.toArray();
        Object[] fieldsToOutputAr = fieldsToOutput.toArray();

        if (keySet.containsAll(fieldsToCleanup)) {
            for (int i = 0; i < fieldsToCleanup.size(); i++) {
                keySet.remove(fieldsToCleanupAr[i]);
            }
        } else throw new IllegalArgumentException("keySet doesn't contains all fields to cleanup");

        if (keySet.containsAll(fieldsToOutput)) {
            for (int i = 0; i < fieldsToOutput.size(); i++) {
                System.out.println(((Map<?, ?>) object).get(fieldsToOutputAr[i]));
            }
        } else throw new IllegalArgumentException("keySet doesn't contains all fields to output");
    }
}
