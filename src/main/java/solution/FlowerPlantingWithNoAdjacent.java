package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-08-07 21:03
 * @see <a href="https://leetcode.com/problems/flower-planting-with-no-adjacent/">1042. Flower Planting With No Adjacent</a>
 */
public class FlowerPlantingWithNoAdjacent {
    // copy from solution
    // 非常巧妙的处理方式
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> G = new HashMap<>();
        for (int i = 0; i < N; i++) {
            G.put(i, new HashSet<>());
        }
        for (int[] p : paths) {
            G.get(p[0] - 1).add(p[1] - 1);
            G.get(p[1] - 1).add(p[0] - 1);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int[] colors = new int[5];
            for (int j : G.get(i)) {
                colors[res[j]] = 1;
            }
            for (int c = 4; c > 0; --c) {
                if (colors[c] == 0) {
                    res[i] = c;
                }
            }
        }
        return res;
    }

    @Test
    public void test01() {
        // System.out.println(Arrays.toString(gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}})));
        // System.out.println(Arrays.toString(gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}})));
        System.out.println(Arrays.toString(gardenNoAdj(6, new int[][]{{1, 4}, {1, 5}, {1, 6}, {2, 3}, {2, 5}, {2, 6}, {3, 4}, {3, 6}})));
    }
}
