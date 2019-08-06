package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 21:18
 * @see <a href="https://leetcode.com/problems/relative-ranks/">506. Relative Ranks</a>
 */
public class RelativeRanks {
    class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public String[] findRelativeRanks(int[] nums) {
        List<Node> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(new Node(nums[i], i));
        }
        String[] result = new String[nums.length];
        list.sort((n1, n2) -> n2.val - n1.val);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (i == 0) {
                result[node.index] = "Gold Medal";
            } else if (i == 1) {
                result[node.index] = "Silver Medal";
            } else if (i == 2) {
                result[node.index] = "Bronze Medal";
            } else {
                result[node.index] = String.valueOf(i + 1);
            }
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 6, 4, 3, 2, 1})));
    }
}
