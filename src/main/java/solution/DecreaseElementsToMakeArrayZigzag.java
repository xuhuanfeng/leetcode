package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 10:34
 * @see <a href="https://leetcode.com/contest/weekly-contest-148/problems/decrease-elements-to-make-array-zigzag">1144. Decrease Elements To Make Array Zigzag  </a>
 */
public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            if (i - 1 >= 0) {
                if (nums[i] >= nums[i - 1]) {
                    left = nums[i] - nums[i - 1] + 1;
                }
            }
            if (i + 1 < nums.length) {
                if (nums[i] >= nums[i + 1]) {
                    right = nums[i] - nums[i + 1] + 1;
                }
            }
            int max = Math.max(left, right);
            if (i % 2 == 0) {
                even += max;
            } else {
                odd += max;
            }
        }
        return Math.min(odd, even);
    }

    @Test
    public void test01() {
        assertEquals(2, movesToMakeZigzag(new int[]{1, 2, 3}));
        assertEquals(4, movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
        assertEquals(0, movesToMakeZigzag(new int[]{1, 2, 1, 2}));
        assertEquals(4, movesToMakeZigzag(new int[]{2, 7, 10, 9, 8, 9}));
    }
}
