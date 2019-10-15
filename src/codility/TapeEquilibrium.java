package codility;

import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibrium
{
    //https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium
    private static int solution(int[] array)
    {
        int result = Integer.MAX_VALUE,
            lSum = 0,
            rSum = 0,
            difference;
        for(int val : array)
            rSum += val;
        for(int i = 0; i < array.length - 1; i++)
        {
            lSum += array[i];
            rSum -= array[i];
            difference = Math.abs(rSum - lSum);
            if(difference < result)
                result = difference;
        }
        return result;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(10, solution(new int[] {0, 10}));
        Assert.assertEquals(1, solution(new int[] {3, 1, 2, 4, 3}));
    }
}