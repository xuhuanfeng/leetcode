package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 10:53
 * @see <a href="https://leetcode.com/problems/largest-number-at-least-twice-of-others/">747. Largest Number At Least Twice of Others</a>
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int maxn = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxn) {
                maxn = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex) {
                if (2 * nums[i] > maxn) {
                    return -1;
                }
            }
        }
        return maxIndex;
    }
}
