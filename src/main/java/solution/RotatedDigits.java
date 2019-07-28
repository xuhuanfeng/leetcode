package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 21:17
 * @see <a href="https://leetcode.com/problems/rotated-digits/">788. Rotated Digits</a>
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = i;
            StringBuilder rotateResult = new StringBuilder();
            while (tmp != 0) {
                int digit = tmp % 10;
                if (digit == 0 || digit == 1 || digit == 8) {
                    rotateResult.append(digit);
                } else if (digit == 2) {
                    rotateResult.append(5);
                } else if (digit == 5) {
                    rotateResult.append(2);
                } else if (digit == 6) {
                    rotateResult.append(9);
                } else if (digit == 9) {
                    rotateResult.append(6);
                } else {
                    break;
                }
                tmp /= 10;
            }
            // System.out.println(rotateResult.reverse().toString());
            if (tmp == 0 && Integer.parseInt(rotateResult.reverse().toString()) != i) {
                // System.out.printf("%d ", i);
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * dp做法，从其他答案拷贝的，非常棒的答案
     *
     * @param N
     * @return
     */
    public int another(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if (a == 1 && b == 1) {
                    dp[i] = 1;
                } else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test01() {
        assertEquals(4, rotatedDigits(10));
    }
}
