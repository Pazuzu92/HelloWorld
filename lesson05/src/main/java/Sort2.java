import java.util.ArrayList;
import java.util.List;

public class Sort2 implements Sortable{
    @Override
    public void sortByAge(Person[] people) {

        for (int left = 0; left < people.length; left++) {

            Person person = people[left];
            int value = people[left].getAge();

            int i = left - 1;
            for (; i >= 0; i--) {

                if (value > people[i].getAge()) {
                    people[i + 1] = people[i];
                } else {
                    break;
                }
            }
            people[i + 1] = person;
        }
    }

    @Override
    public void sortByName(Person[] people) {

    }
}
