package practice.leetcode.hard;

public class MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        int count;
        int N = stations.length;
        double left = 0;
        double right = stations[N - 1] - stations[0];
        double mid;

        while (left +1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i)
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            if (count > K) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        MinimizeMaxDistanceToGasStation m = new MinimizeMaxDistanceToGasStation();
        int[] st = {1, 2, 50};
        int k = 3;
        System.out.println(m.minmaxGasDist(st, k));
    }
}
