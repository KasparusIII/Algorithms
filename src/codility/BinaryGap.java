package codility;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.OptionalInt;

public class BinaryGap
{
    //https://app.codility.com/programmers/lessons/1-iterations/binary_gap

    private static int streamSolution(int number)
    {
        int result = 0;
        if (number > 4)
        {
            String[] array = Integer.toBinaryString(number).split("1");
            OptionalInt oi = Arrays.stream(array).limit((number & 1) == 0 ? array.length - 1 : array.length)
                    .mapToInt(String::length).max();
            result = oi.isPresent() ? oi.getAsInt() : 0;
        }
        return result;
    }

    private static int solution(int number)
    {
        int result = 0;
        if (number > 4)
        {
            String[] array = Integer.toBinaryString(number).split("1");
            if ((number & 1) == 0 )
                array[array.length - 1] = "";
            for (String s : array)
                if (s.length() > result)
                    result = s.length();
        }
        return result;
    }

    @Test
    public void solutionTests()
    {
        Assert.assertEquals(0, solution(-1));
        Assert.assertEquals(0, solution(4));
        Assert.assertEquals(2, solution(9));
        Assert.assertEquals(0, solution(15));
        Assert.assertEquals(1, solution(20));
        Assert.assertEquals(0, solution(32));
        Assert.assertEquals(0, solution(120));
        Assert.assertEquals(4, solution(529));
        Assert.assertEquals(5, solution(1041));
    }
}