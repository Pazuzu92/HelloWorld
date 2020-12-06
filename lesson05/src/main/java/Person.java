import java.util.Comparator;



public class Person implements Comparable<Person>{

    private final int age;
    private final String name;
    // поле должно быть приватным и финальным
    Sex sex;

    @Override
    public int compareTo(Person p) {
        return Comparator.comparing(Person::getSex).reversed()
                .thenComparing(Person::getAge).reversed()
                .thenComparing(Person::getName).reversed()
                .compare(this, p);

    }

    public Person(int age, String name, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person's " +
                "age =" + age +
                ", name ='" + name + '\'' +
                ", sex =" + sex;
    }
}
