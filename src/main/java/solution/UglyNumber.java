package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 10:42
 * @see <a href="https://leetcode.com/problems/ugly-number/">263. Ugly Number</a>
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num > 1) {
            if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
