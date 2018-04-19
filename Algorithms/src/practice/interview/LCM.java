package practice.interview;

import java.util.*;

/**
 * 在一堆兔子里给出两只，要求找兔子们的lowest common ancester，每只兔子有一个unique id和parents的list，
 * 兔子的辈分可能发生混乱。follow up是怎样降低复杂度
 */
public class LCM {
    public Node getLCA(Node a, Node b) {
        Set<Integer> set = new HashSet<>();
        Queue<Node> qa = new LinkedList<>();
        qa.offer(a);
        Queue<Node> qb = new LinkedList<>();
        qb.offer(b);
        set.add(a.id);
        set.add(b.id);
        while (!qa.isEmpty() || !qb.isEmpty()) {
            Node x = qa.poll();
            if (set.contains(x.id)) {
                return x;
            }
            for (Node n : x.parents) {
                qa.offer(n);
            }
            Node y = qb.poll();
            if (set.contains(y.id)) {
                return y;
            }
            for (Node n : y.parents) {
                qb.offer(n);
            }
        }
        return null;
    }
    class Node {
        int id;
        List<Node> parents;
        public Node (int id){
            this.id = id;
            parents = new ArrayList<>();
        }
    }
}

