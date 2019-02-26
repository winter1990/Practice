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

    public static void main(String[] args) {
        String s = "/* */";
        System.out.println(s.replaceAll("/\\*(.*)?\\*/", ""));
    }
}
