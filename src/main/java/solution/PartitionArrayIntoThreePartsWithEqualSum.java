package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 10:14
 * @see <a href="https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/">1013. Partition Array Into Three Parts With Equal Sum</a>
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int[] preSum = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i > 0) {
                preSum[i] = preSum[i - 1] + A[i];
            } else {
                preSum[i] = A[i];
            }
        }

        int sum = preSum[A.length - 1];

        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                if (preSum[i] == (preSum[j] - preSum[i]) && (preSum[i] == sum - preSum[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        assertFalse(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        assertTrue(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }
}
