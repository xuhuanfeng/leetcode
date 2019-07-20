package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-20 21:17
 * @see <a href="https://leetcode.com/problems/shortest-distance-to-a-character/">821. Shortest Distance to a Character</a>
 */
public class ShortestDistancetoACharacter {

    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int pre = -1;

        int[] result = new int[len];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                calc(result, pre, i);
                pre = i;
            }
        }
        if (pre == len - 1) {
            calc(result, pre, len - 1);
        } else {
            calc(result, pre, -1);
        }
        return result;
    }

    private void calc(int[] result, int left, int right) {
        if (left == -1) {
            for (int i = 0; i <= right; i++) {
                result[i] = right - i;
            }
        } else if (right == -1) {
            for (int i = left; i < result.length; i++) {
                result[i] = i - left;
            }
        } else {
            for (int i = left; i <= right; i++) {
                result[i] = Math.min(Math.abs(left - i), Math.abs(right - i));
            }
        }
    }

    public int[] another(String S, char C) {
        int len = S.length();
        int[] result = new int[len];
        int pos = -len;

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                pos = i;
            }
            result[i] = i - pos;
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == C) {
                pos = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - pos));
        }

        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(shortestToChar("eeeeeeeeee", 'e')));
        System.out.println(Arrays.toString(shortestToChar("abcabc", 'a')));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(another("loveleetcode", 'e')));
        System.out.println(Arrays.toString(another("eeeeeeeeee", 'e')));
        System.out.println(Arrays.toString(another("abcabc", 'a')));
    }

}
