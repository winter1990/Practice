package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @greedy
 *
 * You are given the each item's price, a set of special offers, and the number we need to buy for each item.
 * The job is to output the lowest price you have to pay for exactly certain items as given, where you could make
 * optimal use of the special offers.
 * Each special offer is represented in the form of an array, the last number represents the price you need to pay
 * for this special offer, other numbers represents how many specific items you could get if you buy this offer.
 *
 * Input: [2,5], [[3,0,5],[1,2,10]], [3,2], Output: 14
 * Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1], Output: 11
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        int total = getRegularTotal(price, needs);
        int minTotal = Integer.MAX_VALUE;
        for (int i = index; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            int j = 0;
            while (j < needs.size() && offer.get(j) <= needs.get(j)) j++;
            if (j == needs.size()) {
                while (--j >= 0) needs.set(j, needs.get(j) - offer.get(j));
                total = Math.min(total, offer.get(offer.size() - 1) + dfs(price, special, needs, i));
                while (++j < needs.size()) needs.set(j, needs.get(j) + offer.get(j));
            }
        }
        return total;
    }

    private int getRegularTotal(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < price.size(); i++) total += price.get(i) * needs.get(i);
        return total;
    }

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2,3,4));
        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<>(Arrays.asList(1,1,0,4)));
        special.add(new ArrayList<>(Arrays.asList(2,2,1,9)));
        List<Integer> needs = new ArrayList<>(Arrays.asList(1,2,1));

        ShoppingOffers so = new ShoppingOffers();
        System.out.println(so.shoppingOffers(price, special, needs));
    }
}
