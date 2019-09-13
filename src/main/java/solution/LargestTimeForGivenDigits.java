package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-09-13 7:22
 * @see <a href="https://leetcode.com/problems/largest-time-for-given-digits/">949. Largest Time for Given Digits</a>
 */
public class LargestTimeForGivenDigits {
    // 搜索的一个非常好的题目，可惜没有做出来，一开始想到各种判断，结果代码太难写了
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        if (i != k && k != j) {
                            int l = 6 - i - j - k;

                            int hour = A[i] * 10 + A[j];
                            int minute = A[k] * 10 + A[l];

                            if (hour < 24 && minute < 60) {
                                ans = Math.max(ans, hour * 60 + minute);
                            }
                        }
                    }
                }
            }
        }
        if (ans == -1) {
            return "";
        }
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }

    @Test
    public void test01() {
        System.out.println(largestTimeFromDigits(new int[]{1, 9, 0, 6}));
    }
}
