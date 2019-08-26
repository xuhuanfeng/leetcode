package solution;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-08-25 11:13
 * @see <a href="https://leetcode.com/contest/weekly-contest-151/problems/compare-strings-by-frequency-of-the-smallest-character/">
 *     1170. Compare Strings by Frequency of the Smallest Character</a>
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[][] q = new int[queries.length][26];
        int[][] w = new int[words.length][26];

        for (int i = 0; i < queries.length; i++) {
            for (char c : queries[i].toCharArray()) {
                q[i][c - 'a']++;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                w[i][c - 'a']++;
            }
        }

        int[] cntQ = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            for (int i1 : q[i]) {
                if (i1 != 0) {
                    cntQ[i] = i1;
                    break;
                }
            }
        }

        int[] cntW = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            for (int i1 : w[i]) {
                if (i1 != 0) {
                    cntW[i] = i1;
                    break;
                }
            }
        }

        int[] ans = new int[q.length];
        for (int i = 0; i < cntQ.length; i++) {
            int cnt = 0;
            for (int i1 : cntW) {
                if (cntQ[i] < i1) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    @org.junit.Test
    public void test01() {
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
    }
}
