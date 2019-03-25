package practice.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 *
 * how many possible combinations there might be -> 2^n -> so there must be some loop exists
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
 * convert the array to string, put in the map and track the day of the string
 * N loops -> index from [1, 6] -> generate the string -> check in the map -> if containsKey,
 * N = 53, 10 days per loop, at 11th day, see the key in map N = 44
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        while (N > 0) {
            int[] tmp = new int[8];
            map.put(Arrays.toString(cells), N--);
            for (int i = 1; i <= 6; i++) tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = tmp;
            if (map.containsKey(Arrays.toString(cells))) N %= (map.get(Arrays.toString(cells)) - N);
        }
        return cells;
    }
}
