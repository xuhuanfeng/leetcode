package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 16:52
 * @see <a href="https://leetcode.com/problems/minimum-moves-to-equal-array-elements/">453. Minimum Moves to Equal Array Elements</a>
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        int cnt = 0;
        while (true) {
            int tmp = Math.abs(nums[last] - nums[0]);
            if (tmp == 0) {
                break;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i != last) {
                    nums[i] += tmp;
                }
            }
            cnt += tmp;
            last--;
            if (last == 0) {
                last = nums.length - 1;
            }
        }
        return cnt;
    }


    /**
     * 来自答案区大佬的答案
     *
     * 推倒过程如下，假设初始总和为sum，最小值为min，经过m次操作之后，得到最终答案x
     *  则有如下关系：sum + (m * 1) * (n-1) = x * n
     *      解释：一次移动n-1个元素，一个元素增加1，则m次移动带来的加值为：m *  (n-1)
 *      同时，由于此时min=x，则有，min + m = x
     *  化简得到：m = sum - min * n
     *
     *  真心羡慕数学厉害的人....
     *
     * @param nums 目标数组
     * @return 增加次数
     */
    public int another(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num < min) {
                min = num;
            }
        }
        return sum - min * nums.length;
    }

    @Test
    public void test01() {
        assertEquals(3, minMoves(new int[]{1, 2, 3}));
        assertEquals(6, minMoves(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test02() {
        assertEquals(3, another(new int[]{1, 2, 3}));
        assertEquals(6, another(new int[]{1, 2, 3, 4}));
    }
}
