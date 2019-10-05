package Codility;

import org.junit.Assert;
import org.junit.Test;

public class CyclicRotation
{
    //https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation

    private static int[] solution(int[] array, int schift)
    {
        int[] result = array == null ? null : array.clone();

        if(array != null && array.length > 0 && (schift = schift % array.length) > 0)
        {
            int i = 0, j = 0;
            while((i+schift) < result.length)
                result[i+schift] = array[i++];
            while (i < array.length)
                result[j++] = array[i++];
        }
        return result;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertArrayEquals(new int[]{6, 3, 8, 9, 7}, solution(new int[]{3, 8, 9, 7, 6}, 1));
        Assert.assertArrayEquals(new int[]{9, 7, 6, 3, 8}, solution(new int[]{3, 8, 9, 7, 6}, 3));
        Assert.assertArrayEquals(new int[]{0, 0, 0}, solution(new int[]{0, 0, 0}, 1));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, solution(new int[]{1, 2, 3, 4}, 4));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, solution(new int[]{1, 2, 3, 4}, 0));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, solution(new int[]{1, 2, 3, 4}, -1));
        Assert.assertArrayEquals(new int[]{}, solution(new int[]{}, 4));
        Assert.assertArrayEquals(null, solution(null, 4));
    }
}