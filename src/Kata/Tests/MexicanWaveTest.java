package Kata.Tests;

import Kata.MexicanWave;
import org.junit.Assert;
import org.junit.Test;

public class MexicanWaveTest
{
    @Test
    public void waveTest()
    {
        Assert.assertArrayEquals(new String[] {"Hello", "hEllo", "heLlo", "helLo", "hellO"}, MexicanWave.wave("hello"));
        Assert.assertArrayEquals
            (
                new String[] {"Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS"},
                MexicanWave.wave("codewars")
            );
        Assert.assertArrayEquals(new String[] {}, MexicanWave.wave(""));
    }

    @Test
    public void waveGapTest()
    {
        Assert.assertArrayEquals
            (
                new String[] { "Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS" },
                MexicanWave.wave("two words")
            );
        Assert.assertArrayEquals(new String[] {" Gap ", " gAp ", " gaP "}, MexicanWave.wave(" gap "));
    }
}
