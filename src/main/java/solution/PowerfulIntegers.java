package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 9:59
 * @see <a href="https://leetcode.com/problems/powerful-integers/">970. Powerful Integers</a>
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> data = new HashSet<>();

        int powerX = 1;
        int powerY = 1;
        boolean needExits = false;

        for (; powerX <= bound && !needExits; powerX *= x) {
            powerY = 1;
            int size = data.size();
            for (; powerX + powerY <= bound; powerY *= y) {
                data.add(powerX + powerY);
                if (powerY * y == powerY) {
                    break;
                }
            }

            if (size == data.size()) {
                needExits = true;
            }
        }
        return new ArrayList<>(data);
    }

    @Test
    public void test01() {
        System.out.println(powerfulIntegers(2, 3, 10));
        System.out.println(powerfulIntegers(3, 5, 15));
        System.out.println(powerfulIntegers(2, 1, 10));
    }
}
