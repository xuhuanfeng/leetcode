package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-12 23:23
 * @see <a href="https://leetcode.com/problems/n-repeated-element-in-size-2n-array/">961. N-Repeated Element in Size 2N Array</a>
 */
public class NRepeatedElementInSize2NArray {

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        return -1;
    }

    @Test
    public void test01() {
        assertEquals(3, repeatedNTimes(new int[] {1, 2, 3, 3}));
        assertEquals(2, repeatedNTimes(new int[] {2,1,2,5,3,2}));
    }
}
