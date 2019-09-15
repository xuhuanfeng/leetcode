package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 10:52
 * @see <a href="https://leetcode.com/contest/weekly-contest-154/problems/k-concatenation-maximum-sum/">5191. K-Concatenation Maximum Sum</a>
 */
public class KConcatenationMaximumSum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1000000000 + 7;
        long maxSum = 0;

        long sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (k >= 2) {
            long cnt = 0;
            long twoSum = 0;
            long threeSum = 0;

            for (int kk = 0; kk < 2; kk++) {
                for (int i : arr) {
                    cnt += i;
                    if (cnt > 0) {
                        if (cnt > twoSum) {
                            twoSum = cnt;
                        }
                    } else {
                        cnt = 0;
                    }
                }
            }
            cnt = 0;
            if (k > 3) {
                for (int kk = 0; kk < 3; kk++) {
                    for (int i : arr) {
                        cnt += i;
                        if (cnt > 0) {
                            if (cnt > threeSum) {
                                threeSum = cnt;
                            }
                        } else {
                            cnt = 0;
                        }
                    }
                }
            }

            if (threeSum > twoSum) {
                maxSum = twoSum + (k - 2) * (threeSum - twoSum);
            } else {
                maxSum = twoSum;
            }
        } else {
            long cnt = 0;
            for (int i : arr) {
                cnt += i;
                if (cnt > 0) {
                    if (cnt > maxSum) {
                        maxSum = cnt;
                    }
                } else {
                    cnt = 0;
                }
            }
        }
        long kSum = sum * k;
        long max = Math.max(kSum, maxSum);
        return (int) (max % mod);
    }

    @Test
    public void testa01() {
        assertEquals(9, (kConcatenationMaxSum(new int[]{1, 2}, 3)));
        assertEquals(2, kConcatenationMaxSum(new int[]{1, -2, 1}, 5));
        assertEquals(0, kConcatenationMaxSum(new int[]{-1, -2}, 7));
        assertEquals(40, kConcatenationMaxSum(new int[]{1, 0, 4, 1, 4}, 4));
        assertEquals(20, kConcatenationMaxSum(new int[]{-5, -2, 0, 0, 3, 9, -2, -5, 4}, 5));
    }
}
