import java.util.ArrayList;
import java.util.List;

public class InsertSort implements Sortable{
    @Override
    public void sort(Person[] people) {

        for (int left = 0; left < people.length; left++) {

            Person person = people[left];

            int i = left - 1;
            for (; i >= 0; i--) {

                if (person.compareTo(people[i]) > 0) {
                    people[i + 1] = people[i];
                } else {
                    break;
                }
            }
            people[i + 1] = person;
        }
    }

}
