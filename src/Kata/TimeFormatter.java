package Kata;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TimeFormatter
{
    private static final LinkedHashMap<Integer, String> time = new LinkedHashMap<>()
    {{
        put(31536000, "year"  );
        put(   86400, "day"   );
        put(    3600, "hour"  );
        put(      60, "minute");
        put(       1, "second");
    }};

    public static String formatDuration(int seconds)
    {
        String result = "now";
        if(seconds > 0)
        {
            result = formatDuration(seconds, time.entrySet().iterator());
            int i = result.lastIndexOf(",");
            if(i > 0)
                result = new StringBuilder(result).replace(i, i + 1, " and" ).toString();
        }
        return result;
    }

    private static String formatDuration(int seconds, Iterator<Map.Entry<Integer, String>> iterator)
    {
        Map.Entry<Integer, String> entry = iterator.next();
        int k = 0;
        if(seconds >= entry.getKey())
        {
            k = seconds/entry.getKey();
            seconds = seconds%entry.getKey();
        }
        return (k == 0) ? formatDuration(seconds, iterator) : k + " " + entry.getValue() + (k > 1 ? "s" : "") +
                (seconds > 0 ? ", " + formatDuration(seconds, iterator) : "");
    }
}