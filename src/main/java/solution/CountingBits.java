package solution;

/**
 * @author huanfeng.xu
 * @date 2019-12-10
 * @see <a href="https://leetcode.com/problems/counting-bits/">338. Counting Bits</a>
 */
public class CountingBits {
    // 看了半天，没想到好思路，看了题解，是找规律题...
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                ans[i] = ans[i/2] + 1;
            }else {
                ans[i] = ans [i/2];
            }
        }
        return ans;
    }
}
