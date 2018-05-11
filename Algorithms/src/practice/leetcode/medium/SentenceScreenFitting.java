package practice.leetcode.medium;

/**
 * @array
 *
 * find how many times the given sentence can be fitted on the screen.
 * index from in sentence, always get index%len
 */
public class SentenceScreenFitting {
    /**
     * The purpose for this map array is simply to decide how a word’s position on screen should be adjusted
     * when the word would have to be broken into two lines if had printed sequentially.
     * positive, move forward,
     * negative, this word not completed, go back with map[i] characters
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length();
        int index = 0;
        // track HOW we are going to move the index
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i - 1] - 1;
        }
        for (int i = 0; i < rows; ++i) {
            index += cols;
            index += map[index % len];
        }
        return index / len;
    }

    //TLE
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0) {
            return 0;
        }
        int n = sentence.length;
        int index = 0;
        int row = 0;
        int i;
        while (row < rows) {
            if (sentence[index % n].length() > cols) {
                return 0;
            }
            i = 0;
            while (i < cols) {
                if (i + sentence[index % n].length() > cols) {
                    break;
                }
                i += sentence[index % n].length() + 1;
                index++;
            }
            row++;
        }
        return index / n;
    }

    public static void main(String[] args) {
        String[] str = {"I","had","apple","pie"};
//        String[] str = {"a"};
        int row = 6;
        int col = 5;
        SentenceScreenFitting s = new SentenceScreenFitting();
        System.out.println(s.wordsTyping(str, row, col));
    }
}
