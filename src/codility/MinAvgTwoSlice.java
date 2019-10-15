package codility;

import org.junit.Assert;
import org.junit.Test;

public class MinAvgTwoSlice
{
    //https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice

    public static int solution(int[] array)
    {    return array == null || array.length < 3 ? 0 : minAvgSlice(array);    }

    private static int minAvgSlice(int[] array)
    {
        int[] minSlice2 = new int[] {array[0] + array [1], 0};
        int[] minSlice3 = new int[] {Integer.MAX_VALUE,    0};
        for (int i = 2; i < array.length; i++)
        {
            minSlice(minSlice2, array[i - 1] + array[i],                i - 1);
            minSlice(minSlice3, array[i - 2] + array[i - 1] + array[i], i - 2);
        }

        return (minSlice2[0] / 2.0 <= minSlice3[0] / 3.0) ? minSlice2[1] : minSlice3[1];
    }

    private static void minSlice(int[] minSlice, int sliceSum, int i)
    {
        if (sliceSum < minSlice[0])
        {
            minSlice[0] = sliceSum;
            minSlice[1] = i;
        }
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(1, solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
    }
}