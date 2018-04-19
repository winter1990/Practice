package practice.leetcode.ez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @string
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            res.add("");
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] strs = s.split(" ");
            int cnt = Integer.valueOf(strs[0]);
            String domain = strs[1];
            map.put(domain, map.getOrDefault(domain, 0) + cnt);

            while (domain.indexOf('.') != -1) {
                int index = domain.indexOf('.');
                String sub = domain.substring(index + 1);
                map.put(sub, map.getOrDefault(sub, 0) + cnt);
                domain = domain.substring(index + 1);
            }
        }
        for (String domain : map.keySet()) {
            res.add(map.get(domain) + " " + domain);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        SubdomainVisitCount sv = new SubdomainVisitCount();
        System.out.println(sv.subdomainVisits(s));
    }
}
