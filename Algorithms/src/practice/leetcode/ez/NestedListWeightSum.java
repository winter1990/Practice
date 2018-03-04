package practice.leetcode.ez;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int res = 0;
        //Queue<NestedInteger> q  = new LinkedList<>();
        Queue<NestedInteger> q  = new LinkedList<NestedInteger>(nestedList);
        int level = 1;
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger n = q.poll();
                if (n.isInteger()) {
                    res += level * n.getInteger();
                } else {
                    q.addAll(n.getList());
                }
            }
            level += 1;
        }
        return res;
    }
}


