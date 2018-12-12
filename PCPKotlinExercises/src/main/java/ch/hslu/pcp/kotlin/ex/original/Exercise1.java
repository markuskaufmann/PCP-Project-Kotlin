package ch.hslu.pcp.kotlin.ex.original;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class Exercise1 {

    private Optional<String> reduceAndPrintStrings(final String[] namesArray) {
        final List<String> names = Arrays.asList(namesArray);
        final Optional<String> x = names.stream()
                .filter(s -> s.startsWith("T"))
                .map(String::toUpperCase)
                .reduce((s, t) -> s + " " + t);
        x.ifPresent(s -> System.out.println("[Debugoutput] x = " + s));
        return x;
    }

    private void printOptional(final Optional<String> optionalString, final String defaultValue) {
        System.out.println("value = " + optionalString.orElse(defaultValue));
    }

    public static void main(String[] args) {
        final String[] namesArray = {"Joe", "Tara", "Sue", "Tim"};
        final Exercise1 ex01 = new Exercise1();

        final Optional<String> reducedString = ex01.reduceAndPrintStrings(namesArray);
        ex01.printOptional(reducedString, "[Default]");

        final String[] otherArray = {"Joe", "Sue"};
        final Optional<String> otherReducedString = ex01.reduceAndPrintStrings(otherArray);
        ex01.printOptional(otherReducedString, "[Default]");
    }
}
