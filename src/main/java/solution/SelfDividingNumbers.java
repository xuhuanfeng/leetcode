package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 10:00
 * @see <a href="https://leetcode.com/problems/self-dividing-numbers/">728. Self Dividing Numbers</a>
 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDiving(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isSelfDiving(int num) {
        int copy = num;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            if (digit == 0) {
                return false;
            }
            if (copy % digit != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01() {
        System.out.println(selfDividingNumbers(1, 22));
    }
}
