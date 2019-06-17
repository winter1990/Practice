package practice.interview;

/**
 * 一个机器人根据指令走，每次走几步后左拐等下个指令。输入就是list of number x代表步数，让你求一个最小的rectangle可以cover entire path
 *
 *
 */
public class MinimumRectangleToCoverAllPathOfRobot {
    public int minRectangleToCover(int[] moves) {
        if (moves == null) return 0;
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // clock wise
        int dirIndex = 0;
        int minx = 0, maxx = 0, miny = 0, maxy = 0, curx = 0, cury = 0;
        for (int i = 0; i < moves.length; i++) {
            curx += dirs[dirIndex][0] * moves[i];
            cury += dirs[dirIndex][1] * moves[i];
            minx = Math.min(minx, curx);
            maxx = Math.max(maxx, curx);
            miny = Math.min(miny, cury);
            maxy = Math.max(maxy, cury);
            dirIndex = (dirIndex + 1) % 4;
        }
        return (maxx - minx) * (maxy - miny);
    }

    public static void main(String[] args) {
        int[] in = {2, 1, 5, 3, 10};
        MinimumRectangleToCoverAllPathOfRobot m = new MinimumRectangleToCoverAllPathOfRobot();
        System.out.println(m.minRectangleToCover(in));
    }
}
