package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 9:08
 * @see <a href="https://leetcode.com/problems/house-robber/">198. House Robber</a>
 */
public class HouseRobber {
    public int rob(int[] nums) {

        int length = nums.length;

        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        int[] maxSum = new int[length];

        maxSum[0] = nums[0];
        maxSum[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + nums[i]);
        }

        return maxSum[length - 1];
    }

    @Test
    public void test01() {
        assertEquals(4, rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
    }
}
