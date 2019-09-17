package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-17 20:35
 * @see <a href="https://leetcode.com/problems/count-primes/">204. Count Primes</a>
 */
public class CountPrimes {
    public int countPrimes(int n) {
        // 素数表，参考的答案
        boolean[] prime = new boolean[n];

        int cnt = 0;

        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                cnt++;
            }
            for (int j = 2; i * j < n; j++) {
                prime[i * j] = true;
            }
        }
        return cnt;
    }
}
