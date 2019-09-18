package Kata;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Keypad
{
    //https://www.codewars.com/kata/multi-tap-keypad-text-entry-on-an-old-mobile-phone

    private static final String[] keypad =
            {    "1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9", "*", " 0", "#"    };
    private static final Map<Character, Integer> chars = Arrays.stream(keypad)
            .flatMap(key -> IntStream.range(0, key.length()).mapToObj(i -> ""+key.charAt(i)+(i+1)))
            .collect(Collectors.toMap(k -> k.charAt(0), v -> v.charAt(1) - '0'));

    public static int presses(String phrase)
    {
        return phrase != null ? phrase.toUpperCase().chars().mapToObj(ch -> chars.get((char)ch)).filter(Objects::nonNull)
                .reduce(0, Integer::sum) : 0;
    }
}