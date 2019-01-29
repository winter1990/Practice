package practice.leetcode.ez;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            int index = s.indexOf('@');
            String local = s.substring(0, index);
            String domain = s.substring(index);
            if (local.indexOf("+") > 0) {
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replace(".", "");
            set.add(local + domain);
        }
        return set.size();
    }
}
