package practice.interview.google;

/**
 * OOXOOXOOYOOXOOY find shortest X and Y
 *
 */
public class ShortestLengthBetweenTwoChar {
    public int shortest(String s) {
        int ix = -1, iy = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') ix = i;
            if (s.charAt(i) == 'Y') iy = i;
            if (ix != -1 && iy != -1) min = Math.min(min, Math.abs(ix - iy));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        ShortestLengthBetweenTwoChar sh = new ShortestLengthBetweenTwoChar();
        String s = "OOXOOXOOYOOOXOY";
        System.out.println(sh.shortest(s));
    }
}
