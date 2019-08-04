package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 22:28
 * @see <a href="https://leetcode.com/problems/degree-of-an-array/">697. Degree of an Array</a>
 */
public class DegreeOfAnArray {
    class Node {
        int cnt;
        int firstIndex = -1;
        int lastIndex;
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Node node = map.get(nums[i]);
            if (node == null) {
                node = new Node();
            }
            node.cnt = node.cnt + 1;
            if (node.firstIndex == -1) {
                node.firstIndex = node.lastIndex = i;
            } else {
                node.lastIndex = i;
            }
            map.put(nums[i], node);
        }

        int maxVal = 0;
        int minLength = 0;
        for (Node value : map.values()) {
            int len = value.lastIndex - value.firstIndex;
            if (value.cnt > maxVal) {
                maxVal = value.cnt;
                minLength = len;
            } else if (value.cnt == maxVal && len < minLength) {
                minLength = len;
            }
        }
        return minLength + 1;
    }

    @Test
    public void test01() {
        assertEquals(2, findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        assertEquals(6, findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        assertEquals(1, findShortestSubArray(new int[]{1}));
    }
}
