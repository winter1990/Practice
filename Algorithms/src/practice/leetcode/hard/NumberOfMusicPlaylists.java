package practice.leetcode.hard;

/**
 * @dp
 *
 * Your music player contains N different songs and wants to listen to L songs during your trip.
 * You create a playlist so that:
 * Every song is played at least once
 * A song can only be played again only if K other songs have been played
 * Return the number of possible playlists.
 * 0 <= K < N <= L <= 100
 *
 * dp[i][j] is number of possible playlists with total i songs, with j different songs -> result = dp[L][N]
 * i - total
 * j - different
 * when choosing the next song:
 * case 1 - new song -> (i-1) total songs, (j-1) different songs, number of choices of current N-(j-1)
 * case 2 - old one -> (i-1) total songs, j different songs
 *   without K limitation: dp[i][j] = dp[i-1][j-1] * (N-(j-1)) + dp[i-1][j] * j
 *   with K limitation:
 *     number of choices is (j-k)
 *     j > k does not affect
 *     j <= k 0, because we have to choose a new song
 */
public class NumberOfMusicPlaylists {
    public int numMusicPlaylists(int N, int L, int K) {
        int m = (int) Math.pow(10, 9) + 7;
        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (N - (j - 1))) % m;
                if (j > K) {
                    dp[i][j] += (dp[i - 1][j] * (j - K)) % m;
                    dp[i][j] %= m;
                }
            }
        }
        return (int) dp[L][N];
    }
}
