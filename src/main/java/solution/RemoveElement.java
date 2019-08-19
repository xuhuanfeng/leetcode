package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-19 20:37
 * @see <a href="https://leetcode.com/problems/remove-element/">27. Remove Element</a>
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] != val) {
                i++;
            }
            while (i < j && nums[j] == val) {
                j--;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
//        System.out.println(i + " " + j);
        return nums[i] == val ? i : i + 1;
    }

    @Test
    public void test01() {
        assertEquals(2, removeElement(new int[]{3, 2, 2, 3}, 3));
        assertEquals(5, removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        assertEquals(1, removeElement(new int[]{4, 5}, 5));
        assertEquals(0, removeElement(new int[]{0, 0, 0, 0}, 0));
        assertEquals(0, removeElement(new int[]{1}, 1));
        assertEquals(1, removeElement(new int[]{2}, 3));
        assertEquals(0, removeElement(new int[]{}, 0));
    }

}
