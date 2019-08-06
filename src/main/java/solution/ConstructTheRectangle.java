package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 21:01
 * @see <a href="https://leetcode.com/problems/construct-the-rectangle/">492. Construct the Rectangle</a>
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (true) {
            if (area % w == 0) {
                return new int[]{area / w, w};
            }
            w--;
        }
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle(8)));
    }
}
