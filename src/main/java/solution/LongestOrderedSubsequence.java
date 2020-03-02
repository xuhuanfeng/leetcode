package solution;

import java.io.*;
import java.util.Arrays;

public class LongestOrderedSubsequence {
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
        int n = nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = nextInt();
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[j] < data[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        int maxn = 1;
        for (int i : dp) {
            maxn = Math.max(maxn, i);
        }
        System.out.println(maxn);
    }
}
