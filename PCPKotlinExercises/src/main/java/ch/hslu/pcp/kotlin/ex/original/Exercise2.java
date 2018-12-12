package ch.hslu.pcp.kotlin.ex.original;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Exercise2 {

    private void generateSortAndPrintRandomInts(final int numberOfVals, final int maxValueExc) {
        final IntStream intStream = new Random().ints(0, maxValueExc);
        final List<Integer> sortedList = intStream
                .limit(numberOfVals)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        final StringJoiner stringJoiner = new StringJoiner(" > ", "reverse ordered list = { ", " }");
        sortedList.forEach(value -> stringJoiner.add(Integer.toString(value)));
        System.out.println(stringJoiner);
    }

    public static void main(String[] args) {
        final Exercise2 ex02 = new Exercise2();
        ex02.generateSortAndPrintRandomInts(7, 100);
    }
}
