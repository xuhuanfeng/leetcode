package solution;

import java.io.*;

public class CommonSubsequence {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws IOException {
        String str = "";
        while ((str = next()) != null) {

            char[] c1 = str.toCharArray();
            str = next();
            char[] c2 = str.toCharArray();
            int s1Len = c1.length;
            int s2Len = c2.length;
            int[][] dp = new int[s1Len + 1][s2Len + 1];
            for (int i = 1; i <= s1Len; i++) {
                for (int j = 1; j <= s2Len; j++) {
                    if (c1[i - 1] == c2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            int max = 0;
            for (int[] ints : dp) {
                for (int anInt : ints) {
                    max = Math.max(max, anInt);
                }
            }
            System.out.println(max);
        }
    }
}
