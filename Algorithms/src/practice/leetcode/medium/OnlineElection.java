package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @design
 *
 * In an election, the i-th vote was cast for persons[i] at time times[i].
 * Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the
 * number of the person that was leading the election at time t.
 * Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied
 * candidates) wins.
 * times is a strictly increasing array with all elements in [0, 10^9]
 *
 * need two maps:
 * hash map -> person id is the key, # of votes value
 * tree map -> time is the key, node is the value
 */
public class OnlineElection {
}

class TopVotedCandidate {
    TreeMap<Integer, Node> nodeMap;
    Map<Integer, Integer> voteCountMap;
    int max;
    int[] persons;
    int[] times;
    Node cur;
    public TopVotedCandidate(int[] persons, int[] times) {
        nodeMap = new TreeMap<>();
        voteCountMap = new HashMap<>();
        max = -1;
        this.persons = persons;
        this.times = times;
        cur = new Node();
        for (int i = 0; i < times.length; i++) {
            voteCountMap.put(persons[i], voteCountMap.getOrDefault(persons[i], 0) + 1);
            Node maxVoted = new Node();
            maxVoted.pre = cur;
            cur.next = maxVoted;
            if (voteCountMap.get(persons[i]) >= max) {
                maxVoted.topVotedPerson = persons[i];
                max = Math.max(max, voteCountMap.get(persons[i]));
            } else {
                if (cur.topVotedPerson == null) {
                    maxVoted.topVotedPerson = persons[i];
                } else {
                    maxVoted.topVotedPerson = maxVoted.pre.topVotedPerson;
                }
            }
            nodeMap.put(times[i], maxVoted);
            cur = cur.next;
        }

    }

    public int q(int t) {
        return nodeMap.floorEntry(t).getValue().topVotedPerson;
    }

    class Node {
        Integer topVotedPerson;
        Node next;
        Node pre;
        public Node() {

        }
    }

    public static void main(String[] args) {
//        int[] p = new int[]{0,1,1,0,0,1,0};
//        int[] t = new int[]{0,5,10,15,20,25,30};
//        TopVotedCandidate oe = new TopVotedCandidate(p, t);
//        System.out.println(oe.q(3));
//        System.out.println(oe.q(12));
//        System.out.println(oe.q(25));
//        System.out.println(oe.q(15));
//        System.out.println(oe.q(24));
//        System.out.println(oe.q(8));

        int[] p = new int[]{0,0,0,0,1};
        int[] t = new int[]{0,6,39,52,75};
        TopVotedCandidate oe = new TopVotedCandidate(p, t);
        System.out.println(oe.q(45));
        System.out.println(oe.q(49));
        System.out.println(oe.q(59));
        System.out.println(oe.q(68));
        System.out.println(oe.q(42));
        System.out.println(oe.q(37));
        System.out.println(oe.q(99));
        System.out.println(oe.q(26));
        System.out.println(oe.q(78));
        System.out.println(oe.q(43));
    }
}