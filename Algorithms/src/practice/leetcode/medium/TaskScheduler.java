package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 * @greedy
 *
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * return the least number of intervals the CPU will take to finish all the given tasks
 *
 * AAABBB, 2 -> AB.AB.AB    the dot means idle status
 * AAABBC, 2 -> ABCAB.A
 * AAABBCD, 2 -> ABCABDA
 * AAABBBCCDD, 2 -> ABCDABCABD
 *
 * two scenarios:
 *   1. result has idle status
 *   2. result not has idle status
 * X...X...X...X...X..
 *  |n| |n|...      |other... [0,n-1]
 *
 * to determine whether there is any idle status in the result
 *   depends on the task with highest frequency
 *   if there is at least 0 idles, size of the frame is (#ofHighestFreqElements-1)*(N+1)+#ofHighestFreqElements
 *   if there is no idle status, size of the frame is number of total tasks
 * get the frequency for each task
 *   count the number of tasks with highest frequency
 *   use array to count
 *   sort and get the last elements with same value
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) count[task - 'A']++;
        Arrays.sort(count);
        int i = 25;
        while (i >= 0 && count[i] == count[25]) i--;
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }

    /**
     * method 2
     * 3A2B1C, n = 2
     * start from the highest frequency element
     * [A..A..A], after arranging all the As, we consider B using the same method
     * [AB.AB.A]
     * [ABCAB.A]
     *
     * 3A3B3C3D, n = 2
     * ABCDABCDABCD
     * using greedy thinking to arrange the highest freq first, then second...
     */
    public int leastInterval1(char[] tasks, int n) {
        int[] count = new int[26];
        int maxFreq = 0;
        int maxCount = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            if (count[task - 'A'] == maxFreq) {
                maxCount++;
            } else if (count[task - 'A'] > maxFreq) {
                maxFreq = count[task - 'A'];
                maxCount = 1;
            }
        }
        int blockCount = maxFreq - 1;
        int blockLength = n - maxCount + 1;
        int emptySlots = blockCount * blockLength;
        int remainingTasks = tasks.length - maxFreq * maxCount;
        int idleCount = Math.max(0, emptySlots - remainingTasks);
        return idleCount + tasks.length;
    }
}