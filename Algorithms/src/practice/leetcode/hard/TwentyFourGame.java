package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @math
 * @dfs You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated
 * through *, /, +, -, (, ) to get the value of 24.
 *
 * dfs try all different combinations of 4 operators
 * initially, we have 4 numbers in the array
 * use list to store, put, remove
 * start with 4 initial numbers in the list, get 0 and 1, 0 and 2, 0 and 3
 * get these two numbers, calculate all the possible results + - * / for division, check 0
 * remove the two numbers we pick, and add each to the calculated results (need a new list to store)
 * add to list
 * after recursive call, add it back
 *
 * the reason to use epsilon is because when we get the result with recurring decimal:
 * input array is {3,3,8,8}
 * -> 8/3=2.6666...
 * -> 3 - 8/3 = 0.333...
 * -> 8/0.333=23.999...
 */
public class TwentyFourGame {
    double eps = 0.001;
    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for (int n : nums) arr.add((double) n);
        return dfs(arr);
    }

    private boolean dfs(List<Double> arr) {
        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < eps) return true;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < arr.size(); k++) {
                    if (k != i && k != j) next.add(arr.get(k));
                }
                for (double c : computeTwoNums(arr.get(i), arr.get(j))) {
                    next.add(c);
                    if (dfs(next)) return true;
                    else next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> computeTwoNums(Double a, Double b) {
        return new ArrayList<>(Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a));
    }

    public static void main(String[] args) {
        Double result = (double) 8 / 3;
        System.out.println(result);
        result = 3 - result;
        System.out.println(result);
        result = 8 / result;
        System.out.println(result);

        TwentyFourGame tg = new TwentyFourGame();
        int[] in = new int[]{3,3,8,8};
        System.out.println(tg.judgePoint24(in));
    }
}
