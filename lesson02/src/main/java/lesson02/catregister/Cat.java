package lesson02.catregister;

public class Cat extends Animal{

    private String color;

    public Cat(int age, String name, String color) {
        super(age, name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat " + this.getName() + " color is " + color;
    }
}
