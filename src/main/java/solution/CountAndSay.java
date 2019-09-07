package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 7:39
 * @see <a href="https://leetcode.com/problems/count-and-say/">38. Count and Say</a>
 */
public class CountAndSay {
    public String countAndSay(int n) {
        List<Integer> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        while (n > 1) {
            int tCnt = 1;
            int tSize = tmp.size();
            for (int i = 0; i < tSize; i++) {
                if (i + 1 < tSize && (tmp.get(i) == tmp.get(i + 1))) {
                    tCnt++;
                } else {
                    list.add(tCnt);
                    list.add(tmp.get(i));
                    tCnt = 1;
                }
            }
            tmp = list;
            list = new ArrayList<>();
            n--;
        }
        StringBuilder builder = new StringBuilder();
        for (Integer integer : tmp) {
            builder.append(integer);
        }
        return builder.toString();
    }

    @Test
    public void test01() {
        assertEquals("1", countAndSay(1));
        assertEquals("11", countAndSay(2));
        assertEquals("21", countAndSay(3));
        assertEquals("111221", countAndSay(5));
    }
}
