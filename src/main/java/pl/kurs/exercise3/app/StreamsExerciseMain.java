package pl.kurs.exercise3.app;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExerciseMain {
    public static void main(String[] args) {

        List<Integer> integerList1 = new ArrayList<>();

        integerList1.add(1);
        integerList1.add(15);
        integerList1.add(3);
        integerList1.add(6);
        integerList1.add(12);
        integerList1.add(25);
        integerList1.add(99);
        integerList1.add(2);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(null);

        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(1);
        integerList3.add(2);
        integerList3.add(3);

        System.out.println(getFiveMaxElementsFromList(integerList1));
        System.out.println(getFiveMaxElementsFromList(integerList2));
        System.out.println(getFiveMaxElementsFromList(integerList3));


    }

    public static List<Integer> getFiveMaxElementsFromList(List<Integer> integerList) {
        List<Integer> fileMaxNumbers = Optional.ofNullable(integerList)
                .filter(x -> x.size() >= 5)
                .orElseGet(Collections::emptyList)
                .stream()
                .sorted(Comparator.comparingInt(x -> -x))
                .limit(5)
                .collect(Collectors.toList());

        return fileMaxNumbers;
    }
}
