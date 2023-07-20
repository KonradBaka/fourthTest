package pl.kurs.exercise2;

import pl.kurs.exercise2.exceptions.InvlaidPeselException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class OptionalExerciseMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź imię");

        getNameLength(scanner.nextLine());

        System.out.println("Wprowadź pesel");

        LocalDate userDate = getDateFromPesel(scanner.nextLine());
        System.out.println(userDate);

        scanner.close();
    }

    public static void getNameLength(String name) {
        Optional.ofNullable(name).ifPresentOrElse(
                x -> System.out.println(x.length()),
                () -> System.out.println(0)
        );
    }

    public static LocalDate getDateFromPesel(String pesel) {
        pesel = Optional.ofNullable(pesel)
                .filter(x -> x.matches("\\d{11}"))
                .orElseThrow(() -> new InvlaidPeselException("Błedny pesel"));

        String yearString = pesel.substring(0, 2);
        String monthString = pesel.substring(2, 4);
        String dayString = pesel.substring(4, 6);

        return LocalDate.of(Integer.parseInt("19" + yearString), Integer.parseInt(monthString), Integer.parseInt(dayString));
    }


}
