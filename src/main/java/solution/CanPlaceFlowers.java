package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-16 20:17
 * @see <a href="https://leetcode.com/problems/can-place-flowers/">605. Can Place Flowers</a>
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int start = 0;
        int end = flowerbed.length - 1;

        if (flowerbed.length == 1 && n == 1 && flowerbed[0] == 0) {
            return true;
        }

        while (n > 0 && (start <= end)) {
            if (start - 1 >= 0) {
                if (start == 1 && flowerbed[1] == 0 && flowerbed[0] == 0) {
                    n--;
                    flowerbed[0] = 1;
                } else if (start == end && flowerbed[end] == 0 && flowerbed[end - 1] == 0) {
                    n--;
                    flowerbed[end] = 1;
                } else if (start + 1 <= end) {
                    if (flowerbed[start - 1] == 0 && flowerbed[start] == 0 && flowerbed[start + 1] == 0) {
                        n--;
                        flowerbed[start] = 1;
                    }
                }
            }
            start++;
        }
        return n == 0;
    }

    @Test
    public void test01() {
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        assertFalse(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        assertTrue(canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        assertTrue(canPlaceFlowers(new int[]{0, 0}, 1));
        assertTrue(canPlaceFlowers(new int[]{0, 0, 0}, 2));
    }
}
