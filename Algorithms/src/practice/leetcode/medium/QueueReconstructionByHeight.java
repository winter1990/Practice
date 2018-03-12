package practice.leetcode.medium;

import java.util.*;

/**
 * (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height greater than or equal to h
 *
 * sort first by some criteria
 * [[7,0][4,4][7,1][5,0][6,1][5,2]]->[7,0][7,1][6,1][5,0][5,2][4,4]
 *
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        /*
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p2[0] == p1[0]) {
                    return p1[1] - p2[1];
                }
                return p2[0] - p1[0];
            }
        });
        */
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p2[0] == p1[0]) {
                    return p1[1] - p2[1];
                }
                return p2[0] - p1[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); // add(index, element)
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight q = new QueueReconstructionByHeight();
        int[][] intput = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        q.reconstructQueue(intput);
    }
}
