package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 9:07
 * @see <a href="https://leetcode.com/problems/maximum-average-subarray-i/">643. Maximum Average Subarray I</a>
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            if (max < sum) {
                max = sum;
            }
        }
        return max * 1.0 / k;
    }

    @Test
    public void test01() {
        assertEquals(12.75, findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 0.01);
    }
}
