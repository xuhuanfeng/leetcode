package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-29 11:54
 * @see <a href="https://leetcode.com/problems/shortest-completing-word/">748. Shortest Completing Word</a>
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[][] data = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                data[i][c - 'a']++;
            }
        }

        int[] license = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                license[Character.toLowerCase(c) - 'a']++;
            }
        }
        int ans = 0;
        int minLen = 1000;
        for (int i = 0; i < data.length; i++) {
            int j;
            for (j = 0; j < license.length; j++) {
                if (license[j] > data[i][j]) {
                    break;
                }
            }
            if (j == license.length) {
                if (words[i].length() < minLen) {
                    minLen = words[i].length();
                    ans = i;
                }
            }
        }
        return words[ans];
    }

    @Test
    public void test01() {
        assertEquals("steps", shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        assertEquals("pest", shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
