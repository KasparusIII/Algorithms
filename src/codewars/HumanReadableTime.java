package codewars;

import java.util.stream.IntStream;

public class HumanReadableTime
{
    //https://www.codewars.com/kata/human-readable-time

    public static String makeReadable(int seconds)
    {
        return String.format("%s:%s:%s", IntStream.of(seconds/3600, seconds%3600/60, seconds%60)
                .mapToObj(t -> t < 10 ? "0"+t : ""+t).toArray());
    }
}
