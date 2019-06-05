package practice.leetcode.medium;

/**
 * @string
 *
 * Solve a given equation and return the value of x in the form of string "x=#value".
 * The equation contains only '+', '-' operation, the variable x and its coefficient.
 *
 * If there is no solution for the equation, return "No solution".
 *
 * If there are infinite solutions for the equation, return "Infinite solutions".
 *
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 *
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 *
 * Input: "x=x"
 * Output: "Infinite solutions"
 *
 * Input: "2x=x"
 * Output: "x=0"
 *
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 *
 *
 */
public class SolveTheEquation {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int[] l = evaluate(eq[0]);
        int[] r = evaluate(eq[1]);
        int co = l[0] - r[0];
        int v = r[1] - l[1];
        if (co == 0 && v == 0) return "Infinite solutions";
        if (co == 0) return "No solution";
        return "x=" + v / co;

    }

    private int[] evaluate(String s) {
        int co = 0, sum = 0;
        String[] tokens = s.replace("+", "#+").replace("-", "#-").split("#");
        for (String t : tokens) {
            if (t.length() == 0) continue;
            if (t.contains("x")) {
                if (t.equals("+x") || t.equals("x")) {
                    co += 1;
                } else if (t.equals("-x")) {
                    co -= 1;
                } else {
                    co += Integer.valueOf(t.substring(0, t.length() - 1));
                }
            } else {
                sum += Integer.valueOf(t);
            }
        }
        return new int[]{co, sum};
    }

    public static void main(String[] args) {
        SolveTheEquation s = new SolveTheEquation();
        System.out.println(s.solveEquation("x+5-3+x=6+x-2"));
    }
}
