package Kata;


import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SimpleEncryption
{
    //https://www.codewars.com/kata/simple-encryption-number-1-alternating-split

    public static String encrypt(final String text, final int n)
    {
        String result = text;
        if(text != null && !text.isEmpty() && n > 0)
        {
            char[] chars = text.toCharArray();
            result = encryptHelp(IntStream.range(0, text.length()).toArray(), n)
                    .mapToObj(i -> Character.toString(chars[i])).collect(Collectors.joining());
        }
        return result;
    }

    private static IntStream encryptHelp(int[] indexes, int n)
    {
        int[] result = IntStream.concat
                (
                        IntStream.iterate(1, i -> i + 2).limit( indexes.length    / 2),
                        IntStream.iterate(0, i -> i + 2).limit((indexes.length+1) / 2)
                ).map(i -> indexes[i]).toArray();
        return --n == 0 ? IntStream.of(result) : encryptHelp(result, n);
    }

    public static String decrypt(final String text, final int n)
    {
        String result = text;
        if(text != null && !text.isEmpty() && n > 0)
        {
            char[] chars = text.toCharArray();
            result = decryptHelp(IntStream.range(0, text.length()).toArray(), n)
                    .mapToObj(i -> Character.toString(chars[i])).collect(Collectors.joining());
        }
        return result;
    }

    private static IntStream decryptHelp(int[] indexes, int n)
    {
        int[] a1 = IntStream.range(indexes.length/2, indexes.length).toArray();
        int[] a2 = IntStream.range(0, indexes.length/2).toArray();
        int[] result = new int[indexes.length];

        for (int i = 0; i < indexes.length/2; i++)
        {
            result[i*2]   = a1[i];
            result[i*2+1] = a2[i];
        }
        if (indexes.length%2==1)
            result[indexes.length-1] = a1[a1.length-1];

        result = IntStream.of(result).map(i -> indexes[i]).toArray();
        return --n == 0 ? IntStream.of(result) : decryptHelp(result, n);
    }

    @Test
    public void encryptHelpTest()
    {
        assertArrayEquals(new int[] {1, 3, 5, 0, 2, 4}, SimpleEncryption.encryptHelp(new int[] {0, 1, 2, 3, 4, 5}, 1).toArray());
        assertArrayEquals(new int[] {3, 0, 4, 1, 5, 2}, SimpleEncryption.encryptHelp(new int[] {0, 1, 2, 3, 4, 5}, 2).toArray());
        assertArrayEquals(new int[] {1, 3, 5, 0, 2, 4, 6}, SimpleEncryption.encryptHelp(new int[] {0, 1, 2, 3, 4, 5, 6}, 1).toArray());
        assertArrayEquals(new int[] {3, 0, 4, 1, 5, 2, 6}, SimpleEncryption.encryptHelp(new int[] {0, 1, 2, 3, 4, 5, 6}, 2).toArray());
    }

    @Test
    public void decryptHelpTest()
    {
        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6}, SimpleEncryption.decryptHelp(new int[] {1, 3, 5, 0, 2, 4, 6}, 1).toArray());
        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5}, SimpleEncryption.decryptHelp(new int[] {1, 3, 5, 0, 2, 4}, 1).toArray());
        assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6}, SimpleEncryption.decryptHelp(new int[] {3, 0, 4, 1, 5, 2, 6}, 2).toArray());
        //assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5}, SimpleEncryption.decryptHelp(new int[] {3, 0, 4, 1, 5, 2}, 2).toArray());
    }
}