package lesson02.catregister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int weight;
        String name, kind, color, action = "start";
        Animal animal;
        Registry registry = new Registry();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (!action.equals("exit")) {
            System.out.println("Choose what you want do: cat - add Cat, dog - add Dog, elephant - add Elephant, " +
                    "search - search animal by name, exit - to quit");

            action = bf.readLine();

            switch (action) {
                case "cat":
                    System.out.println("Enter cat's name: ");
                    name = bf.readLine();
                    System.out.println("Enter color: ");
                    color = bf.readLine();
                    animal = new Cat(name, color);
                    registry.addAnimal(animal);
                    System.out.println("Cat was added");
                    break;
                case "dog":
                    System.out.println("Enter dog's name: ");
                    name = bf.readLine();
                    System.out.println("Enter kind: ");
                    kind = bf.readLine();
                    animal = new Dog(name, kind);
                    registry.addAnimal(animal);
                    System.out.println("Dog was added");
                    break;
                case "elephant":
                    System.out.println("Enter elephant's name: ");
                    name = bf.readLine();
                    System.out.println("Enter weight: ");
                    weight = Integer.parseInt(bf.readLine());
                    animal = new Elephant(name, weight);
                    registry.addAnimal(animal);
                    System.out.println("Elephant was added");
                    break;
                case "search":
                    System.out.println("Enter name: ");
                    name = bf.readLine();
                    System.out.println(registry.findAnimalByName(name));
                    break;
                default:
                    System.out.println("Wrong animal");
                    break;
            }

        }

    }
}
