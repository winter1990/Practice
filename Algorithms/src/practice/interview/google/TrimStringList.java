package practice.interview.google;

import java.util.ArrayList;
import java.util.List;

public class TrimStringList {
    public List<String> trim(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
                count++;
            } else {
                if (count != 0) {
                    res.add(sb.toString());
                    count = 0;
                    sb = new StringBuilder();
                }
            }
            if (i == s.length() - 1 && count != 0) res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        TrimStringList t = new TrimStringList();
        System.out.println(t.trim("  a     b a fds   des     "));
    }
}
