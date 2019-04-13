package practice.leetcode.easy;

/**
 * @string
 *
 * keep track of the result in previous loop
 * start with index 0, compare with next character, if same count++, if not same, say it out by count+charat(i)
 *
 * 1. 1
 * 2. 11
 * 3. 21
 * 4. 1211
 * 5. 111221
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String pre = "1";

        int index;
        StringBuilder cur;
        int count;
        for (int m = 1; m < n; m++) {
            index = 0;
            cur = new StringBuilder();
            while (index < pre.length()) {
                count = 1;
                while (index < pre.length() - 1 && pre.charAt(index) == pre.charAt(index + 1)) {
                    count++;
                    index++;
                }
                cur.append(count);
                cur.append(pre.charAt(index));
                index++;
            }
            pre = cur.toString();
        }
        return pre;
    }
}
