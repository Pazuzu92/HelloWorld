import java.util.*;

public class CollectionSort implements Sortable{
    public void sort(Person[] people) {

        List<Person> personList;
        personList = Arrays.asList(people);
        personList.sort(Comparator.reverseOrder());

    }
}
