package codewars.Tests;

import codewars.StepInPrimes;
import org.junit.Assert;
import org.junit.Test;

public class StepInPrimesTest
{
    @Test
    public void stepTest()
    {
        Assert.assertArrayEquals(new long[] {101, 103}, StepInPrimes.step(2,100,110));
        Assert.assertArrayEquals(new long[] {103, 107}, StepInPrimes.step(4,100,110));
        Assert.assertArrayEquals(new long[] {101, 107}, StepInPrimes.step(6,100,110));
        Assert.assertArrayEquals(new long[] {359, 367}, StepInPrimes.step(8,300,400));
        Assert.assertArrayEquals(new long[] {307, 317}, StepInPrimes.step(10,300,400));
        Assert.assertArrayEquals(new long[] {101, 103}, StepInPrimes.step(2,100,1_000_000_000));
    }

    @Test
    public void stepEmptyTest()
    {
        Assert.assertArrayEquals(null, StepInPrimes.step(1,100,1_000_000));
        Assert.assertArrayEquals(null, StepInPrimes.step(10,100,110));
        Assert.assertArrayEquals(null, StepInPrimes.step(1,100,0));
        Assert.assertArrayEquals(null, StepInPrimes.step(-1,100,0));
        Assert.assertArrayEquals(null, StepInPrimes.step(-1,-100,0));
    }
}