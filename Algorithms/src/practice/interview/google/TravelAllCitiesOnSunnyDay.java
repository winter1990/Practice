package practice.interview.google;

/**
 * 问的是如果要去N个城市按顺序旅游，最多有M天，每个城市必须至少呆一天，而且必须那几天是晴天，
 * 已知每个城市每天的天气，请问能不能在M天之内旅游完
 *
 * n = 3
 * m = 4
 *
 * t f t f
 * f f t t
 * f f f t
 *
 * isSunny[m][n]
 * m > n
 *
 *
 */
public class TravelAllCitiesOnSunnyDay {
    public boolean canVisitAll(int n, int m, boolean[][] isSunny) {
        boolean[][] dp = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = isSunny[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < m; j++) {
                if ((dp[i - 1][j - 1] && isSunny[i][j]) || dp[i][j - 1]) dp[i][j] = true;
            }
        }
        for (int j = m - 1; j >= 0; j--) {
            if (dp[n - 1][j]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] weather = {
                {true, false, false, false, false, true,  false},
                {true,  true, false,true,   true,  true , false},
                {false, true, true, false,  true,  true,  false},
                {false, false,true, true,   true,  false, true},
        };
        TravelAllCitiesOnSunnyDay t = new TravelAllCitiesOnSunnyDay();
        System.out.println(t.canVisitAll(weather.length,weather[0].length,weather));
    }
}
