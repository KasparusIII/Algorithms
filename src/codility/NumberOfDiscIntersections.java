package codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NumberOfDiscIntersections
{
    //https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections

    public static int solution(int[] array)
    {    return array == null || array.length < 2 ? 0 : disc(array);    }

    private static int disc(int[] array)
    {
        long[]  scopes = new long[array.length + array.length];
        for (int i = 0; i < array.length; i++)
        {
            scopes[i] = ((long)i - array[i] << 31);
            scopes[i+ array.length] = ((long)i + array[i] << 31) + 1;
        }
        Arrays.sort(scopes);
        int sum = 0, begin = -1;
        for (long value : scopes)
            if ((value & 1) == 0)
            {
                begin++;
                sum += begin;
                if(sum > 10_000_000)
                    return -1;
            }
            else
                begin--;

        return sum;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(11, solution(new int[] {1, 5, 2, 1, 4, 0}));
        Assert.assertEquals(3, solution(new int[] {1, 0, 1}));
        Assert.assertEquals(0, solution(new int[] {0, 0, 0}));
    }
}