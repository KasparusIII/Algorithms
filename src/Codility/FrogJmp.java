package Codility;

import org.junit.Assert;
import org.junit.Test;

public class FrogJmp
{
    //https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp

    private static int solution(int startPoint, int finishPoint, int singleMove)
    {
        int distance = Math.abs(finishPoint - startPoint);
        return distance == 0 ? 0 : (distance + (singleMove - 1)) / singleMove;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(3, solution(10, 85, 30));
        Assert.assertEquals(0, solution(10, 10, 30));
        Assert.assertEquals(10, solution(0, 95, 10));
        Assert.assertEquals(1000000000, solution(0, 1000000000, 1));
    }
}