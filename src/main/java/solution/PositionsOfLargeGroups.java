package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-08-07 21:17
 * @see <a href="https://leetcode.com/problems/positions-of-large-groups/">830. Positions of Large Groups</a>
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                end++;
            } else {
                if (end - start >= 2) {
                    result.add(Arrays.asList(start, end));
                }
                start = i;
                end = i;
            }
        }
        if (end - start >= 2) {
            result.add(Arrays.asList(start, end));
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("abc"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(largeGroupPositions("aaa"));
    }
}
