package Codewars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MexicanWave
{
    //https://www.codewars.com/kata/mexican-wave

    public static String[] wave(String str)
    {
        return IntStream.range(0, str.length()).filter(n -> str.charAt(n) != ' ')
                .mapToObj(n -> IntStream.range(0, str.length()).mapToObj(i -> i == n ?
                        Character.toUpperCase(str.charAt(i)) : str.charAt(i))
                        .map(Object::toString).collect(Collectors.joining()))
                .map(Object::toString).toArray(String[]::new);
    }

    private static String wave(String str, int n)
    {
        return IntStream.range(0, str.length()).mapToObj(i -> i == n ? Character.toUpperCase(str.charAt(i)) : str.charAt(i))
                .map(Object::toString).collect(Collectors.joining());
    }

}