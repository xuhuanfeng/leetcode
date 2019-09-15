package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 8:16
 * @see <a href="https://leetcode.com/problems/walking-robot-simulation/">874. Walking Robot Simulation</a>
 */
public class WalkingRobotSimulation {
    // 模拟题，简单，但是没有考虑到两种情况，wa了两次，囧....
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            List<Integer> xList = xMap.getOrDefault(obstacle[0], new ArrayList<>());
            List<Integer> yList = yMap.getOrDefault(obstacle[1], new ArrayList<>());
            xList.add(obstacle[1]);
            yList.add(obstacle[0]);

            xMap.put(obstacle[0], xList);
            yMap.put(obstacle[1], yList);
        }

        for (List<Integer> list : xMap.values()) {
            list.sort(Integer::compareTo);
        }

        for (List<Integer> list : yMap.values()) {
            list.sort(Integer::compareTo);
        }

//        System.out.println(xMap);
//        System.out.println(yMap);
//        System.out.println("==========================");

        int direction = 0;

        int maxDis = 0;
        int tX = 0, tY = 0;

        for (int command : commands) {
            if (command == -1) {
                // right
                direction++;
                direction %= 4;
            } else if (command == -2) {
                // left
                direction += 3;
                direction %= 4;
            } else {
                int tmpX = tX;
                int tmpY = tY;
                switch (direction) {
                    case 0:
                        tmpY += command;
                        break;
                    case 1:
                        tmpX += command;
                        break;
                    case 2:
                        tmpY -= command;
                        break;
                    case 3:
                        tmpX -= command;
                        break;
                    default:
                        break;
                }

//                System.out.println("tx: " + tX + " tmpX: " + tmpX + "  ty: " + tY + " tmpY: " + tmpY);

                if (direction == 0 || direction == 2) {
                    List<Integer> xList = xMap.get(tX);
                    if (xList != null) {
                        for (int val : xList) {
                            if (val > tY && val <= tmpY) {
                                tmpY = val - 1;
                                break;
                            }
                            if (val < tY && val >= tmpY) {
                                tmpY = val + 1;
                                break;
                            }
                        }
                    }
                    tY = tmpY;
                }
//                System.out.println();
                if (direction == 1 || direction == 3) {
                    List<Integer> yList = yMap.get(tY);
                    if (yList != null) {
                        for (int val : yList) {
                            if (val > tX && val <= tmpX) {
                                tmpX = val - 1;
                                break;
                            }
                            if (val < tX && val >= tmpX) {
                                tmpX = val + 1;
                                break;
                            }
                        }
                    }
                    tX = tmpX;
                }

//                System.out.println("tx: " + tX + " ty: " + tY);

                int dis = tX * tX + tY * tY;
                if (dis > maxDis) {
                    maxDis = dis;
                }
            }
        }
        return maxDis;
    }

    @Test
    public void test01() {
        assertEquals(25, robotSim(new int[]{4, -1, 3}, new int[][]{}));
        assertEquals(65, robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
        assertEquals(324, robotSim(new int[]{-2, 8, 3, 7, -1},
                new int[][]{{-4, -1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}}));
        assertEquals(4, robotSim(new int[]{7, -2, -2, 7, 5}
                , new int[][]{{-3, 2}, {-2, 1}, {0, 1}, {-2, 4}, {-1, 0}, {-2, -3}, {0, -3}, {4, 4}, {-3, 3}, {2, 2}}));
    }
}
