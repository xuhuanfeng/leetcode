package solution;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 11:53
 * @see <a href="https://leetcode.com/contest/weekly-contest-153/problems/distance-between-bus-stops/">5181. Distance Between Bus Stops</a>
 */
public class DistanceBetweenBusStops {
    // 很简单的一个题目，先求个总和，在求顺序的，逆序的就等于总的-顺序的，一开始相复杂了，囧。。。
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;

        if (start > destination) {
            int tmp = destination;
            destination = start;
            start = tmp;
        }

        int[] leftSum = new int[distance.length + 1];
        for (int i = 0; i < distance.length; i++) {
            leftSum[i + 1] = leftSum[i] + distance[i];
            sum += distance[i];
        }

        int left = leftSum[destination] - leftSum[start];

        return Math.min(left, sum - left);
    }
}
