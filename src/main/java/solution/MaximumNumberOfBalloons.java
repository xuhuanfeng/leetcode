package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 10:32
 * @see <a href="https://leetcode.com/contest/weekly-contest-154/problems/maximum-number-of-balloons/">5189. Maximum Number of Balloons</a>
 */
public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            cnt[c - 'a']++;
        }

        int min = Math.min(cnt[0], cnt[1]);
        int l = cnt['l' - 'a'] / 2;
        int o = cnt['o' - 'a'] / 2;
        int n = cnt['n' - 'a'];
        if (min > l) {
            min = l;
        }
        if (min > o) {
            min = o;
        }
        if (min > n) {
            min = n;
        }
        return min;
    }

    @Test
    public void test01() {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
