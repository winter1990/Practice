package practice.leetcode.medium;

/**
 * @array
 *
 * Given a list of words and two words, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * the difference is: the two words might be the same
 * if same, we only need one pointer, and when see word1 and i1 != -1, then update max
 * if not same
 *   when seeing word 1, check i2, update
 *   when seeing word 2, check i1, update
 */
public class ShortestWordDistance_III {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length, i1 = -1, i2 = -1, res = n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2)) {
                    if (i1 != -1) res = Math.min(res, i - i1);
                } else {
                    if (i2 != -1) res = Math.min(res, i - i2);
                }
                i1 = i;
            } else if (words[i].equals(word2)) {
                if (i1 != -1) res = Math.min(res, i - i1);
                i2 = i;
            }
        }
        return res;
    }

    public int shortestWordDistance1(String[] words, String word1, String word2) {
        int n = words.length, res = n - 1;
        for (int i = 0, j = -1; i < n; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)){
                if(j != -1 && (!words[j].equals(words[i]) || word1.equals(word2))) {
                    res = Math.min(res, i - j);
                }
                j = i;
            }
        }
        return res;
    }
}

