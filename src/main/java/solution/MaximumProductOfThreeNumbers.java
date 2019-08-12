package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-12 20:56
 * @see <a href="https://leetcode.com/problems/maximum-product-of-three-numbers/">628. Maximum Product of Three Numbers</a>
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        return Math.max(nums[0] * nums[1] * nums[len], nums[len] * nums[len - 1] * nums[len - 2]);
    }

    @Test
    public void test01() {
        assertEquals(6, maximumProduct(new int[]{1, 2, 3}));
        assertEquals(24, maximumProduct(new int[]{1, 2, 3, 4}));
        assertEquals(400, maximumProduct(new int[]{-100, -1, 0, 1, 2, 3, 4}));
    }
}
