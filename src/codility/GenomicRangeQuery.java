package codility;

import org.junit.Test;
import org.junit.Assert;

public class GenomicRangeQuery
{
    //https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query

    private static final java.util.Hashtable<Character, Integer> IMPACT = new java.util.Hashtable<>();
    static {
        IMPACT.put('A', 1);
        IMPACT.put('C', 2);
        IMPACT.put('G', 3);
        IMPACT.put('T', 4);
    }
    private static final char[] NUCLEOTIDES = new char[] {'A', 'C', 'G'};

    public static int[] simpleSolution(String S, int[] P, int[] Q) // 62% to slow
    {
        int[] result = new int[P.length];
        for(int i = 0; i < P.length; i++)
            result[i] = IMPACT.get((char)S.substring(P[i], Q[i]+1).chars().min().getAsInt());
        return result;
    }

    public static int[] solution(String S, int[] P, int[] Q)
    {
        int[][] genomes = new int[NUCLEOTIDES.length][S.length() + 1];
        for (int i = 0; i < S.length(); i++)
            for (int j = 0; j < NUCLEOTIDES.length; j++)
                genomes[j][i + 1] = genomes[j][i] + (NUCLEOTIDES[j] == S.charAt(i) ? 1 : 0);

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++)
        {
            int j = 0;
            while (j < NUCLEOTIDES.length && genomes[j][Q[i] + 1] - genomes[j][P[i]] == 0)
                j++;
            result[i] = j + 1;
        }
        return result;
    }

    @Test
    public void solutionTest()
    {
        Assert.assertArrayEquals(new int[] {2, 4, 1}, solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}));
        Assert.assertArrayEquals(new int[] {2, 4, 1}, solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}));
        Assert.assertArrayEquals(new int[] {1, 1, 1}, solution("GGGGAAA", new int[] {2, 5, 0}, new int[] {4, 5, 6}));
        Assert.assertArrayEquals(new int[] {1, 1, 1}, solution("AAAAAAAAAAAA", new int[] {0, 0, 0}, new int[] {11, 11, 11}));
    }
}