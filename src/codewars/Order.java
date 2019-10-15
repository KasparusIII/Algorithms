package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Order
{
    //https://www.codewars.com/kata/your-order-please

    public static String order(String words)
    {
        String[] w = words.split(" ");
        int[] order = Arrays.stream(w).flatMapToInt(s -> s.chars().filter(ch -> ch > '0' && ch <= '9'))
                .map(i -> (i - '0')*10).toArray();
        return order.length == 0 ? "" : IntStream.range(0, order.length).map(i -> order[i]+i).sorted()
                .mapToObj(i -> w[i%10]).reduce("", (x, y) -> x + " " + y).trim();
    }
}