package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeNaryTree {
    class Codec {

        final String SEPARATOR = ",";
        public String serialize(Node root) {
            List<String> list = new ArrayList<>();
            dfs(root, list);
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s).append(SEPARATOR);
            }
            return sb.substring(0, sb.length() - 1);
        }

        private void dfs(Node node, List<String> list) {
            if (node == null) {
                return;
            }
            list.add(node.val + "");
            list.add(node.children.size() + "");
            for (Node child : node.children) {
                dfs(child, list);
            }
        }
        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            String[] tokens = data.split(SEPARATOR);
            Queue<Integer> q = new LinkedList<>();
            for (String token : tokens) {
                q.offer(Integer.valueOf(token));
            }
            return deserialize(q);
        }

        private Node deserialize(Queue<Integer> q) {
            Node node = new Node();
            node.val = q.poll();
            int numChildren = q.poll();
            node.children = new ArrayList<>();
            for (int i = 0; i < numChildren; i++) {
                node.children.add(deserialize(q));
            }
            return node;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
