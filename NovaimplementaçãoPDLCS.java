public class NovaimplementaçãoPDLCS {
    static int iterations = 0;

    // Função auxiliar para memoização
    static int lcsTopDown(String s1, String s2, int i, int j, int[][] memoi) {
        iterations++;
        if (i == s1.length() || j == s2.length())
            return 0;

        if (memoi[i][j] != -1)
            return memoi[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            memoi[i][j] = 1 + lcsTopDown(s1, s2, i + 1, j + 1, memoi);
        else
            memoi[i][j] = Math.max(
                lcsTopDown(s1, s2, i + 1, j, memoi),
                lcsTopDown(s1, s2, i, j + 1, memoi)
            );

        return memoi[i][j];
    }

    public static void main(String[] args) {
        String s1 = "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.";
        String s2 = "Remembering that you are going to die is the best way I know to avoid the trap of thinking you have something to lose. Don't waste your time living someone else's life.";
        int[][] memoi = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++)
            for (int j = 0; j < s2.length(); j++)
                memoi[i][j] = -1;

        long start = System.nanoTime();
        int lcsLength = lcsTopDown(s1, s2, 0, 0, memoi);
        long end = System.nanoTime();

        System.out.println("LCS: " + lcsLength);
        System.out.println("Tempo (ms): " + (end - start) / 1_000_000.0);
        System.out.println("Iterações: " + iterations);
        double similarity = (double) lcsLength / ((s1.length() + s2.length()) / 2.0) * 100;
        System.out.printf("Similaridade: %.2f%%\n", similarity);
    }
}
