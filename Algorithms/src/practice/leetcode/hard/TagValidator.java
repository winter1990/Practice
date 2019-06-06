package practice.leetcode.hard;

import java.util.Stack;

/**
 * @string
 *
 * The code must be wrapped in a valid closed tag. Otherwise, the code is invalid.
 *
 * A closed tag (not necessarily valid) has exactly the following format : <TAG_NAME>TAG_CONTENT</TAG_NAME>.
 * Among them, <TAG_NAME> is the start tag, and </TAG_NAME> is the end tag.
 * The TAG_NAME in start and end tags should be the same.
 * A closed tag is valid if and only if the TAG_NAME and TAG_CONTENT are valid.
 *
 * A valid TAG_NAME only contain upper-case letters, and has length in range [1,9].
 * Otherwise, the TAG_NAME is invalid.
 *
 * A valid TAG_CONTENT may contain other valid closed tags, cdata and any characters (see note1) EXCEPT unmatched <,
 * unmatched start and end tag, and unmatched or closed tags with invalid TAG_NAME.
 * Otherwise, the TAG_CONTENT is invalid.
 *
 * A start tag is unmatched if no end tag exists with the same TAG_NAME, and vice versa.
 * However, you also need to consider the issue of unbalanced when tags are nested.
 *
 * A < is unmatched if you cannot find a subsequent >. And when you find a < or </, all the subsequent characters
 * until the next > should be parsed as TAG_NAME (not necessarily valid).
 *
 * The cdata has the following format : <![CDATA[CDATA_CONTENT]]>.
 * The range of CDATA_CONTENT is defined as the characters between <![CDATA[ and the first subsequent ]]>.
 *
 * CDATA_CONTENT may contain any characters.
 * The function of cdata is to forbid the validator to parse CDATA_CONTENT, so even it has some characters that
 * can be parsed as tag (no matter valid or invalid), you should treat it as regular characters.
 */
public class TagValidator {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < code.length();) {
            if(i > 0 && stack.isEmpty()) return false;
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) return false;
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!isValidTagName(code.charAt(k))) return false;
                }
                String t = code.substring(j, i);
                if (stack.isEmpty() || !stack.pop().equals(t)) return false;
                i++;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!isValidTagName(code.charAt(k))) return false;
                }
                stack.push(code.substring(j, i));
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }

    private boolean isValidTagName(char c) {
        return Character.isLetter(c) && Character.isUpperCase(c);
    }

    public static void main(String[] args) {
        TagValidator t = new TagValidator();
        System.out.println(t.isValid("\"\""));
    }
}
