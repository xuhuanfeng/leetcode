package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 8:59
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">374. Guess Number Higher or Lower</a>
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int result;
        int left = 1;
        int mid;
        while (true) {
            mid = (left + n) >>> 1;
            result = guess(mid);
            if (result == -1) {
                n = mid - 1;
            } else if (result == 1) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
    }

    // provied api
    private int guess(int mid) {
        return 0;
    }
}
