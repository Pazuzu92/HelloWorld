import java.util.Random;

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
                person = new Person(age, generateName(), Person.Sex.WOMAN);
            } else {
                person = new Person(age, generateName(), Person.Sex.MAN);
            }

            persons[i] = person;
            //System.out.println(person);
        }
        for (int i = 0; i < persons.length-1; i++) {
            if(persons[i].getName().equals(persons[i+1].getName()) &&
                    persons[i].getAge()== persons[i+1].getAge()) {
                try {
                    throw new AlreadyExistsException("This person is already exists");
                } catch (AlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Sorted people");
        /*Sort1 sort1 = new Sort1();
        sort1.sort(persons);
        for (Person value : persons) {
            System.out.println(value);
        }*/
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
