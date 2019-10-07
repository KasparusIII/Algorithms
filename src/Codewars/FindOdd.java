package Codewars;

import org.junit.Test;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class FindOdd
{
    //https://www.codewars.com/kata/find-the-odd-int

    public static int findIt(int[] a)
    {
        LinkedList<Integer> la = IntStream.of(a).boxed().collect(Collectors.toCollection(LinkedList::new));
        int odd_number = Integer.MAX_VALUE;
        boolean not_found = true;
        while(not_found && !la.isEmpty())
        {
            int num = la.getFirst();
            int n = 1;
            la.removeFirst();

            for (int i = la.size()-1; i>-1; i--)
                if (la.get(i)==num)
                {
                    n++;
                    la.remove(i);
                }

            if(n%2==1)
            {
                odd_number = num;
                not_found = false;
            }
        }
        return odd_number;
    }

    @Test
    public void findItTest()
    {
        assertEquals( 5, findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals( 5, findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, findIt(new int[]{10}));
        assertEquals(10, findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals( 1, findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}
