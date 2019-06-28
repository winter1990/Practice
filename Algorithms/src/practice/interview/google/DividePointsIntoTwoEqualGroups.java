package practice.interview.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Give a set of points in a 2D plane. You need to pick two points such that if you drew a line connecting these points
 * it would divide the points into two equal halves.
 * You can assume that solution always exists.
 */
public class DividePointsIntoTwoEqualGroups {
    public double[][] dividePoints(double[][] points) {
        Arrays.sort(points, (a, b) -> Double.compare(a[0], b[0]));
        Set<String> set = new HashSet<>();
        int n = points.length;
        double[][] res = new double[2][2];
        for (int i = 0; i < n; i++) {
            double[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                double[] p2 = points[j];
                set.add(p1[0] + " " + p1[1]);
                set.add(p2[0] + " " + p2[1]);
                double[] line1 = params(p1, p2);

            }
        }
        return null;
    }

    private double[] getIntersection(double[] l1, double[] l2) {
        double[] res = new double[2];
        res[0] = (l2[1] - l1[1]) / (l1[0] - l2[0]);
        res[1] = res[0] * l1[0] + l1[1];
        return res;
    }

    private double[] params(double[] a, double[] b) {
        double[] res = new double[2];
        if (a[0] != b[0]) {
            res[0] = (a[1] - b[1]) / (a[0] - b[0]);
            res[1] = (a[1] -  a[0] / b[0] *  b[1]) / (1 - a[0] / b[0]);
        } else {
            res[0] = Integer.MAX_VALUE;
            res[1] = -a[0];
        }

        return res;
    }

    public static void main(String[] args) {
        double[][] in = {{1,2},{2,1},{2,3},{3,2},{4,1},{5,2}};
        DividePointsIntoTwoEqualGroups d = new DividePointsIntoTwoEqualGroups();
        d.dividePoints(in);
    }

}
