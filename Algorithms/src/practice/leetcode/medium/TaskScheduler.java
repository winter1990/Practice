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
 * method 1
 * greedy thinking, the highest frequency number determines how many interval there are in the result
 * start highest freq number(s)then insert less freq in the empty slots or the tail
 * AAAABBBEEFFGG 3
 * A...A...A...A
 * AB..AB..AB..A
 * ABE.ABE.AB..A
 * ABEFABE.ABF.A start with third AB
 * ABEFABEGABFGA
 *
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int i = 25;
        while (i >= 0 && count[i] == count[25]) {
            i--;
        }
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }

    /**
     * method 2
     * 3A2B1C, n = 2
     * start from the highest frequency element
     * [A..A..A], after arranging all the As, we consider B using the same method
     * [AB.AB.A]
     * [ABCAB_A]
     *
     * 3A3B3C3D, n = 2
     * ABCDABCDABCD
     * using greedy thinking to arrange the highest freq first, then second...
     * now we need to count the total number of idle slots
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
        int intervalCount = maxFreq - 1;
        int intervalLength = n - maxCount + 1;
        int emptySlots = intervalCount * intervalLength;
        int remainingTasks = tasks.length - maxFreq * maxCount;
        int idleCount = Math.max(0, emptySlots - remainingTasks);
        return idleCount + tasks.length;
    }
}