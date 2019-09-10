package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-09-10 20:53
 * @see <a href="https://leetcode.com/problems/moving-stones-until-consecutive/">1033. Moving Stones Until Consecutive</a>
 */
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {

        int[] data = new int[]{a, b, c};
        Arrays.sort(data);

        int ab = data[1] - data[0];
        int bc = data[2] - data[1];
        int min;
        int max = 0;
        if (ab == bc && bc == 1) {
            min = 0;
        } else {
            if (Math.min(ab, bc) > 2) {
                min = 2;
            } else {
                min = 1;
            }

            max = ab - 1 + bc - 1;
        }
        return new int[]{min, max};
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(numMovesStones(1, 2, 5)));
        System.out.println(Arrays.toString(numMovesStones(3, 5, 1)));
    }
}
