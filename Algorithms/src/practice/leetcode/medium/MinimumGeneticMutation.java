package practice.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @string
 * @search
 * @bfs
 *
 * exactly the same thinking with word ladder
 *
 * the bank records all the valid gene mutations
 * the question can be translated to the word ladder that find the path from start to end
 * "AACCGGTT"
 * "AACCGGTA"
 * ["AACCGGTA"]
 *
 * keep all the visited set, because if we visit second time, it means we 're-routed' to this string
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        char[] dict = {'A', 'C', 'G', 'T'};
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(end)) {
                    return level;
                }
                char[] cs = cur.toCharArray();
                for (int i = 0; i < cur.length(); i++) {
                    char origin = cs[i];
                    for (char c : dict) {
                        cs[i] = c;
                        String newGene = new String(cs);
                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            q.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    cs[i] = origin;
                }
            }
            level++;
        }
        return -1;
    }
}
