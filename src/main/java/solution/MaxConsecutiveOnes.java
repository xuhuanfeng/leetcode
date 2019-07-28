package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 21:12
 * @see <a href="https://leetcode.com/problems/max-consecutive-ones/">485. Max Consecutive Ones</a>
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int tMax = 0;
        for (int num : nums) {
            if (num == 1) {
                tMax++;
            } else {
                ans = Math.max(ans, tMax);
                tMax = 0;
            }
        }
        ans = Math.max(ans, tMax);
        return ans;
    }

    @Test
    public void test01() {
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
