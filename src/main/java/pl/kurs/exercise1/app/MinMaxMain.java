package pl.kurs.exercise1.app;

import pl.kurs.exercise1.service.MinMaxService;

import java.util.ArrayList;
import java.util.List;

public class MinMaxMain {
    public static void main(String[] args) {


        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);

        List<String> stringsList = new ArrayList<>();

        stringsList.add("Tomasz");
        stringsList.add("Bartosz");
        stringsList.add("Mateusz");
        stringsList.add("Konrad");
        stringsList.add("Paweł");
        stringsList.add("Adam");

        System.out.println(MinMaxService.getMinAndMax(integerList));
        System.out.println(MinMaxService.getMinAndMax(stringsList));

    }
}
