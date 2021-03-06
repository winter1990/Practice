package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings {
}

/**
 * @string
 * @design
 *
 * The string may contain any possible characters out of 256 valid ascii characters
 * not use class member/global/static variables to store states
 * not rely on any library method such as eval or serialize methods
 *
 * string may contain special char/separator
 * separator + length
 */
class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        int index = 0;
        while (index < s.length()) {
            int slash = s.indexOf('/', index);
            int size = Integer.valueOf(s.substring(index, slash));
            res.add(s.substring(slash + 1, slash + 1 + size));
            index = slash + 1 + size;
        }
        return res;
    }
}