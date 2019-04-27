package practice.leetcode.easy;

/**
 * @graph
 *
 * If the town judge exists, then:
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * 3. There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person
 * labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 * problems to solve:
 * 1. build the graph - directed
 * 2. find the person that satisfies both conditions
 */
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] graph = new int[N + 1];
        for (int[] p : trust) {
            graph[p[0]]--;
            graph[p[1]]++;
        }
        int judge = -1;
        for (int i = 1; i <= N; i++) {
            if (graph[i] == N - 1) {
                if (judge == -1) {
                    judge = i;
                } else {
                    return -1;
                }
            }
        }
        return judge;
    }
}
