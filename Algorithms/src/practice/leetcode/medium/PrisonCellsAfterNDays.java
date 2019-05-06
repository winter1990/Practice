package practice.leetcode.medium;

import java.util.*;

/**
 * @array
 *
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 *
 * all possible combinations - 2^n
 * there are finite number of combinations, so there must be some loop exists - some subsequence is repeated
 *
 * start with some example
 * 0, 1, 0, 1, 1, 0, 0, 1  day 0
 * 0, 1, 1, 0, 0, 0, 0, 0  day 1
 * 0, 0, 0, 0, 1, 1, 1, 0 -> from here, we can determine that since day 1, first and last cells will always be empty
 * 0, 1, 1, 0, 0, 1, 0, 0
 * 0, 0, 0, 0, 0, 1, 0, 0
 * 0  1  1  1  0  1  0  0
 * 0  0  1  0  1  1  0  0
 * 0  0  1  1  0  0  0  0 -> day 7
 * 0  0  0  0  0  1  1  0
 * 0  1  1  1  0  0  0  0
 * 0  0  1  0  0  1  1  0
 * 0  0  1  0  0  0  0  0
 * 0  0  1  0  1  1  1  0 -> day 12
 * 0  0  1  1  0  1  0  0
 * 0  0  0  0  1  1  0  0
 * 0  1  1  0  0  0  0  0 -> day 15
 * 14 days is a cycle for this case
 *
 * convert the array to string, put in the map and track the day of the status
 * while n>=1
 *   map(str,n), n--
 *   get the status for next loop
 *   if map already contains the new string
 *     the original array may not be in the circle - because the circle always starts and ends with 0
 *     we need to count the actual circle size instead of the size of set/map
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        for (int i = 1; i <= N; i++) {
            int[] next = getNextState(cells);
            String key = Arrays.toString(next);
            if (!set.contains(key)) {
                set.add(key);
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if (hasCycle) {
            N %= set.size();
            for (int i = 0; i < N; i++) cells = getNextState(cells);
        }
        return cells;
    }

    private int[] getNextState(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i <= 6; i++) next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        return next;
    }

    public int[] prisonAfterNDays1(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N >= 1) {
            int[] tmp = new int[8];
            map.put(Arrays.toString(cells), N);
            N--;
            for (int i = 1; i <= 6; i++) tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            if (map.containsKey(Arrays.toString(tmp))) N %= (map.get(Arrays.toString(tmp)) - N);
            cells = tmp;
        }
        return cells;
    }

    public static void main(String[] args) {
        PrisonCellsAfterNDays p = new PrisonCellsAfterNDays();
        int[] in = {0, 1, 0, 1, 1, 0, 0, 1};
        int n = 2;
        int[] r0 = p.prisonAfterNDays(in,n);
        int[] r1 = p.prisonAfterNDays1(in,n);
        for (int i : r0) System.out.print(i);
        System.out.println();
        for (int i : r1) System.out.print(i);
    }
}
