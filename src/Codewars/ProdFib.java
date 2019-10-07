package Codewars;

import org.junit.Assert;
import org.junit.Test;

public class ProdFib
{
    //https://www.codewars.com/kata/product-of-consecutive-fib-numbers

    public static long[] productFib(long prod)
    {
        long n1 = 0,
                n2 = 1;
        while(n1 * n2 < prod)
        {
            n2 = n1 + n2;
            n1 = n2 - n1;
        }
        return new long[] {n1, n2, n1 * n2 == prod ? 1 : 0};
    }

    @Test
    public void productFibTest()
    {
        Assert.assertArrayEquals(new long[] {55, 89, 1}, productFib(4895));
        Assert.assertArrayEquals(new long[] {89, 144, 0}, productFib(5895));
    }
}