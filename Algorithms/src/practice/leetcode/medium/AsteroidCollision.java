package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * asteroids = [10, 2, -5]
 * Output: [10]
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 *
 * keep the neg on left and pos on right
 * keep the abs(largest value) in the middle - WRONG [5,10,-5]
 * need to trace back, so stack
 *
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return null;
        } else if (asteroids.length <= 1) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            if (cur > 0) {
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(cur);
                } else if (stack.peek() == -cur) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] in = {-2,21,-22};
        AsteroidCollision ac = new AsteroidCollision();
        int[] res = ac.asteroidCollision(in);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
