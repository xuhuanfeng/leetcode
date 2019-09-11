package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-09-11 20:47
 * @see <a href="https://leetcode.com/problems/contains-duplicate-ii/">219. Contains Duplicate II</a>
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(nums[i]);
            if (idx != null && Math.abs(idx - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
