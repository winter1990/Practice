package practice.interview.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一个投票系统类似于美国总统大选，每一张选票写着 Candidate的名字和 一个int 时间 从1到正无穷
 * ex：
 * { {1, A}, {2, A}, {5, B}, {1000, C}, {1005, B}, {2000, B}}
 * 5 -> A
 * 1005-> A
 * 1006 -> A
 * 2000 -> B
 *
 * build time Time O(n) space (n), lookup time O(lgn) space O(lgn/2)
 * 先自己建一个class Vote{ String candidate, int timestamp}
 * Build: 开一个暂时的Map<String, Integer> 和两个辅助变量去maintain 当前的最大值，再建一个List<Vote>,
 * 每当当前最大值改变的时候就把一个新的Vote 加进list 里面，lookup 的时候就用Binary Search 找上一个最近的值就好了
 *
 * vote: time, candidate
 * node: array, winner
 * VoteSystem:
 */


public class VoteSystem {
    int n;
    TreeMap<Integer, Node> map; // map the time to node
    Map<Integer, Integer> votes;
    Node tail = null;
    public VoteSystem(int candidate1, int candidate2) {
        n = 2;
        map = new TreeMap<>();
        votes = new HashMap<>();
        votes.put(candidate1, 0);
        votes.put(candidate2, 0);
    }

    public void update(Vote v) {
        votes.put(v.candidate, votes.get(v.candidate) + 1);
        if (!map.containsKey(v.time)) {
            Node node = new Node(v.time);
            for (int k = 0; k < node.candidates.length; k++) {
                node.candidates[k] = votes.get(v.candidate);
            }
        }
    }
    public int winner(int time) {
        int index = 0;
        int[] votes = map.get(time).candidates;
        int max = votes[0];
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] > max) {
                index = i;
            }
        }
        return index;
    }

    class Node {
        int[] candidates;
        Node pre;
        Node next;
        public Node(int c) {
            candidates = new int[n];
        }
    }

    private class Vote {
        int time;
        int candidate;
        public Vote(int time, int candidate) {
            this.time = time;
            this.candidate = candidate;
        }
    }
}
