package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * one course depends on multiple
 * where to start the search: 0 dependency
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] dependency = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            dependency[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        int count = 0;
        for (int i = 0; i < dependency.length; i++) {
            if (dependency[i] == 0) {
                queue.offer(i);
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int index = (int)graph[course].get(i);
                dependency[index]--;
                if (dependency[index] == 0) {
                    queue.offer(index);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
