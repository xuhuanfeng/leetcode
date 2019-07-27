package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huanfeng.xu
 * @date 2019-07-25 21:14
 * @see <a href="https://leetcode.com/problems/fair-candy-swap/">888. Fair Candy Swap</a>
 */
public class FairCandySwap {
    /**
     * 水题，可惜看错了，以为是交换多个，囧...
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        for (int i : A) {
            sa += i;
        }

        for (int i : B) {
            sb += i;
        }

        int delta = (sb - sa) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int x : B) {
            setB.add(x);
        }

        for (int x : A) {
            if (setB.contains(x + delta)) {
                return new int[]{x, x + delta};
            }
        }
        return null;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
    }
}
