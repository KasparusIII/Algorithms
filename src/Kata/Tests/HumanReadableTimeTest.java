package Kata.Tests;

import Kata.HumanReadableTime;
import org.junit.Assert;
import org.junit.Test;


public class HumanReadableTimeTest
{
    @Test
    public void makeReadableTests()
    {
        Assert.assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
        Assert.assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
        Assert.assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
        Assert.assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
        Assert.assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
    }
}
