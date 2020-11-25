package lesson02.catregister;

public class Dog extends Animal{

    private String kind;

    public Dog(int age, String name, String kind) {
        super(age, name);
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Dog " + this.getName() + " kind is " + kind;
    }
}
