package solution;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-26 23:05
 * @see <a href="https://leetcode.com/problems/largest-perimeter-triangle/">976. Largest Perimeter Triangle</a>
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    @Test
    public void test01() {
        assertEquals(5, largestPerimeter(new int[]{2, 1, 2}));
        assertEquals(0, largestPerimeter(new int[]{1, 2, 1}));
        assertEquals(10, largestPerimeter(new int[]{3, 2, 3, 4}));
        assertEquals(8, largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}
