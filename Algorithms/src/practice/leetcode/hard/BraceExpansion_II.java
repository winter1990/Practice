package practice.leetcode.hard;

import java.util.*;

/**
 * @string
 * @recursion
 *
 * Under a grammar given below, strings can represent a set of lowercase words.
 * Let's use R(expr) to denote the set of words the expression represents.
 *
 * Input: "{a,b}{c{d,e}}"
 * Output: ["acd","ace","bcd","bce"]
 *
 * Input: "{{a,z},a{b,c},{ab,z}}"
 * Output: ["a","ab","ac","z"]
 *
 * {a,b} - get substring - tokenize - add to list
 * a{b,c} - get left and right - save a to lsit - get substring into next recursive call
 * {a,b}{c,d} - get "a,b" in next call - "c,d" in next call
 * c{d,e} - c{d,e} - c + d,e
 * {ab{c,d}}
 * {ab{c,d},ex,{l,m}}
 */
public class BraceExpansion_II {
    public List<String> braceExpansionII2(String expression) {
        Set<String> set = new HashSet<>();
        List<String> res = getCombinations(0, expression, set);
        Collections.sort(res);
        return res;
    }

    private List<String> getCombinations(int start, String s, Set<String> set) {
        if (start >= s.length()) {
            List<String> tmp = new ArrayList<>();
            tmp.add("");
            return tmp;
        }
        int left = s.indexOf('{', start);
        int right = s.indexOf('}', start);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        if (left == start) {
            if (s.indexOf('{', left + 1) != -1 && s.indexOf('{', left + 1) < right) {
                list1.add(s.substring(left + 1, s.indexOf('{', left + 1)));
                list2 = getCombinations(s.indexOf('{', left + 1), s, set);
            } else {
                String[] strs = s.substring(left + 1, right).split(",");
                for (String str : strs) list1.add(str);
                list2 = getCombinations(right + 1, s, set);
            }
        } else {
            if (left == -1) {
                list1.add(s.substring(start));
                return list1;
            } else if (s.charAt(start) != ',') {
                list1.add(s.substring(start, left));
                list2 = getCombinations(left, s, set);
            }
        }
        if (s.charAt(start) == ',') {

        }
        List<String> res = new ArrayList<>();
        for (String a : list1) {
            for (String b : list2) {
                res.add(a + b);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "{{a,l},ex,{ab,c}}";
//        String s = "{a,b}{c,d}";
        String s = "{a,{x,ia,o},w}";
        BraceExpansion_II b = new BraceExpansion_II();
        System.out.println(b.braceExpansionII1(s));
    }

    public List<String> braceExpansionII1(String expression) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        boolean isAllLetter = false;
        int n = expression.length();
        for (int pre = n - 1, i = n - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == '{' || c == '}') isAllLetter = false;
            if (c == ',') {
                if (expression.charAt(i + 1) == '{' || isAllLetter) {
                    list.add(expression.substring(i, pre));
                    pre = i + 1;
                    isAllLetter = true;
                }
            }
            if (i == expression.length() - 1) {
                list.add(expression.substring(pre, i + 1));
            }
        }
        for (String s : list) {
            set.addAll(getExpansion(s));
        }
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    private List<String> getExpansion(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        int firstLeft = s.indexOf("{");
        int firstRight = s.indexOf("}");
        if (firstLeft == - 1 && firstRight == -1) {
            list.add(s);
            return list;
        }
        List<String> list2 = new ArrayList<>();
        if (firstLeft == -1 || firstRight < firstLeft) {
            String[] strs = s.substring(0, firstRight).split(",");
            for (String str : strs) list.add(str);
            list2 = getExpansion(s.substring(firstRight + 1));
        } else if (firstLeft < firstRight) {
            list.add(s.substring(0, firstLeft));
            list2 = getExpansion(s.substring(firstLeft + 1));
        }
        List<String> res = new ArrayList<>();
        for (String a : list) {
            for (String b : list2) {
                res.add(a + b);
            }
        }
        return res;
    }

    public List<String> braceExpansionII(String expression) {
        String s = expression;
        char preSign = ',';
        Stack<List<String>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '{'){
                int j = i, p = 1;
                while (s.charAt(j) != '}' || p != 0){
                    j++;
                    if (s.charAt(j) == '{') p++;
                    if (s.charAt(j) == '}') p--;
                }
                List<String> slist = braceExpansionII(s.substring(i+1, j));
                if (preSign == '*'){
                    stack.push(merge(stack.pop(), slist));
                }
                else stack.push(slist);
                i = j;
                //default preSign is *
                preSign = '*';
            } else if (Character.isLetter(c)){
                List<String> slist = new ArrayList<>();
                slist.add(""+c);
                if (preSign == '*'){
                    stack.push(merge(stack.pop(), slist));
                }
                else stack.push(slist);
                // //default preSign is *
                preSign = '*';
            }
            // case 3. if  == ", ", preSign is plus, (default preSign is *);
            if (c ==',' || i == s.length()-1){
                preSign = ',';
            }
        }
        // output stack to one dimesion list;
        List<String> res = new ArrayList<>();
        while(!stack.isEmpty()){
            for (String l : stack.pop())
                if (!res.contains(l))res.add(l);
        }
        // sort by lexi-order
        Collections.sort(res);
        return res;
    }
    // multiply operation of 2 List<letter>
    public List<String> merge(List<String> list1, List<String> list2){
        List<String> res = new ArrayList<>();
        for (String l1 : list1){
            for (String l2 : list2){
                res.add(l1+l2);
            }
        }
        return res;
    }
}
