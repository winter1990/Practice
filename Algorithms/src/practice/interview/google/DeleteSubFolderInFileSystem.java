package practice.interview.google;

import java.util.*;

/**
 * [/a/b, /e, /a/b/c/d] -> output: [a/b, /e]
 */
public class DeleteSubFolderInFileSystem {
    public List<String> removeSubFolder(String[] folders) {
        Arrays.sort(folders);
        List<String> list = new ArrayList<>();
        int pre = 0;
        for (int i = 1; i < folders.length; i++) {
            if (folders[i].equals(folders[pre]) || folders[i].startsWith(folders[pre] + "/")) continue;
            list.add(folders[pre]);
            pre = i;
        }
        list.add(folders[pre]);
        return list;
    }

    public static void main(String[] args) {
        DeleteSubFolderInFileSystem d = new DeleteSubFolderInFileSystem();
        System.out.println(d.removeSubFolder(new String[]{"/home/zz", "/home/joe", "/application", "/application","/home/joe/music/baba", "/a"}));
        System.out.println(d.getAllRootFolders(new String[]{"/home/zz", "/home/joe", "/application", "/application","/home/joe/music/baba", "/a"}));
    }

    public List<String> getAllRootFolders(String[] folders) {
        TrieNode root = new TrieNode();
        for (String path : folders) {
            String[] f = path.split("/");
            buildTrie(f, root);
        }
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TrieNode node, String cur, List<String> res) {
        if (node.isEnd) {
            res.add(cur);
            return;
        }
        for (String folder : node.folders.keySet()) {
            dfs(node.folders.get(folder), cur + "/" + folder, res);
        }
    }

    private void buildTrie(String[] f, TrieNode node) {
        for (String folder : f) {
            if (folder.length() == 0) continue;
            Map<String, TrieNode> map = node.folders;
            if (!map.containsKey(folder)) {
                map.put(folder, new TrieNode());
            }
            node = map.get(folder);
        }
        node.isEnd = true;
    }

    class TrieNode {
        boolean isEnd;
        Map<String, TrieNode> folders;

        public TrieNode() {
            isEnd = false;
            folders = new HashMap<>();
        }
    }
}
