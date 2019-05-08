package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @search
 * @graph
 * @sort
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
        int[] degree = new int[numCourses], res = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                res[index++] = i;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (--degree[nei] == 0) {
                    q.offer(nei);
                    res[index++] = nei;
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        int[][] in = {{1,0},{2,1}};
        CourseSchedule_II cs = new CourseSchedule_II();
        cs.findOrder(3, in);
    }
}
