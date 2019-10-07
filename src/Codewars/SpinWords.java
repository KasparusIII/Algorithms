package Codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpinWords
{
    //https://www.codewars.com/kata/stop-gninnips-my-sdrow

    public static String spinWords(String sentence)
    {
        StringBuilder result = new StringBuilder();
        for (String st : sentence.split(" "))
            if (st.length() >= 5)
                result.append(new StringBuilder(st).reverse()).append(' ');
            else
                result.append(st).append(' ');
        return result.deleteCharAt(result.length()-1).toString();
    }

    @Test
    public void spinWordsTest()
    {
        assertEquals("emocleW", spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", spinWords("Hey fellow warriors"));
    }
}