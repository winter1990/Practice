package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 *
 * Given a list of directory info including directory path, and all the files with contents in this directory,
 * you need to find out all the groups of duplicate files in the file system in terms of their paths.
 * Input: ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 *
 * use map to store the content and directory in the paths
 * key is the content, and value is a list of paths
 * there might be duplicate paths and content so we can use Set in the value
 * the path and file name+content is separated by space
 */
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new LinkedList<>();
        if (paths == null || paths.length == 0) {
            return res;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] st = path.split(" ");
            for (int i = 1; i < st.length; i++) {
                int index = st[i].indexOf('(');
                String content = st[i].substring(index, st[i].length() - 1);
                String filename = st[0] + "/" + st[i].substring(0, index);
                map.putIfAbsent(content, new HashSet<>());
                map.get(content).add(filename);
            }
        }
        for (String content : map.keySet()) {
            if (map.get(content).size() > 1) {
                List<String> list = new LinkedList<>();
                for (String file : map.get(content)) {
                    list.add(file);
                }
                res.add(list);
            }
        }
        return res;
    }
}
