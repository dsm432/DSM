package streams.sample;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Filter
        System.out.println("// Filtered");
        List<Person> females = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.getGender()))
                .collect(Collectors.toList());

        females.forEach(System.out::println);

        // Sort
        System.out.println("// Sorted");
        people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getGender))
                .forEach(System.out::println);
        
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Houari", 24, Gender.MALE),
                new Person("Fatima", 50, Gender.FEMALE),
                new Person("Mohamed", 18, Gender.MALE),
                new Person("Aisha", 24, Gender.FEMALE)
        );
    }
}
