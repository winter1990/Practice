package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @regex
 *
 * comment for one line - //.*
 * comment for block /* and all content after until we see * /
 * multiple lines and chars .*|(\n)*
 */
/*/*/
public class RemoveComments {
    public List<String> removeComments(String[] source) {
        String[] strs = String.join("\n", source)
                //.replaceAll("//.*|/\\*(.*|\n*)?\\*/", "").split("\n"); // (.*|)
                .replaceAll("//.*|/\\*(.|\n)*?\\*/", "").split("\n");

        List<String> ans = new ArrayList<>();
        for (String s : strs) {
            if (!s.equals("")) {
                ans.add(s);
            }
        }
        return ans;
    }

    public List<String> removeComments1(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (mode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "/* */";
        System.out.println(s.replaceAll("/\\*(.*)?\\*/", ""));
    }
}
