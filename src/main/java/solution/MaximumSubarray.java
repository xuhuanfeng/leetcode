package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-26 20:50
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">53. Maximum Subarray</a>
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1] + nums[i], nums[i]);
        }

        int max = result[0];
        for (int i : result) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Test
    public void test01() {
        assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
