package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @search
 * @graph
 * @sort
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take
 * to finish all courses.
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 */
public class CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] degree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] pre : prerequisites) {
            degree[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) res[index++] = i;
        }
        if (index == 0) return new int[]{};

        int k = 0;
        List<Integer> list;
        while (index < numCourses) {
            list = graph[res[k++]];
            for (int c : list) {
                if (--degree[c] == 0) res[index++] = c;
            }
            if (k == index) return new int[]{};
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = {{1,0},{2,1}};
        CourseSchedule_II cs = new CourseSchedule_II();
        cs.findOrder(3, in);
    }


    int N = 0;
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i], result)) {
                return new int[0];
            }
        }
        return result;
    }

    private boolean isCyclic(Course cur, int[] result) {
        if (cur.tested == true) {
            return false;
        }
        if (cur.visited == true) {
            return true;
        }
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c, result)) {
                return true;
            }
        }
        cur.tested = true;
        result[N++] = cur.number;
        return false;
    }

    class Course {
        boolean visited = false;
        boolean tested = false;
        int number;
        List<Course> pre = new ArrayList<Course>();
        public Course(int i) {
            number = i;
        }
        public void add(Course c) {
            pre.add(c);
        }
    }
}
