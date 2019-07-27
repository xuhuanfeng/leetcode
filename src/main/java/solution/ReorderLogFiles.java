package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author huanfeng.xu
 * @date 2019-07-27 8:28
 * @see <a href="https://leetcode.com/problems/reorder-log-files/">937. Reorder Log Files</a>
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        String[] digit = new String[logs.length];
        int digitIndex = 0;
        int resultIndex = 0;
        for (String log : logs) {
            String tmp = log.split(" ")[1];
            if (Character.isAlphabetic(tmp.charAt(0))) {
                result[resultIndex++] = log;
            } else {
                digit[digitIndex++] = log;
            }
        }
        Arrays.sort(result, 0, resultIndex, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int str1Index = o1.indexOf(" ");
                int str2Index = o2.indexOf(" ");

                String str1 = o1.substring(str1Index);
                String str2 = o2.substring(str2Index);

                String str1Iden = o1.substring(0, str1Index);
                String str2Iden = o2.substring(0, str2Index);
                int cmpResult = str1.compareTo(str2);
                return cmpResult == 0 ? str1Iden.compareTo(str2Iden) : cmpResult;
            }
        });
        for (int i = 0; i < digitIndex; i++) {
            result[resultIndex++] = digit[i];
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"})));
        ;
    }
}
