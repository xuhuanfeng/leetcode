package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-07-15 20:48
 * @see <a href="https://leetcode.com/problems/find-common-characters/">1002. Find Common Characters</a>
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[][] counter = new int[101][30];
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (char c : A[i].toCharArray()) {
                counter[i][c - 'a']++;
            }
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int tMin = counter[0][i];
            for (int i1 = 0; i1 < len; i1++) {
                tMin = Math.min(tMin, counter[i1][i]);
            }
            if (tMin > 0) {
                String str = String.valueOf((char)(i + 'a'));
                while (tMin-- > 0) {
                    result.add(str);
                }
            }
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(commonChars(new String[] {"bella","label","roller"}));
        System.out.println(commonChars(new String[] {"cool","lock","cook"}));
    }
}
