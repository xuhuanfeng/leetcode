package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-24 13:47
 * @see <a href="https://leetcode.com/problems/longest-continuous-increasing-subsequence/">674. Longest Continuous Increasing Subsequence</a>
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                cnt++;
            }

            if (cnt > maxLength) {
                maxLength = cnt;
            }

            if (i > 0 && nums[i] <= nums[i - 1]) {
                cnt = 1;
            }
        }
        return maxLength;
    }

    @Test
    public void test01() {
        assertEquals(3, findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        assertEquals(4, findLengthOfLCIS(new int[]{1, 3, 5, 7}));
        assertEquals(0, findLengthOfLCIS(new int[]{}));
        assertEquals(1, findLengthOfLCIS(new int[]{1}));
    }
}
