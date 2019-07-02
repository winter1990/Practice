package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @array
 *
 * Given a list of scores of different students, return the average score of each student's top five scores in the
 * order of each student's id.
 *
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.
 * The average score is calculated using integer division.
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int minId = Integer.MAX_VALUE, maxId = Integer.MIN_VALUE;
        for (int [] i : items) {
            minId = Math.min(minId, i[0]);
            maxId = Math.max(maxId, i[0]);
            if (!map.containsKey(i[0])) map.put(i[0], new PriorityQueue<>());
            map.get(i[0]).offer(i[1]);
            if (map.get(i[0]).size() > 5) map.get(i[0]).poll();
        }
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (int id = minId; id <= maxId; id++) {
            if (map.containsKey(id)) {
                res[index][0] = id;
                res[index][1] = getScore(map.get(id));
                index++;
            }
        }
        return res;
    }

    private int getScore(PriorityQueue<Integer> q) {
        int sum = 0;
        while (!q.isEmpty()) sum += q.poll();
        return sum / 5;
    }
}
