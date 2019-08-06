package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 20:54
 * @see <a href="https://leetcode.com/problems/range-addition-ii/">598. Range Addition II</a>
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }
        int xMin = ops[0][0];
        int yMin = ops[0][1];
        for (int[] op : ops) {
            if (op[0] < xMin) {
                xMin = op[0];
            }
            if (op[1] < yMin) {
                yMin = op[1];
            }
        }
        return xMin * yMin;
    }

    @Test
    public void test01() {
        assertEquals(4, maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
    }
}
