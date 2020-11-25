package lesson02.catregister;

public class Animal {

    private int age;
    private String name;

    public Animal(int age, String name) {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
