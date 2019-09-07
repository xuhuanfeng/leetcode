package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 7:29
 * @see <a href="https://leetcode.com/problems/plus-one/">66. Plus One</a>
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }

        int len = digits.length - 1;
        int leading = 1;
        List<Integer> data = new ArrayList<>(digits.length + 1);
        while (len >= 0) {
            int tmp = leading + digits[len];
            data.add(tmp % 10);
            leading = tmp / 10;
            len--;
        }

        if (leading > 0) {
            data.add(leading);
        }

        int[] result = new int[data.size()];
        int size = data.size();
        for (int i = 0; i < size; i++) {
            result[i] = data.get(size - 1 - i);
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 1, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{8, 8, 9})));
    }
}
