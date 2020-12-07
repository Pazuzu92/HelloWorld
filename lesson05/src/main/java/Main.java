import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person person;
        Person[] persons = new Person[10000];
        int age, randomSex;

        Random random = new Random();
        for (int i = 0; i < persons.length; i++) {
            age = random.nextInt(101);
            randomSex = random.nextInt(10);
            if (randomSex % 2 == 0) {
                person = new Person(age, generateName(), Sex.WOMAN);
            } else {
                person = new Person(age, generateName(), Sex.MAN);
            }

            persons[i] = person;
        }

        Scanner scanner = new Scanner(System.in);
        String sortMethod = scanner.nextLine();
        long timeMillis = System.currentTimeMillis();
        if (sortMethod.equals("collection")) {
            CollectionSort collectionSort = new CollectionSort();
            collectionSort.sort(persons);
            System.out.println(System.currentTimeMillis() - timeMillis);
        } else if (sortMethod.equals("insert")) {
            InsertSort insertSort = new InsertSort();
            insertSort.sort(persons);
            System.out.println(System.currentTimeMillis() - timeMillis);
        }




        for (Person value : persons) {
            System.out.println(value);
        }
    }

    public static String generateName(){
        int letterA = 97;
        int letterZ = 122;
        int nameLength = 4;
        Random random = new Random();

        StringBuilder sb = new StringBuilder(nameLength);
        for (int i = 0; i < nameLength; i++) {
            int name = letterA + (int)(random.nextFloat() *(letterZ - letterA) + 1);
            sb.append((char)name);
        }
        return sb.toString();
    }
}
