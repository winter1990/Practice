package practice.leetcode.medium;

/**
 * @graph
 * @unionfind
 *
 * Return true if and only if it is possible to assign integers to variable names
 * so as to satisfy all the given equations.
 * ["a==b","b!=c","c==a"] false
 * ["a==b","b==c","a==c"] true
 * ["c==c","b==d","x!=z"] true
 * ["b==a","a==b"] true
 *
 * need to build the graph indicating the relationship between nodes:
 *   a = b, c = a -> b = a, b = c, set parent node
 *   if equal, they should have the same parent and no collision
 *   if not equal, they should have the different parent
 */
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int from = find(parent, eq.charAt(0) - 'a');
                int to = find(parent, eq.charAt(3) - 'a');
                parent[from] = to;
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int from = find(parent, eq.charAt(0) - 'a');
                int to = find(parent, eq.charAt(3) - 'a');
                if (from == to) return false;
            }
        }
        return true;
    }

    public int find(int[] a, int i) {
        if (a[i] != i) {
            a[i] = find(a, a[i]);
        }
        return a[i];
    }
}
