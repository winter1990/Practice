package practice.leetcode;

public class Ladder {
    public static void main(String[] args) {
        try {
            System.out.println(dostuff(args));
        }
        catch (Exception e) {
            System.out.println("exc");
        }
        dostuff(args);
    }
    static int dostuff(String[] args) {
        return Integer.parseInt(args[0]);
    }
}
