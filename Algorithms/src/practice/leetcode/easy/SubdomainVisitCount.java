package practice.leetcode.easy;

import java.util.*;

/**
 * @string
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits1(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] strs = cpdomain.split(" ");
            int count = Integer.valueOf(strs[0]);
            String[] domains = strs[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = domains.length - 1; i >= 0; i--) {
                if (i == domains.length - 1) {
                    sb.append(domains[i]);
                } else {
                    sb.insert(0, domains[i] + ".");
                }
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
            }
        }
        List<String> res = new LinkedList<>();
        for (String k : map.keySet()) res.add(map.get(k) + " " + k);
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        SubdomainVisitCount sv = new SubdomainVisitCount();
        System.out.println(sv.subdomainVisits1(s));
    }
}
