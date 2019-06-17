package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned
 * more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * problems to solve:
 * 1. fit the words in one single line
 * 2. distance between words
 * 3. last line as left as possible
 * 4. one word one line
 *
 * count the total length of words
 *   each word takes word.len + 1
 *
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int len = 0;
            int j = i;
            String s = new String();
            for (; j < words.length; j++) {
                len += (words[j].length() + 1);
                if (len > maxWidth) {
                    if (len - 1 == maxWidth) {
                        s = generateList(words, i, j, len - 1, maxWidth);
                    } else {
                        len -= (words[j].length() + 1);
                        --j;
                        s = generateList(words, i, j, len - 1, maxWidth);
                    }
                    break;
                } else {
                    s = generateList(words, i, j, len - 1, maxWidth);
                }
            }
            i = j + 1;
            res.add(s);
        }
        return res;
    }

    private static String generateList(String[] words, int s, int e, int len, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (s == e) {
            sb.append(words[s]);
            for (int i = 0; i < maxWidth - len; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int space = maxWidth - len;
        int spaceForEach = space / (e - s) + 1;
        int spaceForSome = space % (e - s);
        if (e != words.length - 1) {
            for (int i = s; i <= e; i++) {
                if (i != e) {
                    sb.append(words[i]);
                    for (int j = 0; j < spaceForEach; j++) {
                        sb.append(" ");
                    }
                    if (spaceForSome > 0) {
                        sb.append(" ");
                        spaceForSome--;
                    }
                } else {
                    sb.append(words[i]);
                }
            }
        } else {
            for (int i = s; i <= e; i++) {
                if (i != e) {
                    sb.append(words[i]);
                    sb.append(" ");
                } else {
                    sb.append(words[i]);
                    for (int j = 0; j < maxWidth -len; j++) sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] in = {"Listen","to","many,","speak","to","a","few."};
        TextJustification t = new TextJustification();
        List<String> res = t.fullJustify(in, 6);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("-" + res.get(i) + "-");
        }
    }
}
