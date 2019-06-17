package practice.leetcode.easy;

/**
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if
 * this robot ends up at (0, 0) after it completes its moves.
 *
 * UDLR
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) return false;
        int v = 0;
        int h = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                v++;
            } else if (moves.charAt(i) == 'D') {
                v--;
            } else if (moves.charAt(i) == 'L') {
                h--;
            } else if (moves.charAt(i) == 'R') {
                h++;
            }
        }
        return v == 0 && h == 0;
    }
}
