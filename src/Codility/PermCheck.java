package Codility;

import org.junit.Assert;
import org.junit.Test;

public class PermCheck
{
    //https://app.codility.com/programmers/lessons/4-counting_elements/perm_check

    private static int solution(int[] array)
    {    return array == null || array.length == 0 ? 0 : permCheck(array);    }

    private static int permCheck(int[] array)
    {
        for (int val : array)
            if ((val = Math.abs(val) - 1) < array.length)
                array[val] = -array[val];

        boolean nFound = true;
        int i = 0;
        while (nFound && i < array.length)
            if (array[i] < 1)
                i++;
            else
                nFound = false;

        return nFound ? 1 : 0;
    }

    private static int permCheckWithBreak(int[] array)
    {
        boolean nFound = true;
        for (int val : array)
            if ((val = Math.abs(val) - 1) < array.length && array[val] > 0)
                array[val] = -array[val];
            else
            {
                nFound = false;
                break;
            }

        int i = 0;
        while (nFound && i < array.length)
            if (array[i] < 1)
                i++;
            else
                nFound = false;

        return nFound ? 1 : 0;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(1, solution(new int[] {4, 1, 3, 2}));
        Assert.assertEquals(0, solution(new int[] {4, 1, 3}));
        Assert.assertEquals(0, solution(new int[] {}));
        Assert.assertEquals(0, solution(null));
    }
}