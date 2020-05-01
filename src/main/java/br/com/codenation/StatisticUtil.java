package br.com.codenation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.sort;

public class StatisticUtil {

    public static int average(int[] elements) {

        validateArray(elements);
        int somatorio = 0;
        for (int i = 0; i < elements.length; i++) {
            somatorio += elements[i];
        }
        return somatorio/elements.length;
    }

    public static int mode(int[] elements) {

        validateArray(elements);
        Map<Integer, Integer> elementsMap = new HashMap<Integer, Integer>();
        AtomicInteger moda = new AtomicInteger();

        for (Integer element : elements) {
            if (elementsMap.containsKey(element)) {
                elementsMap.put(element, elementsMap.get(element) + 1);
            } else
                elementsMap.put(element, 1);
        }
        int maxValueInMap=(Collections.max(elementsMap.values()));
        elementsMap.forEach((k, v) -> {
            if(v >= maxValueInMap){
                moda.set(k.intValue());
            }
        });

        return moda.get();
    }

    public static int median(int[] elements) {
        validateArray(elements);
        sort(elements);

        if (elements.length % 2 == 0) {
            return (((elements[(elements.length / 2) - 1]) + (elements[(elements.length / 2)])) / 2);
        } else {
            return (elements[(elements.length / 2)]);
        }

    }

    public static void validateArray(int[] elements){
        if(elements.length == 0){
            throw new IllegalArgumentException("O array não pode ser vazio!");
        }
    }
}
