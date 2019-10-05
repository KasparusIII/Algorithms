package Codility;

import org.junit.Assert;
import org.junit.Test;
import java.util.stream.IntStream;

public class Distinct
{
    //https://app.codility.com/programmers/lessons/6-sorting/distinct

    public static int solution(int[] array)
    {    return array == null || array.length < 1 ? 0 : (int)IntStream.of(array).distinct().count();    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(1, solution(new int[] {4}));
        Assert.assertEquals(0, solution(new int[] {}));
        Assert.assertEquals(0, solution(null));
        Assert.assertEquals(2, solution(new int[] {4, 2}));
        Assert.assertEquals(3, solution(new int[] {2, 1, 1, 2, 3, 1 }));
    }
}