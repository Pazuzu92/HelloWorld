package lesson02.catregister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int age, weight;
        String name, kind, color;
        String animalType;
        Registry registry = new Registry();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter AnimalType");
        animalType = bf.readLine();

        while (!animalType.equals("exit")) {
            System.out.println("Enter AnimalType");
            animalType = bf.readLine();
            System.out.println("Enter age: ");
            age = Integer.parseInt(bf.readLine());
            System.out.println("Enter name: ");
            name = bf.readLine();
            if (animalType.equals("Cat")) {

                System.out.println("Enter color: ");
                color = bf.readLine();
                Cat cat = new Cat(age, name, color);
                registry.addAnimal(cat);
            } else if (animalType.equals("Dog")) {

                System.out.println("Enter kind: ");
                kind = bf.readLine();
                Dog dog = new Dog(age, name, kind);
                registry.addAnimal(dog);
            } else if (animalType.equals("Elephant")) {

                System.out.println("Enter weight: ");
                weight = Integer.parseInt(bf.readLine());
                Elephant elephant = new Elephant(age, name, weight);
                registry.addAnimal(elephant);
            } else {
                System.out.println("Wrong Animal");
            }
        }
    }
}
