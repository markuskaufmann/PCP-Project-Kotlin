package ch.hslu.pcp.kotlin.ex.original;

import java.util.Arrays;
import java.util.List;

public final class Exercise4 {

    private String join(final Iterable<String> strings) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final String string : strings) {
            stringBuilder.append(string);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("Java", "is", "cool");
        System.out.println("Mit String.join: " + String.join(" ", strings));

        final Exercise4 ex04 = new Exercise4();
        System.out.println("Mit eigener Methode: " + ex04.join(strings));
    }
}
