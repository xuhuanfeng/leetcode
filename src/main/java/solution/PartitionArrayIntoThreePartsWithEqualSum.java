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

    public boolean another(int[] A) {
        int sum = 0;
        for (int n : A) {
            sum += n;
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;

        int curSum = 0;
        int numOfSegments = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            //check if we can form a segment
            if (curSum == sum && numOfSegments <= 1) {
                numOfSegments++;
                curSum = 0;
            }
        }
        //if we have 2 segments formed greedily and sum of leftover is also 1/3 of overall sum
        return (numOfSegments == 2 && curSum == sum);
    }

    @Test
    public void test01() {
        assertTrue(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        assertFalse(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        assertTrue(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }
}
