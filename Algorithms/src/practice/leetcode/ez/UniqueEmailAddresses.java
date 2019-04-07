package practice.leetcode.ez;

import java.util.HashSet;
import java.util.Set;

/**
 * @string
 *
 * email consists of local name and domain
 * for local name:
 *   ignore the doc
 *   ignore all content after plus sign
 * to receive the same email, local name and domain should be the same
 * we want to count different addresses actually receive emails -> remove the duplicates
 *
 * 1. get local and domain separately -> index of @, the pivot
 * 2. trim the local name -> get first + and get substring -> replace dot with empty -> add to set
 * 3. remove the duplicate and count the total different emails -> set size
 */
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
