package practice.leetcode.medium;

import java.util.Stack;

/**
 * @design
 *
 * ["StockSpanner","next","next","next","next","next","next","next"],
 * [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 *
 * find the first value previously that is larger than current value -> tree map
 * we want to know how may days including today, consecutively backward
 * create entry with day
 */
public class OnlineStockSpan {
}

class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        return res;
    }
}