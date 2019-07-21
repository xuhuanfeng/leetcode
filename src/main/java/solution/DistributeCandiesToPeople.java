package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 8:29
 * @see <a href="https://leetcode.com/problems/distribute-candies-to-people/">1103. Distribute Candies to People</a>
 */
public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        int idx = 0;
        int cnt = 1;
        while (candies > 0) {
            if (idx >= num_people) {
                idx = 0;
            }
            if (candies <= cnt) {
                result[idx] += candies;
                break;
            }
            result[idx] += cnt;
            candies -= cnt;
            cnt++;
            idx++;
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }
}
