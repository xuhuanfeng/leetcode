package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanf
 * @date 2019-11-24 10:23
 */
public class Test20191124 {


    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - points[i - 1][0]);
            int y = Math.abs(points[i][1] - points[i - 1][1]);
            sum += Math.max(x, y);
        }
        return sum;
    }

    public int countServers(int[][] grid) {

        int total = 0;

        int[] row = new int[grid.length];
        int colLen = grid[0].length;
        int[] col = new int[colLen];

        for (int i = 0; i < grid.length; i++) {
            int tmp = 0;
            for (int i1 : grid[i]) {
                tmp += i1;
            }
            if (tmp > 1) {
                row[i] = 1;
            }
            total += tmp;
        }

        for (int i = 0; i < colLen; i++) {
            int tmp = 0;
            for (int i1 = 0; i1 < grid.length; i1++) {
                tmp += grid[i1][i];
            }
            if (tmp > 1) {
                col[i] = 1;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && row[i] == 0 && col[j] == 0) {
                    total--;
                }
            }
        }
        return total;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            String product = products[i];
            char[] chars = product.toCharArray();
            for (int ii = 0; ii < chars.length; ii++) {
                String idx = new String(chars, 0, ii + 1);
//                System.out.println(idx);
                List<Integer> result = map.get(idx);
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(i);
                map.put(idx, result);
            }
        }
//        System.out.println(map);
        char[] chars = searchWord.toCharArray();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String idx = new String(chars, 0, i + 1);
            List<Integer> integers = map.get(idx);
            if (integers == null) {
                for (int j = i; j < chars.length; j++) {
                    result.add(new ArrayList<>());
                }
                break;
            } else {
                List<String> search = new ArrayList<>(3);
                for (int i1 = 0; i1 < integers.size() && i1 < 3; i1++) {
                    search.add(products[integers.get(i1)]);
                }
                result.add(search);
            }
        }
        return result;
    }


    private int cnt = 0;

    private void dfs(int left, int right, int mid, int step, int max) {
        if (left > right || left > max || left > step || right > step || right > max) {
            return;
        }
        if (left + right + mid == step) {
            if (left == right) {
                cnt++;
            }
            return;
        }
        dfs(left + 1, right, mid, step, max);
        dfs(left, right + 1, mid, step, max);
        dfs(left, right, mid + 1, step, max);
    }

    public int numWays(int steps, int arrLen) {
        cnt = 0;
        dfs(0, 0, 0, steps, arrLen);
        return cnt;
    }

    @Test
    public void test01() {
        System.out.println(minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
        System.out.println(minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }

    @Test
    public void test02() {
        System.out.println(countServers(new int[][]{{1, 0}, {1, 1}}));
        System.out.println(countServers(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
    }

    @Test
    public void test03() {
        System.out.println(suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println(suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "tatiana"));
    }

    @Test
    public void test04() {
        System.out.println(numWays(3, 2));
        System.out.println(numWays(2, 4));
        System.out.println(numWays(4, 2));
    }
}
