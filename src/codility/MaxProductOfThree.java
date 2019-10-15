package codility;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductOfThree
{
    //https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three

    public static int solution(int[] array)
    {
        java.util.Arrays.sort(array);
        int pPos = array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
        int pNeg = array[0] * array [1] * array[array.length - 1];
        return pPos > pNeg ? pPos :pNeg;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(60, solution(new int[] {-3, 1, 2, -2, 5, 6}));
    }
}