import java.util.*;

public class Sort1 implements Sortable{
    public void sortByAge(Person[] people) {

        List<Person> personList;
        personList = Arrays.asList(people);
        personList.sort((o1, o2) -> {
            Person.Sex x1 = o1.getSex();
            Person.Sex x2 = o2.getSex();
            int comp = x1.compareTo(x2);

            if (comp != 0) {
                return comp;
            }

            Integer x3 = o1.getAge();
            Integer x4 = o2.getAge();
            return x4.compareTo(x3);
        });

    }

    @Override
    public void sortByName(Person[] people) {
        List<Person> personList;
        personList = Arrays.asList(people);
        personList.sort((o1, o2) -> {
            Person.Sex x1 = o1.getSex();
            Person.Sex x2 = o2.getSex();
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
                return sComp;
            }

            String x3 = o1.getName();
            String x4 = o2.getName();
            return x3.compareTo(x4);
        });
    }
}
