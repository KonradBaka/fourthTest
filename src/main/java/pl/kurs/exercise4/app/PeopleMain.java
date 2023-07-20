package pl.kurs.exercise4.app;

import pl.kurs.exercise4.model.Person;
import pl.kurs.exercise4.service.PeopleService;

import java.util.ArrayList;
import java.util.List;

public class PeopleMain {
    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();

        peopleList.add(new Person("Tomasz", "Krawczyk", "Kraków", 27));
        peopleList.add(new Person("Adam", "Nowak", "Warszawa", 35));
        peopleList.add(new Person("Anna", "Kowalska", "Gdańsk", 40));
        peopleList.add(new Person("Jan", "Kowalski", "Poznań", 22));
        peopleList.add(new Person("Krystyna", "Nowakowska", "Wrocław", 50));
        peopleList.add(new Person("Kacper", "Dudek", "Kraków", 30));
        peopleList.add(new Person("Barbara", "Mazur", "Warszawa", 29));
        peopleList.add(new Person("Kowalska", "Gdańsk", "Rybnik", 77));
        peopleList.add(new Person("Ryszard", "Dudek", "Częstochowa", 29));
        peopleList.add(new Person("Oliwia", "Kaczmarek", "Gdynia", 19));
        peopleList.add(new Person("Karol", "Zawadzki", "Kraków", 39));
        peopleList.add(new Person("Eliza", "Woźniak", "Warszawa", 25));
        peopleList.add(new Person("Michał", "Szymański", "Poznań", 31));
        peopleList.add(new Person("Natalia", "Kowalczyk", "Gdańsk", 23));

        System.out.println("Najstarasza kobieta: " + PeopleService.getOldestWoman(peopleList));
        System.out.println("Średni wiek wszystkich osób: " + PeopleService.getAverageAgeFromList(peopleList));
        System.out.println("Średni wiek mężczyzn: " + PeopleService.getAverageManAge(peopleList));
        System.out.println("Średni wiek kobiet: " + PeopleService.getAverageWomanAge(peopleList));
        System.out.println("Średni wiek według płci: " + PeopleService.getAverageAgeFromGender(peopleList, person -> person.getFirstName().endsWith("a")));
        System.out.println("Najludniejsze miasto: "+ PeopleService.getMostPopulousCity(peopleList));
        System.out.println("Miasta z listy: " + PeopleService.getAllCitiesFromList(peopleList));

    }
}
