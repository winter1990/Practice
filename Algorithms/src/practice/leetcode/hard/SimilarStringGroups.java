package practice.leetcode.hard;

import java.util.*;

import static java.util.stream.IntStream.range;

/**
 * @string
 * @bfs
 * @graph
 *
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 * We are given a list A of strings.
 * Every string in A is an anagram of every other string in A.
 * How many groups are there?
 *
 * Input: ["tars","rats","arts","star"], Output: 2
 * [rats arts tars] [star]
 *
 * problems to solve:
 * 1. compare a pair of strings -> swap only once
 * 2. group the strings
 *
 * brute force:
 * bfs - for each word, compare with all other strings in the list, if diff is 2
 * start with first string to last
 *   check if already grouped
 */
public class SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        int res = 0, n = A.length, m = A[0].length();
        boolean[] isVisited = new boolean[n];
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            res++;
            q.offer(A[i]);
            while (!q.isEmpty()) {
                String s = q.poll();
                for (int j = 0; j < n; j++) {
                    if (isVisited[j]) continue;
                    int diff = 0;
                    for (int k = 0; k < m; k++) {
                        if (s.charAt(k) != A[j].charAt(k)) diff++;
                    }
                    if (diff == 0) isVisited[j] = true;
                    if (diff == 2) {
                        isVisited[j] = true;
                        q.offer(A[j]);
                    }
                }
            }
        }
        return res;
    }

    /**
     * @unionfind
     *
     * if two strings are "similar" we union the two strings
     */
    public int numSimilarGroups1(String[] a) {
        int n = a.length;
        UnionFind uFind = new UnionFind(n);
        range(0, n).forEach(i -> range(i+1, n).filter(j -> isSimilar(a[i], a[j])).forEach(j -> uFind.union(i, j)));
        return uFind.getNumGroups();
    }

    private boolean isSimilar(String a, String b) {
        return range(0, a.length()).filter(i -> a.charAt(i) != b.charAt(i)).count() == 2;
    }

    public class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = range(0, n).toArray();
            this.rank = new int[n];
        }

        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);
            if (root1 == root2)
                return;
            if (rank[root1] > rank[root2])
                parent[root2] = root1;
            else
                parent[root1] = root2;
            if (rank[root1] == rank[root2])
                rank[root2] += 1;
        }

        public int find(int x) {
            while (parent[x] != x) x = parent[x];
            return x;
        }

        public int getNumGroups() {
            return (int) range(0, parent.length).filter(i -> i == parent[i]).count();
        }
    }

    public int numSimilarGroups2(String[] a) {
        int n = a.length;
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilarString(a[i], a[j])) {
                    int p1 = find(parent, i), p2 = find(parent, j);
                    if (p1 != p2) {
                        parent[p2] = p1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) res++;
        }
        return res;
    }

    private boolean isSimilarString(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return (diff == 2 || diff == 0);
    }

    private int find(int[] a, int x) {
        if (a[x] != x) {
            a[x] = find(a, a[x]);
        }
        return a[x];
    }

    public static void main(String[] args) {
        String[] s = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
//        String[] s = {"tars","rats","arts","star","star"};
        SimilarStringGroups si = new SimilarStringGroups();
        System.out.println(si.numSimilarGroups2(s));
    }
}
