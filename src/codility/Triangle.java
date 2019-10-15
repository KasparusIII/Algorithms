package codility;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class Triangle
{
    //https://app.codility.com/programmers/lessons/6-sorting/triangle

    public int solution(int[] array)
    {    return array == null || array.length < 3 ? 0 : triangle(array);    }

    private int triangle(int[] array)
    {
        Arrays.sort(array);
        for (int i = 2; i < array.length; i++)
            if ((long)array[i - 2] + array[i - 1] > array[i])
                return 1;

        return 0;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(1, solution(new int[] {10, 2, 5, 1, 8, 20}));
        Assert.assertEquals(0, solution(new int[] {10, 50, 5, 1}));
        Assert.assertEquals(1, solution(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }
}
