package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 13:26
 * @see <a href="https://leetcode.com/problems/height-checker/">1051. Height Checker</a>
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] newHeight = Arrays.copyOf(heights, heights.length);
        Arrays.sort(newHeight);
        int cnt = 0;
        for (int i = 0; i < newHeight.length; i++) {
            if (newHeight[i] != heights[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(3, heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
