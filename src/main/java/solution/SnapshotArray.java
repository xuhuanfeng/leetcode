package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 11:16
 * @see <a href="https://leetcode.com/contest/weekly-contest-148/problems/snapshot-array/">1146. Snapshot Array</a>
 */
public class SnapshotArray {

    Map<Integer, Map<Integer, Integer>> shot = new HashMap<>();
    int snapId = 0;

    int[] data;
    Map<Integer, Integer> change;

    public SnapshotArray(int length) {
        data = new int[length];
        change = new HashMap<>();
    }

    public void set(int index, int val) {
        data[index] = val;
        change.put(index, val);
    }

    public int snap() {
        shot.put(snapId, change);
        change = new HashMap<>();
        return snapId++;
    }

    public int get(int index, int snap_id) {
        int id = snap_id;
        while (id >= 0) {
            Map<Integer, Integer> snapShot = shot.get(id);
            if (snapShot != null) {
                Integer val = snapShot.get(index);
                if (val != null) {
                    return val;
                }
            }
            id--;
        }
        return 0;
    }

    public static void main(String[] args) {
        /*SnapshotArray snapshotArr = new SnapshotArray(4);
        System.out.println(snapshotArr.snap());
        System.out.println(snapshotArr.snap());
        System.out.println(snapshotArr.get(3, 1));
        snapshotArr.set(2, 4);
        System.out.println(snapshotArr.snap());
        snapshotArr.set(1, 4);*/

        SnapshotArray snapshotArray = new SnapshotArray(2);
        snapshotArray.set(0, 12);
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.get(1, 0));
        System.out.println(snapshotArray.get(1, 0));
        System.out.println(snapshotArray.snap());
        System.out.println(snapshotArray.snap());
    }
}
