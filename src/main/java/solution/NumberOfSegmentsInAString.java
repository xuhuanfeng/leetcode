package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-11 19:52
 * @see <a href="https://leetcode.com/problems/number-of-segments-in-a-string/">434. Number of Segments in a String</a>
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int cnt = 0;
        String[] data = s.split(" ");
        for (String datum : data) {
            if (datum != null && datum.length() > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
