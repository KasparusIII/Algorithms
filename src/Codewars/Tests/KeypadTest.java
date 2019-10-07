package Codewars.Tests;

import Codewars.Keypad;
import org.junit.Assert;
import org.junit.Test;

public class KeypadTest
{
    @Test
    public void keypadPressesTests()
    {
        Assert.assertEquals(9, Keypad.presses("LOL"));
        Assert.assertEquals(13, Keypad.presses("HOW R U"));
        Assert.assertEquals(47, Keypad.presses("WHERE DO U WANT 2 MEET L8R"));
        Assert.assertEquals(2, Keypad.presses("!@#$%^&*()-="));
    }
}