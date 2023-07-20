package pl.kurs.exercise4.service;

import pl.kurs.exercise4.model.Person;
import pl.kurs.exercise4.exceptions.NoWomenException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PeopleService {

    public static Person getOldestWoman(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getFirstName().endsWith("a"))
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new NoWomenException("Nie znaleziono kobiety o wymaganych kryteriach"));
    }

    public static double getAverageAgeFromList(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static double getAverageManAge(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(person -> !person.getFirstName().endsWith("a"))
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static double getAverageWomanAge(List<Person> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getFirstName().endsWith("a"))
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static double getAverageAgeFromGender(List<Person> list, Predicate<Person> genderPredicate) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(genderPredicate)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0.0);
    }

    public static String getMostPopulousCity(List<Person> list) {
        Map<String, Long> cityMap = Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Person::getTown, Collectors.counting()));

        Optional<Map.Entry<String, Long>> mostPopularCity = cityMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return mostPopularCity.map(Map.Entry::getKey).orElse("Brak danych");
    }

    public static List<String> getAllCitiesFromList(List<Person> list) {
        List<String> townList = Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getTown)
                .distinct()
                .collect(Collectors.toList());

        return townList;
    }
}
