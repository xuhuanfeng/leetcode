package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-22 20:42
 * @see <a href="https://leetcode.com/problems/distribute-candies/">575. Distribute Candies</a>
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        int half = candies.length / 2;
        int size = set.size();
        return size >= half ? half : size;
    }

    @Test
    public void test01() {
        assertEquals(2, distributeCandies(new int[]{1, 1, 2, 3}));
        assertEquals(3, distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
