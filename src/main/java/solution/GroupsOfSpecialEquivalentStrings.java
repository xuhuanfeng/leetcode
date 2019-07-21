package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-20 23:29
 * @see <a href="https://leetcode.com/problems/groups-of-special-equivalent-strings/">893. Groups of Special-Equivalent Strings</a>
 */
public class GroupsOfSpecialEquivalentStrings {
    // 一开始想着枚举A[i]的所有可能组合，然后发现复杂度太高了
    // 参考了实现，不是自己想出来的，特别巧妙
    public int numSpecialEquivGroups(String[] A) {
        Set<String> result = new HashSet<>();
        for (String s : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (i % 2 == 0) {
                    even[s.charAt(i) - 'a']++;
                } else {
                    odd[s.charAt(i) - 'a']++;
                }
            }
            result.add(Arrays.toString(odd) + " " + Arrays.toString(even));
        }
        return result.size();
    }

    @Test
    public void test01() {
        assertEquals(3, numSpecialEquivGroups(new String[]{"a","b","c","a","c","c"}));
        assertEquals(4, numSpecialEquivGroups(new String[]{"aa","bb","ab","ba"}));
    }
}
