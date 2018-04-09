package practice.interview.other;

import java.util.*;

public class BlendLabs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.nextLine().split(","));
        }
        List<String> docList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i)[2].equals("") && !docList.contains(list.get(i)[2])) {
                docList.add(list.get(i)[2]);
            }
        }
        Collections.sort(docList);
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 1; i < list.size(); i++) {
            String[] record = list.get(i);
            String applicationID = record[3];
            String docType = record[2];
            if (!map.containsKey(applicationID)) {
                Set<String> set = new HashSet<>();
                set.add(docType);
                map.put(applicationID, set);
            } else {
                map.get(applicationID).add(docType);
            }
        }
//        System.out.println(map);
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (String s : docList) {
            result.put(s, new ArrayList<String>());
        }

        for (String app : map.keySet()) {
            Set<String> subset = map.get(app);
            for (String doc : docList) {
                if (!subset.contains(doc)) {
                    result.get(doc).add(app);
                }
            }
        }

        for (int i = 0; i < docList.size(); i++) {
            System.out.println(docList.get(i));
            List<String> sublist = result.get(docList.get(i));
            Collections.sort(sublist);
            String sub = "";
            for (String s : sublist) {
                sub += (s + " ");
            }
            System.out.println(sub.trim());
        }
    }
}
