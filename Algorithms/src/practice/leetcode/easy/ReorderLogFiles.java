package practice.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @string
 *
 * For each log, the first word in each log is an alphanumeric identifier.
 * Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * define the comparator for sorting:
 * format of the log - identifier + (letter || numbers)
 * order of the logs:
 *   letter > number log
 *   letter logs ordered lexicographically
 *   digit logs in original order
 * split the log by " " -> str[0] is identifier, the rest are log
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] strs1 = s1.split(" ");
                String[] strs2 = s2.split(" ");
                if (Character.isLetter(strs1[1].charAt(0)) && Character.isDigit(strs2[1].charAt(0))) return -1;
                if (Character.isDigit(strs1[1].charAt(0)) && Character.isDigit(strs2[1].charAt(0))) return 0;
                if (Character.isDigit(strs1[1].charAt(0)) && Character.isLetter(strs2[1].charAt(0))) return 1;
                int i1 = s1.indexOf(" ") + 1;
                int i2 = s2.indexOf(" ") + 1;
                String log1 = s1.substring(i1);
                String log2 = s2.substring(i2);
                if (log1.equals(log2)) return strs1[0].compareTo(strs2[0]);
                return log1.compareTo(log2);
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        ReorderLogFiles rl = new ReorderLogFiles();
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        rl.reorderLogFiles(logs);
    }
}
