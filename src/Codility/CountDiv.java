package Codility;

import org.junit.Assert;
import org.junit.Test;

public class CountDiv
{
    //https://app.codility.com/programmers/lessons/5-prefix_sums/count_div

    private static int solution(int A, int B, int K)
    {
        int mod = A % K;
        return (mod == 0 ? 1 : 0) + (mod + B - A) / K;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(1, solution(0, 0, 3));
        Assert.assertEquals(1, solution(2, 2, 2));
        Assert.assertEquals(1, solution(2, 3, 2));
        Assert.assertEquals(2, solution(2, 4, 2));
        Assert.assertEquals(3, solution(6, 11, 2));
    }
}