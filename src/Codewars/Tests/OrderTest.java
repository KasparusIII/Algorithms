package Codewars.Tests;

import Codewars.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderTest
{
    @Test
    public void orderTests()
    {
        Assert.assertEquals("Thi1s is2 3a T4est", Order.order("is2 Thi1s T4est 3a"));
        Assert.assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", Order.order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    @Test
    public void orderEmptyTest()
    {
        Assert.assertEquals("", Order.order("Empty input should return empty string"));
        Assert.assertEquals("", Order.order(""));
    }
}
