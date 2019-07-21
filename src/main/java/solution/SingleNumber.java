package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 10:24
 * @see <a href="https://leetcode.com/problems/single-number/">136. Single Number</a>
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }

    @Test
    public void test01() {
        assertEquals(1, singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
