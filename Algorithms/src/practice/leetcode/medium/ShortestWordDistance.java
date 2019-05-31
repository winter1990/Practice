package practice.leetcode.medium;

/**
 * @array
 *
 * Given a list of words and two words, return the shortest distance between these two words in the list.
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list
 *
 * Linear search:
 * two indices
 * i1 = index of word 1
 * i2 = index of word 2
 * if dict[i]
 *   equals w1, update i1
 *   equals w2, update i2
 *   get min distance between two words, ONLY IF two indices are assigned with some value
 *   so initialize them with -1, when both not -1, then we update distance
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length, i1 = -1, i2 = -1, res = n - 1;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) i1 = i;
            if (words[i].equals(word2)) i2 = i;
            if (i1 != -1 && i2 != -1) res = Math.min(res, Math.abs(i1 - i2));
        }
        return res;
    }
}
