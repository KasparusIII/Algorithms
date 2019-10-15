package codewars;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArrayEqualSides
{
    //https://www.codewars.com/kata/equal-sides-of-an-array

    public static int findEvenIndex(int[] arr)
    {
        int sqr  = -1,
                rSum =  Arrays.stream(arr, 1, arr.length).sum(),
                lSum =  0;

        int n = 0;
        boolean cont = true;
        while (cont)
        {
            if(rSum == lSum)
            {
                sqr = n;
                cont = false;
            }
            else if(n < arr.length-1)
            {
                lSum += arr[n];
                rSum -= arr[++n];
            }
            else cont = false;
        }

        return sqr;
    }

    @Test
    public void findEvenIndexTest()
    {
        assertEquals(3,findEvenIndex(new int[] {1,2,3,4,3,2,1}));
        assertEquals(1,findEvenIndex(new int[] {1,100,50,-51,1,1}));
        assertEquals(-1,findEvenIndex(new int[] {1,2,3,4,5,6}));
        assertEquals(3,findEvenIndex(new int[] {20,10,30,10,10,15,35}));
        assertEquals(-1,findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
        assertEquals(1,findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6,findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }
}
