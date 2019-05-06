package practice.leetcode.easy;

/**
 * @math
 */
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        if ((points[0][0] == points[1][0] && points[0][1] == points[1][1]) || (points[1][0] == points[2][0] && points[1][1] == points[2][1])) return false;
        return (double) (points[1][1] - points[0][1]) / (points[1][0] - points[0][0]) != (double) (points[2][1] - points[1][1]) / (points[2][0] - points[1][0]);
    }

    public boolean isBoomerang1(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[1][0]) != (points[2][1] - points[1][1]) * (points[1][0] - points[0][0]);
    }

    public static void main(String[] args) {
        ValidBoomerang v= new ValidBoomerang();
        int[][] in = {{1,1},{2,2},{999,1000}};
        System.out.println(v.isBoomerang(in));
        System.out.println(v.isBoomerang1(in));
    }
}
