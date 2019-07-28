package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 21:47
 * @see <a href="https://leetcode.com/problems/move-zeroes/">283. Move Zeroes</a>
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int targetIndex = 0;

        while (targetIndex < nums.length) {
            if (nums[targetIndex] != 0) {
                zeroIndex = 0;
                while (zeroIndex < nums.length) {
                    if (nums[zeroIndex] == 0) {
                        break;
                    } else {
                        zeroIndex++;
                    }
                }
                if (zeroIndex > targetIndex) {
                    targetIndex++;
                    continue;
                } else {
                    nums[zeroIndex] = nums[targetIndex];
                    nums[targetIndex] = 0;
                }
            }
            targetIndex++;
        }
    }

    public void another(int[] nums) {
        int lastZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastZero++] = nums[i];
            }
        }
        for (int i = lastZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void test01() {
        int[] data = new int[]{0, 1, 0, 3, 12};
        moveZeroes(data);
        System.out.println(Arrays.toString(data));

        data = new int[]{4, 0, 4};
        moveZeroes(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void test02() {
        int[] data = new int[]{0, 1, 0, 3, 12};
        another(data);
        System.out.println(Arrays.toString(data));

        data = new int[]{4, 0, 4};
        another(data);
        System.out.println(Arrays.toString(data));
    }
}
