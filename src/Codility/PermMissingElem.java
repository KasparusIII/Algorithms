package Codility;

import org.junit.Assert;
import org.junit.Test;

public class PermMissingElem
{
    //https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem

    private static int solution(int[] array)
    {    return array == null ? 1 : findMissingPositive(array);    }

    private static int findMissingPositive(int[] array)
    {
        for (int val : array)
            if ((val = Math.abs(val) - 1) < array.length)
                array[val] = -array[val];

        boolean nFound = true;
        int i = 0;
        while (nFound && i < array.length)
            if (array[i] > 0)
                nFound = false;
            else
                i++;
        return i + 1;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(4, solution(new int[] {2 ,3, 1, 5}));
        Assert.assertEquals(1, solution(new int[] {}));
        Assert.assertEquals(2, solution(new int[] {1}));
        Assert.assertEquals(1, solution(new int[] {2}));
        Assert.assertEquals(3, solution(new int[] {1 ,2}));
        Assert.assertEquals(5, solution(new int[] {1 ,3, 2, 4}));
        Assert.assertEquals(-1, solution(null));
    }
}