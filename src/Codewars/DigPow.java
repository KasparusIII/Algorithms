package Codewars;

import org.junit.Assert;
import org.junit.Test;

public class DigPow
{
    //https://www.codewars.com/kata/playing-with-digits

    public static long digPow(int n, int p)
    {
        int[] numbers = Integer.toString(n).chars().map(v -> v - '0').toArray();
        long pow_sum = 0;

        for (int i = 0; i < numbers.length; i++)
            pow_sum += Math.pow(numbers[i], (p+i));

        return pow_sum%n == 0 ? pow_sum/n : -1;
    }

    @Test
    public void digPowTest()
    {
        Assert.assertEquals(1, digPow(89, 1));
        Assert.assertEquals(-1, digPow(92, 1));
        Assert.assertEquals(51, digPow(46288, 3));
    }
}
