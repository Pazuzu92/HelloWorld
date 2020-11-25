package lesson02.catregister;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    List<Animal> animals = new ArrayList<Animal>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public Animal findAnimalByName (String name) {

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(name)) {
                return animals.get(i);
            }
        }
        return null;
    }
}
