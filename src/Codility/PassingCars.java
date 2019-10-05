package Codility;

import org.junit.Assert;
import org.junit.Test;

public class PassingCars
{
    //https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars

    private static int solution(int[] A)
    {
        int result = 0;
        if(A!=null && A.length>1)
        {
            int i = 0;
            while (i < A.length && A[i] == 1)
                i++;

            int sum = 0;
            for(int j = i; j < A.length; j++)
                    sum += A[j];

            result += sum;
            while(++i < A.length && sum > 0 && result <= 1_000_000_000)
                if (A[i] == 0)
                    result += sum;
                else
                    sum--;
        }
        return result > 1_000_000_000? -1 : result;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(5, solution(new int[] {0, 1, 0, 1, 1}));
        Assert.assertEquals(0, solution(new int[] {0, 0}));
        Assert.assertEquals(0, solution(new int[] {1, 1}));
        Assert.assertEquals(1, solution(new int[] {0, 1}));
        Assert.assertEquals(0, solution(new int[] {1, 0}));
    }
}