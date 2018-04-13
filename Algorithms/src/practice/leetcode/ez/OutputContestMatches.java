package practice.leetcode.ez;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 *
 * Input: 8
 * Output: (((1,8),(4,5)),((2,7),(3,6)))
 * Explanation:
 * First round: (1,8),(2,7),(3,6),(4,5)
 * Second round: ((1,8),(4,5)),((2,7),(3,6))
 * Third round: (((1,8),(4,5)),((2,7),(3,6)))
 */
public class OutputContestMatches {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(Integer.toString(i));
        }
        while (list.size() != 1) {
            List<String> tmp = new ArrayList<>();
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                tmp.add("(" + list.get(left) + "," + list.get(right) + ")");
                left++;
                right--;
            }
            list = tmp;
        }
        return list.get(0);
    }


    /**
     *                18452736
     *              /         \
     *         1845            2736
     *        /   \           /    \
     *     18      45      27      36
     *     /\      /\      /\      /\
     *   1   8   4   5   2   7   3   6
     */
    public String findContestsMatch1(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.toString(i + 1);
        }
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                arr[i] = "(" + arr[i] + "," + arr[n - 1 - i] + ")";
            }
            n /= 2;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        int n = 4;
        OutputContestMatches o = new OutputContestMatches();
        System.out.println(o.findContestMatch(n));
    }
}
