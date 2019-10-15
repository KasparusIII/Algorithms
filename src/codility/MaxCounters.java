package codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class MaxCounters
{
    //https://app.codility.com/programmers/lessons/4-counting_elements/max_counters

    private static int[] simpleSolution(int n, int[] array) //77% to slow
    {
        int[] result = new int[n];
        if(array!=null && array.length!=0)
        {
            int max = 0;
            for(int val : array)
                if(val > n)
                    Arrays.fill(result, max);
                else if (++result[val-1] > max)
                        max++;
        }
        return result;
    }

    private static int[] solution(int n, int[] array)
    {
        int[] result = new int[n];
        if(array!=null && array.length!=0)
        {
            boolean nFound = true;
            int i = array.length;
            while(--i > -1 && nFound)
                if(array[i] > n)
                    nFound = false;
                else
                    result[array[i] - 1]++;

            int allAdd = mostFrequent(n, array, i);
            for(i = 0; i < n; i++)
                result[i] += allAdd;
        }
        return result;
    }

    private static int mostFrequent(int n, int[] array, int i)
    {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int val, max = 0, allAdd = 0;
        for(; i > -1; i--)
            if(array[i] > n)
            {
                allAdd += max;
                frequency = new HashMap<>();
                max = 0;
            }
            else
            {
                frequency.put(array[i], (val = !frequency.containsKey(array[i]) ? 1 : frequency.get(array[i]) + 1));
                if (val > max)
                    max++;
            }

        return allAdd + max;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
        Assert.assertArrayEquals(new int[]{5}, solution(1, new int[]{1, 1, 1, 1, 1}));
        Assert.assertArrayEquals(new int[]{5}, solution(1, new int[]{1, 1, 2, 1, 2, 1, 2, 1}));
    }
}