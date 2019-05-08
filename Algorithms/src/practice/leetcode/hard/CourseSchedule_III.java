package practice.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/***
 * @search
 * @sort
 * @greedy
 *
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and
 * closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day.
 * You will start at the 1st day.
 *
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses can be taken.
 *
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 * [100 100] [20 101] [30 102]
 *
 * use a priority queue to track the time+deadline+numberOfCourses
 *
 */
public class CourseSchedule_III {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) return 0;
        Arrays.sort(courses, (i1, i2) -> (i1[1] - i2[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int t = 0;
        for (int[] c : courses) {
            t += c[0];
            pq.offer(t);
            if (t > c[1]) t -= pq.poll();
        }
        return pq.size();
    }

    public static void main(String[] args) {
//        int[][] in = new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}};
//        int[][] in = new int[][]{{5,5},{4,6},{2,6}};
        int[][] in = new int[][]{{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}};
        CourseSchedule_III c = new CourseSchedule_III();
        System.out.println(c.scheduleCourse(in));
    }
}
