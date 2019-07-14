package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 15:22
 * @see <a href="https://leetcode.com/problems/relative-sort-array/">1122. Relative Sort Array</a>
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] data = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            for (int i1 = 0; i1 < arr1.length; i1++) {
                if (arr1[i1] == i) {
                    data[index++] = arr1[i1];
                    arr1[i1] = -1;
                }
            }
        }
        Arrays.sort(arr1);
        for (int i1 : arr1) {
            if (i1 != -1) {
                data[index++] = i1;
            }
        }
        return data;
    }

    public int[] another(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int[] cnt = new int[1001];
        for (int i : arr1) {
            cnt[i]++;
        }

        int index = 0;
        for (int i : arr2) {
            while (cnt[i]-- > 0) {
                ans[index++] = i;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (cnt[i]-- > 0) {
                ans[index++] = i;
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println(Arrays.toString(relativeSortArray(new int[]{28, 6, 22, 8, 44, 17},
                new int[]{22, 28, 8, 6})));
    }

    @Test
    public void test02() {
        System.out.println(Arrays.toString(another(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println(Arrays.toString(another(new int[]{28, 6, 22, 8, 44, 17},
                new int[]{22, 28, 8, 6})));
    }
}
