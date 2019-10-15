package codewars;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersistBugger
{
    //https://www.codewars.com/kata/persistent-bugger

    public static int persistence(long n)
    {
        if(n < 10)
            return 0;
        long m = 1;
        for (char ch : (n + "").toCharArray())
            m *= ch - '0';
        return 1 + persistence(m);
    }

    @Test
    public void PersistTests()
    {
        Assert.assertEquals(3, persistence(39));
        Assert.assertEquals(0, persistence(4));
        Assert.assertEquals(2, persistence(25));
        Assert.assertEquals(4, persistence(999));
    }
}