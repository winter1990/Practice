package practice.leetcode.medium;

import java.util.*;

/**
 * @dfs
 * @bfs
 * @graph
 * @topological
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * Input: 2, [[1,0],[0,1]], Output: false
 * one course may depend on one or multiple courses
 * total courses [0, n - 1]
 *
 * problems to solve:
 * 1. schedule a sequence of tasks based on the dependencies
 * 2. build up the relationship between the courses/prerequisites
 *
 * build the graph first
 *   map - course id is key, values is a list/set as multiple courses may depend on the same course
 *   an array of list List[] is also feasible, as course is [0,n-1]
 * start with the courses that have no dependency
 *   use an array to store the depth of the courses
 *   degree[], if i depends on j, degree[i]++
 *   so we can start from the degree of 0, means no dependency
 * bfs courses
 *   poll() from queue, which means we finish the course
 *   update the degree - update all the courses that depend on this course
 *   if the degree becomes 0, add to queue
 * handle the circle
 *   [a b][b c][c a] all have degree 1, so we will not start from any of them
 */
public class CourseSchedule {
    // topological sort (BFS thinking)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            degree[p[0]]++;
            map.computeIfAbsent(p[1], s -> new HashSet<>()).add(p[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            if (map.get(cur) == null) continue;
            for (int next : map.get(cur)) {
                if (--degree[next] == 0) q.offer(next);
            }
        }
        return count == numCourses;
    }

    /**
     * if we draw the graph:
     * [0 1] [0 2] [1 3] [2 3] [3 4]
     *
     *   /-> 1 -> 3 -> 4
     *  0         /
     *   \-> 2 --
     * 0, empty
     * 1, 0
     * 2, 0
     * 3, 1 2
     * 4, 3
     *
     * This problem is equivalent to finding if a cycle exists in a directed graph.
     * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishCourse(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinishCourse(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false;
        }
        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!canFinishCourse(graph, visited, (int) graph[course].get(i))) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }

    /**
     * @dfs
     */
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, dp)) return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp) {
        if (visited[course]) {
            return dp[course];
        } else {
            visited[course] = true;
        }
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i), dp)) {
                dp[course] = false;
                return false;
            }
        }

        dp[course] = true;
        return true;
    }


}
