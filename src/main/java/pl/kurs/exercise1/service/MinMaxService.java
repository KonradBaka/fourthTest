package pl.kurs.exercise1.service;

import pl.kurs.exercise1.model.MinMax;

import java.util.List;

public class MinMaxService {

    public static <T extends Comparable> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            return null;
        }

        T min = elements.get(0);
        T max = elements.get(0);

        for (int i = 1; i < elements.size(); i++) {
            T current = elements.get(i);

            if (current.compareTo(min) < 0) {
                min = current;
            }

            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return new MinMax<>(min, max);

    }
}
