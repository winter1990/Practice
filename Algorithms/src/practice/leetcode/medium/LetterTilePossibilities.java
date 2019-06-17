package practice.leetcode.medium;

/**
 * @string
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.
 * Return the number of possible non-empty sequences of letters you can make.
 *
 * Note: tiles consists of uppercase English letters.
 *
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 *
 * Input: "AAABBC"
 * Output: 188
 *
 * the problem can be translated to:
 * give upper letters, find the number of permutations
 *
 *
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] counter = new int[26];
        for (char c : tiles.toCharArray()) counter[c - 'A']++;
        return dfs(counter);
    }

    private int dfs(int[] counter) {
        int total = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) continue;
            total++;
            counter[i]--;
            total += dfs(counter);
            counter[i]++;
        }
        return total;
    }

    public static void main(String[] args) {
        String s = "AAB";
        LetterTilePossibilities l = new LetterTilePossibilities();
        System.out.println(l.numTilePossibilities(s));
    }
}
