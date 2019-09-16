package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-09-16 19:48
 * @see <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int len = nums.length - 1;

        while (k > 0) {
            int tmp = nums[len];
            int i = nums.length - 2;
            while (i >= 0) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[0] = tmp;
            k--;
        }
    }

    @Test
    public void test01() {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(data, 3);
        System.out.println(Arrays.toString(data));
    }
}
