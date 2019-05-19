package practice.leetcode.hard;

import java.util.Stack;
import java.util.TreeMap;

/**
 * @string
 *
 * formula = "H2O", Output: "H2O"
 * formula = "Mg(OH)2", Output: "H2MgO2"
 * formula = "K4(ON(SO3)2)2", Output: "K4N2O14S4"
 *
 * some cases:
 *   (
 *   )
 *   letter (upper/lower case)
 *   digit
 */
public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        int i = 0;
        while (i < n) {
            char c = formula.charAt(i++);
            if (c == '(') {
                stack.push(map);
                map = new TreeMap<>();
            } else if (c == ')') {
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count *= 10;
                    count += formula.charAt(i) - '0';
                    i++;
                }
                count = count == 0 ? 1 : count;
                if (!stack.isEmpty()) {
                    TreeMap<String, Integer> tmp = map;
                    map = stack.pop();
                    for (String atom : tmp.keySet()) {
                        map.put(atom, map.getOrDefault(atom, 0) + count * tmp.get(atom));
                    }
                }
            } else {
                int start = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String atom = formula.substring(start, i);
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count *= 10;
                    count += formula.charAt(i) - '0';
                    i++;
                }
                count = count == 0 ? 1 : count;
                map.put(atom, map.getOrDefault(atom, 0) + count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String atom : map.keySet()) {
            sb.append(atom).append(map.get(atom) > 1 ? map.get(atom) : "");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NumberOfAtoms n = new NumberOfAtoms();
        System.out.println(n.countOfAtoms("(NB3)33"));
    }
}
