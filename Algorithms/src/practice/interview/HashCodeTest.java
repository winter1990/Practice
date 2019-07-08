package practice.interview;

public class HashCodeTest {
    public static void main(String[] args) {
        System.out.println(Integer.hashCode(1));
        System.out.println('a' + 1);
        System.out.println("a".hashCode());
        System.out.println("ab".hashCode());
        System.out.println(97 * 31 + 98);
    }
}
