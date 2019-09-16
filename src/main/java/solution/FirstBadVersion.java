package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-16 20:35
 * @see <a href="https://leetcode.com/problems/first-bad-version/">278. First Bad Version</a>
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + ((end - start) >>> 1);
            boolean preVersion = isBadVersion(mid - 1);
            boolean currentVersion = isBadVersion(mid);
            boolean nextVersion = isBadVersion(mid + 1);

            if ((mid == 1 || mid == n) && currentVersion) {
                return mid;
            }

            if (!preVersion && currentVersion && nextVersion) {
                return mid;
            } else if (!preVersion && !currentVersion && nextVersion) {
                return mid + 1;
            } else if (!preVersion && !currentVersion) {
                start = mid + 2;
            } else {
                end = mid - 2;
            }
            // System.out.println(mid);
        }
        return start;
    }

    public int betterOne(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // mid是badVersion，直接抛弃mid之后的内容
            // 此时mid可能是第一个，可能不是，所以其后面的内容已经不重要了
            // 相当于在剩下的部分中找bad，由于最后会收敛到start > end，所以成立
            // 大佬们真厉害
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    boolean isBadVersion(int version) {
        // return true;
        // return version == 2147483647;
        return version >= 1150769282;
        // return version >= 1;
    }

    @Test
    public void test01() {
        // assertEquals(2147483647, firstBadVersion(2147483647));
        assertEquals(1150769282, firstBadVersion(1420736637));
        // assertEquals(1, firstBadVersion(3));
    }
}
