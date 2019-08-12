package solution;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 10:49
 * @see <a href="https://leetcode.com/problems/rectangle-overlap/">836. Rectangle Overlap</a>
 */
public class RectangleOverlap {
    // 没有做出来，一直在纠结重叠部分如何计算，囧....
    // 实际上只需要不重叠取反就可以
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
}
