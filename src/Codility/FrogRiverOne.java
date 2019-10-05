package Codility;

import org.junit.Assert;
import org.junit.Test;

public class FrogRiverOne
{
    //https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one

    private static int solution(int distance, int[] array)
    {    return array == null || array.length ==0 ? -1 : frogRiverOne(distance, array);    }

    private static int frogRiverOne(int distance, int[] array)
    {
        int i = -1, path = 0;
        boolean[] river = new boolean[distance];
        while(++i < array.length && path < distance)
            if(!river[array[i] - 1])
            {
                river[array[i] - 1] = true;
                path++;
            }

        return path == distance ? i - 1 : -1;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(6,  solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
        Assert.assertEquals(7,  solution(6, new int[] {1, 2, 3, 2, 3, 4, 5, 6}));
        Assert.assertEquals(-1, solution(7, new int[] {1, 2, 3, 2, 3, 4, 5, 6}));
        Assert.assertEquals(-1, solution(1, new int[] {}));
        Assert.assertEquals(-1, solution(0, new int[] {}));
        Assert.assertEquals(-1, solution(1, null));
        Assert.assertEquals(-1, solution(0, null));
    }
}