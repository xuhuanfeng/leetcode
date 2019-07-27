package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-27 7:34
 * @see <a href="https://leetcode.com/problems/largest-triangle-area/">812. Largest Triangle Area</a>
 */
public class LargestTriangleArea {
    /**
     * 一开始想出来用暴力法计算，然后忘记了海伦公式，囧...
     * 看了官方的答案，采用的是鞋带公式，好厉害...
     *
     * @param points 点
     * @return 最大面积
     */
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double area(int[] a, int[] b, int[] c) {
        int area = a[0] * b[1] + b[0] * c[1] + c[0] * a[1] -
                (a[1] * b[0] + b[1] * c[0] + c[1] * a[0]);
        return 0.5 * Math.abs(area);
    }

    @Test
    public void test01() {
        System.out.println(largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }
}
