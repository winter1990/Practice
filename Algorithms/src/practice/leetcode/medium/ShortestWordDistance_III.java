package practice.leetcode.medium;

/**
 *
 */
public class ShortestWordDistance_III {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length, min = n - 1;
        for (int i = 0, j = -1; i < n; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)){
                if(j != -1 && (!words[j].equals(words[i]) || word1.equals(word2))) {
                    min = Math.min(min, i - j);
                }
                j = i;
            }
        }
        return min;
    }
}

