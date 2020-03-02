package solution;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
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
//        Scanner scanner = new Scanner(System.in);
        int t = nextInt();
        while (t-- > 0) {
            int size = nextInt();
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = nextInt();
            }

            int[] sum = new int[size];
            int[] revSum = new int[size];

            sum[0] = data[0];
            for (int i = 1; i < size; i++) {
                sum[i] = Math.max(sum[i - 1] + data[i], data[i]);
            }

            for (int i = 1; i < sum.length; i++) {
                sum[i] = Math.max(sum[i - 1], sum[i]);
            }

            revSum[size - 1] = data[size - 1];
            for (int i = size - 2; i > 0; i--) {
                revSum[i] = Math.max(revSum[i + 1] + data[i], data[i]);
            }

            for (int i = size - 2; i > 0; i--) {
                revSum[i] = Math.max(revSum[i + 1], revSum[i]);
            }
//            System.out.println(Arrays.toString(max2));
            int max = Integer.MIN_VALUE;
            for (int i = 0; i + 1 < size; i++) {
                max = Math.max(max, sum[i] + revSum[i + 1]);
            }
            System.out.println(max);
        }
    }
}