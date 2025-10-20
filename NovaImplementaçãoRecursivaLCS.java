public class NovaImplementaçãoRecursivaLCS {
    static int iterations=0;
    static int lcsRec(String s1, String s2, int i, int j) {
        iterations++;
        if (i == s1.length() || j == s2.length())
            return 0;

        if (s1.charAt(i) == s2.charAt(j))
            return 1 + lcsRec(s1, s2, i + 1, j + 1);

        return Math.max(lcsRec(s1, s2, i + 1, j), lcsRec(s1, s2, i, j + 1));
    }

    static String getLCS(String s1, String s2, int i, int j) {
       
        if (i == s1.length() || j == s2.length())
            return "";

        if (s1.charAt(i) == s2.charAt(j))
            return s1.charAt(i) + getLCS(s1, s2, i + 1, j + 1);

        if (lcsRec(s1, s2, i + 1, j) > lcsRec(s1, s2, i, j + 1))
            return getLCS(s1, s2, i + 1, j);
        else
            return getLCS(s1, s2, i, j + 1);
    }

    public static void main(String[] args) {
        String s1 = "ACTGAC";
        String s2 = "TGACCA";
        long start = System.nanoTime();
        int result = lcsRec(s1, s2, 0, 0);
        long end = System.nanoTime();
        System.out.println("LCS: " + result);
        System.out.println("Sequência LCS: " + getLCS(s1, s2, 0, 0));
        System.out.println("Tempo (ms): " + (end - start) / 1_000_000.0);
        System.out.println("Similaridade: " + (double) result /(double) ((s1.length() + s2.length()) / 2) * 100 + "%");
    System.out.println("Iterações: "+iterations);
    }
}
