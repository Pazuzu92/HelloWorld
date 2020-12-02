public class Person implements Comparable<Person>{
    private int age;
    private String name;enum Sex {
        MAN, WOMAN
    }
    Sex sex;

    @Override
    public int compareTo(Person p) {
        if (p.getSex() == Sex.MAN) {
            return -1;
        } else return 1;
    }

    public Person(int age, String name, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person's " +
                "age =" + age +
                ", name ='" + name + '\'' +
                ", sex =" + sex;
    }
}
