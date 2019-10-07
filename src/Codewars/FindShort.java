package Codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindShort
{
    //https://www.codewars.com/kata/shortest-word

    public static int findShort(String s)
    {
        int result = Integer.MAX_VALUE;
        for (String st : s.split(" "))
            if (st.length() < result)
                result = st.length();
        return result;
    }

    @Test
    public void findShortTest()
    {
        assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, findShort("turns out random test cases are easier than writing out basic ones"));
    }
}
