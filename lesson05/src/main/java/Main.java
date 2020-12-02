import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Person person;
        Person[] persons = new Person[50];
        int age, randomSex;
        Random random = new Random();
        for (int i = 0; i < persons.length; i++) {
            age = random.nextInt(5);
            randomSex = random.nextInt(10);
            if (randomSex % 2 == 0) {
                person = new Person(age, generateName(), Person.Sex.WOMAN);
            } else {
                person = new Person(age, generateName(), Person.Sex.MAN);
            }

            persons[i] = person;
        }
        int count = 0;
        for (int i = 0; i < persons.length-1; i++) {
            for (int j = i + 1; j < persons.length; j++) {
                if(persons[i].getName().equals(persons[j].getName()) &&
                        persons[i].getAge()== persons[j].getAge()) {
                    count++;
                    try {

                        System.out.println(count + " " + persons[i] + " " + persons[j]);
                        throw new AlreadyExistsException("This person is already exists");

                    } catch (AlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }


        }
        CollectionSort collectionSort = new CollectionSort();
        long timeMillis = System.currentTimeMillis();
        collectionSort.sort(persons);
        System.out.println(System.currentTimeMillis() - timeMillis);

        InsertSort insertSort = new InsertSort();
        timeMillis = System.currentTimeMillis();
        insertSort.sort(persons);
        System.out.println(System.currentTimeMillis() - timeMillis);
        for (Person value : persons) {
            System.out.println(value);
        }
    }

    public static String generateName(){
        int letterA = 97;
        int letterZ = 122;
        int nameLength = 3;
        Random random = new Random();

        StringBuilder sb = new StringBuilder(nameLength);
        for (int i = 0; i < nameLength; i++) {
            int name = letterA + (int)(random.nextFloat() *(letterZ - letterA) + 1);
            sb.append((char)name);
        }
        return sb.toString();
    }
}
