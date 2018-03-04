package practice.leetcode.ez;

/**
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
        int c;
        for (int m = 1; m < n; m++) {
            index = 0;
            cur = new StringBuilder();
            while (index < pre.length()) {
                c = 1;
                while (index < pre.length() - 1 && pre.charAt(index) == pre.charAt(index + 1)) {
                    c++;
                    index++;
                }
                cur.append(c);
                cur.append(pre.charAt(index));
                index += 1;
            }
            pre = cur.toString();
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.print(countAndSay(6));
    }
}
