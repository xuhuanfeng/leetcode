package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-08-11 7:58
 * @see <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5/">1018. Binary Prefix Divisible By 5</a>
 */
public class BinaryPrefixDivisibleBy5 {
    /**
     * 一开始知道就是一直左移，然后比较是否%5==0，但是会溢出
     * 参考答案之后才知道加法的模运算
     * (a + b) % 5 -> (a % 5 + b %5) % 5
     * 对应题目就是 (a[i-1] * 2 + a[i]) % 5 -> (a[i-1]% 5 + a[i] % 5) % 5
     * 由于 a[i] = 0/1，所以等价于 (a[i-1]% 5 + a[i]) % 5
     * 所以上一个结果先%5对结果没有影响，膜拜啊...
     *
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int k = 0;
        for (int i : A) {
            k = (k << 1 | i) % 5;
            result.add(k == 0);
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println(prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
        System.out.println(prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
    }
}
