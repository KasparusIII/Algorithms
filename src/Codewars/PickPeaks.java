package Codewars;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PickPeaks
{
    //https://www.codewars.com/kata/pick-peaks

    public static Map<String, List<Integer>> getPeaks(int[] arr)
    {
        List<Integer> pos = new LinkedList<>();
        for (int i=1; i<arr.length-1; i++)
            if(arr[i-1]<arr[i])
                if (arr[i+1]<arr[i])
                    pos.add(i);
                else if (arr[i+1]==arr[i])
                {
                    int temp_pos  = i;
                    do i++;
                    while(i<arr.length-2 && arr[i+1]==arr[i]);
                    if (arr[i+1]<arr[i])
                        pos.add(temp_pos);
                }

        return new HashMap<>()
        {{
            put("pos",   pos);
            put("peaks", pos.stream().map(i -> arr[i]).collect(Collectors.toList()));
        }};
    }

    @Test
    public void getPeaksTest()
    {
        String[] msg = {"should support finding peaks",
                "should support finding peaks, but should ignore peaks on the edge of the array",
                "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
                "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
                "should support finding peaks, but should ignore peaks on the edge of the array"};


        int[][] array = {{1,2,3,6,4,1,2,3,2,1},
                {3,2,3,6,4,1,2,3,2,1,2,3},
                {3,2,3,6,4,1,2,3,2,1,2,2,2,1},
                {2,1,3,1,2,2,2,2,1},
                {2,1,3,1,2,2,2,2}};

        int[][] posS  = {{3,7},
                {3,7},
                {3,7,10},
                {2,4},
                {2},};

        int[][] peaksS = {{6,3},
                {6,3},
                {6,3,2},
                {3,2},
                {3}};

        for (int n = 0 ; n < msg.length ; n++)
        {
            final int[] p1 = posS[n], p2 = peaksS[n];
            Map<String,List<Integer>> expected = new HashMap<>()
            {{
                put("pos",   Arrays.stream(p1).boxed().collect(Collectors.toList()));
                put("peaks", Arrays.stream(p2).boxed().collect(Collectors.toList()));
            }},
                    actual = getPeaks(array[n]);
            assertEquals(msg[n], expected, actual);
        }
    }
}