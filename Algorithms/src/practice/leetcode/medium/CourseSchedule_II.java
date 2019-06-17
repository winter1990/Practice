package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @search
 * @graph
 * @topological
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take
 * to finish all courses.
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * problems to solve:
 * 1. build up the (directed) graph/relationship of the dependencies between courses
 * 2. solve and remove the dependencies
 *
 * [a, b] [c, b]
 * find the courses with no dependency with any other course, remove them from the graph
 * need to keep track of all dependencies and after removing the ones with no dependency, check the next level
 *
 */
public class CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] p : prerequisites) {
            degree[p[0]]++;
            graph[p[1]].add(p[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) q.offer(i);
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            res[i++] = c;
            for (int next : graph[c]) {
                if (--degree[next] == 0) q.offer(next);
            }
        }
        return i == numCourses ? res : new int[]{};
    }

    public static void main(String[] args) {
        int[][] in = {{1,0},{2,1}};
        CourseSchedule_II cs = new CourseSchedule_II();
        cs.findOrder(3, in);
    }
}
