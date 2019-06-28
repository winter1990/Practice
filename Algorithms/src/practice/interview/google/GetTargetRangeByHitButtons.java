package practice.interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 有一系列按钮，每个按钮按下去会得到一定体积范围的可乐。先给定一个目标体积范围，问不限制按按钮次数，能否确定一定能得到目标范围内的可乐？
 *
 * 举例：有三个按钮，按下去得到的范围是[100, 120], [200, 240], [400, 410],
 * 假设目标是[100, 110], 那答案是不能。因为按下一，可能得到120体积的可乐，不在目标范围里。
 * 假设目标是[90, 120]，那答案是可以。因为按下一，一定可以得到此范围内的可乐。
 * 假设目标是[300, 360], 那答案是可以，因为按下一再按二，一定可以得到此范围内
 * 假设目标是[310, 360], 那答案是不能，因为按下一再按二，有可能得到300，永远没可能确定得到这个范围内的可乐。
 *
 *
 */
public class GetTargetRangeByHitButtons {
    public boolean canReach(int[][] buttons, int[] target) {
        Map<String, Boolean> map = new HashMap<>();
        return dfs(buttons, 0, 0, target, map);
    }

    private boolean dfs(int[][] ranges, int lo, int hi, int[] target, Map<String, Boolean> map) {
        Boolean isVisited = map.get(lo + " " + hi);
        if (isVisited != null) {
            return isVisited;
        }
        if (hi > target[1]) return false;
        if (lo >= target[0] && hi <= target[1]) return true;
        for (int[] range : ranges) {
            if (dfs(ranges, lo + range[0], hi + range[1], target, map)) {
                map.put(lo + " " + hi, true);
                return true;
            }
        }
        map.put(lo + " " + hi, false);
        return false;
    }

    public boolean canReachTarget(int[][] buttons, int[] target) {
        int m = target[0], n = target[1]; // [m n]
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int[] range : buttons) {
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (range[0] >= i && range[1] <= j) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        for (int[] range : buttons) {
            for (int i = 0; i <= m; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (i >= range[0] && j >= range[1]) {
                        if (dp[i - range[0]][j - range[1]]) dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] in = {{110, 125}, {200, 240}, {400, 410}};
        int[] target = {700, 785};
        GetTargetRangeByHitButtons g = new GetTargetRangeByHitButtons();
        System.out.println(g.canReach(in, target));
        System.out.println(g.canReachTarget(in, target));
    }
}
