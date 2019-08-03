package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 9:10
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">217. Contains Duplicate</a>
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(containsDuplicate(new int[]{1, 2, 3, 4}));
        assertTrue(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
