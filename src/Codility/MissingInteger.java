package Codility;

import org.junit.Assert;
import org.junit.Test;

public class MissingInteger
{
    //https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer

    private static int solution(int[] array)
    {    return array == null || array.length == 0 ? 1 : missingInteger(array);    }

    private static int missingInteger(int[] array)
    {
        int val, size = array.length;
        for(int i = size - 1; i > -1; i--)
            if (array[i] < 1 || array[i] > size)
            {
                size--;
                val = array[i];
                array[i] = array[size];
                array[size] = val;
            }

        for(int i = 0; i < size; i++)
            if((val = Math.abs(array[i]) - 1) < array.length && array[val] > 0)
                array[val] = -array[val];

        int i = 0;
        boolean nFound = true;
        while(nFound && i < size)
            if (array[i] < 1)
                i++;
            else
                nFound = false;
        return i + 1;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(5, solution(new int[] {1, 3, 6, 4, 1, 2}));
        Assert.assertEquals(4, solution(new int[] {1, 2, 3}));
        Assert.assertEquals(1, solution(new int[] {-1, -3}));

        Assert.assertEquals(4, solution(new int[] {2 ,3, 1, 5}));
        Assert.assertEquals(1, solution(new int[] {}));
        Assert.assertEquals(2, solution(new int[] {1}));
        Assert.assertEquals(1, solution(new int[] {2}));
        Assert.assertEquals(3, solution(new int[] {1 ,2}));
        Assert.assertEquals(5, solution(new int[] {1 ,3, 2, 4}));
        Assert.assertEquals(1, solution(null));
    }
}