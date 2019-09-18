package Kata;

import java.util.stream.LongStream;

public class StepInPrimes
{
    //https://www.codewars.com/kata/steps-in-primes

    public static long[] step(int step, long start, long end)
    {
        long[] result = null;
        for (long i = start-1; i < end - step && result == null;)
        {
            i = nextPrime(i, end);
            if (isPrime(i + step))
                result = new long[] {i, i + step};
        }
        return result;
    }

    private static boolean isPrime(long number)
    {    return number > 1 && LongStream.range(2, (long)Math.sqrt(number)+1).allMatch(div -> number % div != 0);    }

    private static long nextPrime(long number, long limit)
    {
        number += (number % 2 == 0) ? 1 : 2;
        long prime = -1;
        while (prime == -1)
        {
            if (isPrime(number) || number > limit)
                prime = number;
            number += 2;
        }
        return prime;
    }
}