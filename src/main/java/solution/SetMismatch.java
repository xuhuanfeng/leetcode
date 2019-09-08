package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 10:22
 * @see <a href="https://leetcode.com/problems/set-mismatch/">645. Set Mismatch</a>
 */
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        Set<Integer> target = new HashSet<>();
        int n = nums.length;
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            target.add(i);
            tmp ^= i;
        }

        int duplication = 0;
        for (int num : nums) {
            if (target.contains(num)) {
                target.remove(num);
                tmp ^= num;
            } else {
                duplication = num;
            }
        }
        return new int[]{duplication, tmp};
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
    }
}
