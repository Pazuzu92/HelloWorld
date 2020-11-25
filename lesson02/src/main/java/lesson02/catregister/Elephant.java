package lesson02.catregister;

public class Elephant extends Animal{

    private int weight;

    public Elephant(int age, String name, int weight) {
        super(age, name);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Elephant " + this.getName() + " weight is " + weight;
    }
}
