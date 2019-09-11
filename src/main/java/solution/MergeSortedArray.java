package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-11 20:14
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">88. Merge Sorted Array</a>
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int len = m + n;

        while (len > 0) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] < nums2[n]) {
                    nums1[len--] = nums2[n--];
                } else {
                    nums1[len--] = nums1[m--];
                }
            } else {
                while (m >= 0) {
                    nums1[len--] = nums1[m--];
                }
                while (n >= 0) {
                    nums1[len--] = nums2[n--];
                }
            }
        }
    }
}
