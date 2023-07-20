package pl.kurs.exercise5.exceptions;

public class InvalidBirthDateException extends RuntimeException{
    public InvalidBirthDateException(String message) {
        super(message);
    }
}
