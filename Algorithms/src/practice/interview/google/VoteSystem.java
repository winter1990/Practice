package practice.interview.google;

import java.util.List;
import java.util.Map;

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
 */


public class VoteSystem {
    Map<Integer, Node> map;
    Map<String, Integer> totalVotes;
    Node head = null;
    Node tail = null;
    public VoteSystem(List<Vote> votes, String candidate1, String candidate2) {
        totalVotes.put(candidate1, 0);
        totalVotes.put(candidate2, 0);
        for (Vote vote : votes) {
            if (!map.containsKey(vote.time)) {
                totalVotes.put(vote.candidate, totalVotes.get(vote.candidate) + 1);
                String currentCandidate = getCurrentMAX();
                Node node = new Node(vote.time, currentCandidate);
            }
        }
    }

    private String getCurrentMAX() {
        return "";
    }

    public String winner(int time) {
        return map.get(time).candidate;
    }

    class Node {
        int time;
        String candidate;
        public Node(int t, String c) {
            time = t;
            candidate = c;
        }
    }

    private class Vote {
        int time;
        String candidate;
        public Vote(int time, String candidate) {
            this.time = time;
            this.candidate = candidate;
        }
    }
}
