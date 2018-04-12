package practice.leetcode.medium;

import java.util.Stack;

/**
 * @string
 * @stack
 *
dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
dir/subdir2/subsubdir2/file2.ext => len = 32

tokenize:
dir \tsubdir1 \t\tfile1.ext \t\tsubsubdir1 \tsubdir2 \t\tsubsubdir2 \t\t\tfile2.ext
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        int longest = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : strs) {
            String tmp = s.replaceAll("\t", "");
            int level = s.length() - tmp.length();

            while (stack.size() > level) {
                current -= stack.pop();
            }
            int length = tmp.length() + 1;
            current += length;
            stack.push(length);
            if (tmp.contains(".")) {
                longest = Math.max(longest, current - 1);

            }
        }
        return longest;
    }

    public static void main(String[] args) {
//        String s = "abc\na\ta";
//        System.out.println(s);
//        System.out.println(s.length());
        LongestAbsoluteFilePath l = new LongestAbsoluteFilePath();
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(l.lengthLongestPath(s));
    }
}
