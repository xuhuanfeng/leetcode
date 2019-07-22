package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanfeng.xu
 * @date 2019-07-22 21:07
 * @see <a href="https://leetcode.com/problems/fizz-buzz/">412. Fizz Buzz</a>
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        int cnt = n;
        n = 1;
        while (cnt >= n) {
            if (n % 3 == 0 && n % 5 == 0) {
                result.add("FizzBuzz");
            } else if (n % 3 == 0) {
                result.add("Fizz");
            } else if (n % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(n));
            }
            n++;
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(fizzBuzz(15));
    }
}
