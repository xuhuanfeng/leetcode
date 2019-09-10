package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-10 20:16
 * @see <a href="https://leetcode.com/problems/valid-boomerang/">1037. Valid Boomerang</a>
 */
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {

        int xx = points[0][0] - points[1][0];
        int yy = points[0][1] - points[1][1];

        int x = points[1][0] - points[2][0];
        int y = points[1][1] - points[2][1];
        return xx * y != yy * x;
    }

    @Test
    public void test01() {
        assertTrue(isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        assertFalse(isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        assertFalse(isBoomerang(new int[][]{{1, 1,}, {1, 1}, {1, 1}}));
    }
}
