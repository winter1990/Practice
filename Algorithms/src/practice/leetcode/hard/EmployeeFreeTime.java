package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @array
 *
 * We are given a list schedule of employees, which represents the working time for each employee.
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 * Return the list of finite intervals representing common, positive-length free time for all employees,
 * also in sorted order.
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]], Output: [[3,4]]
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]], Output: [[5,6],[7,9]]
 */
public class EmployeeFreeTime {
    public int[][] employeeFreeTime(int[][][] schedule) {
        List<int[]> time = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[][] s1 : schedule) {
            for (int[] s2 : s1) {
                time.add(s2);
            }
        }
        Collections.sort(time, (i1, i2) -> (i1[0] - i2[0]));
        int pre = time.get(0)[1];
        for (int i = 1; i < time.size(); i++) {
            int[] cur = time.get(i);
            if (cur[0] > pre) {
                res.add(new int[]{pre, cur[0]});
            }
            pre = Math.max(pre, cur[1]);
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][][] in = {{{1,2},{5,6}},{{1,3}},{{4,10}}};
        EmployeeFreeTime e = new EmployeeFreeTime();
        e.employeeFreeTime(in);
    }
}
