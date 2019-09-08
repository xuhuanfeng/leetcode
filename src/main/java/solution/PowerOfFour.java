package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 14:58
 * @see <a href="https://leetcode.com/problems/power-of-four/">342. Power of Four</a>
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num != 1) {
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return true;
    }
}
