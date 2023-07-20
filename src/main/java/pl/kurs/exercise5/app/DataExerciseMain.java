package pl.kurs.exercise5.app;

import pl.kurs.exercise2.exceptions.InvlaidPeselException;
import pl.kurs.exercise5.exceptions.InvalidBirthDateException;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class DataExerciseMain {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String formatPattern = "dd.MM.yyy";
        System.out.println("Podaj datę swoich urodzin w formacie: " + formatPattern);
        String userInput = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatPattern);
        LocalDate birth = LocalDate.parse(userInput, dtf);

        if (birth.isAfter(LocalDate.now())) {
            throw new InvalidBirthDateException("Dziś sie urodziłeś ?");
        }

        System.out.println("Wprowadzona data: " + birth);
        System.out.println("Żyjesz: " + getLifeDaysNumber(birth) + " dni");
        System.out.println("Żyjesz: " + getLifeMonthsNumber(birth) + " miesięcy");
        System.out.println("Żyjesz: " + getLifeYearsNumber(birth) + " lat");
        System.out.println("Urodziłeś się w dniu: " + getBirthdayDayOfTheWeek(birth));
        System.out.println("Najbliższy piątek 13-tego po twoich urodzinach wypada: " + getFirst13thFridayAfterBirthday(birth));
        scanner.close();


    }

    public static long getLifeDaysNumber(LocalDate birth) {
        return Duration.between(birth.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
    }

    public static long getLifeMonthsNumber(LocalDate birth) { // pewnie oczekiwałeś użycia Duration lub czegoś
        // bardzie podstawowego ale przeczytałem na necie o ChronoUnit i jest to klasa zbyt przyjemna w obsłudze żeby
        // jej nie użyć :)
        return ChronoUnit.MONTHS.between(birth, LocalDate.now());
    }

    public static long getLifeYearsNumber(LocalDate birth) {
        return ChronoUnit.YEARS.between(birth, LocalDate.now());
    }

    public static DayOfWeek getBirthdayDayOfTheWeek(LocalDate birth) {
        DayOfWeek dayOfWeek = birth.getDayOfWeek();
        return dayOfWeek;
    }

    public static LocalDate getFirst13thFridayAfterBirthday(LocalDate birth) {
        LocalDate date = birth.plusDays(1);

        while (true) {
            if (date.getDayOfMonth() == 13 && date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                return date;
            }
            date = date.plusDays(1);
        }
    }
}