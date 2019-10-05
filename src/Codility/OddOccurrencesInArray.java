package Codility;

import org.junit.Assert;
import org.junit.Test;
import java.util.stream.IntStream;

public class OddOccurrencesInArray
{
    //https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array

    private static int solution(int[] array)
    {    return array == null ? 0 : IntStream.of(array).reduce(0, (r, i) -> r ^ i);    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(0, solution(new int[] {}));
        Assert.assertEquals(0, solution(null));
        Assert.assertEquals(7, solution(new int[] {9, 3, 9, 3, 9, 7, 9}));
    }
}