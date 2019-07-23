package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author huanfeng.xu
 * @date 2019-07-23 23:02
 * @see <a href="https://leetcode.com/problems/duplicate-zeros/">1089. Duplicate Zeros</a>
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        Stack<Integer> zeroIndex = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroIndex.push(i);
            }
        }
        while (!zeroIndex.isEmpty()) {
            if (zeroIndex.peek() + zeroIndex.size() >= arr.length) {
                zeroIndex.pop();
            } else {
                break;
            }
        }

        if (zeroIndex.isEmpty()) {
            return;
        }

        int startIndex = arr.length - 1 - zeroIndex.size();
        int endIndex = arr.length - 1;
        do {
            if (startIndex == zeroIndex.peek()) {
                arr[endIndex--] = 0;
                zeroIndex.pop();
            }
            arr[endIndex--] = arr[startIndex--];
        } while (startIndex >= 0 && !zeroIndex.isEmpty());
    }

    @Test
    public void test01() {
        int[] data = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        System.out.println(Arrays.toString(data));
        duplicateZeros(data);
        System.out.println(Arrays.toString(data));
        data = new int[]{1, 2, 4};
        duplicateZeros(data);
        System.out.println(Arrays.toString(data));
        data = new int[]{0, 1, 7, 6, 0, 2, 0, 7};
        duplicateZeros(data);
        System.out.println(Arrays.toString(data));
        data = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
        duplicateZeros(data);
        System.out.println(Arrays.toString(data));
    }
}
