import org.omg.SendingContext.RunTime;
import practice.leetcode.medium.MyCalendar_II;

import java.io.*;
import java.time.Month;
import java.time.YearMonth;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test {

    public static boolean changeValue(int i) {
        i /= 10;
        return true;
    }

    public static List<Integer> test(int i) {
        List<Integer> res = new LinkedList<>();
        if (changeValue(i)) {
            res.add(i);
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println(Integer.MAX_VALUE);

//        System.out.println("Aa".hashCode());
//        System.out.println("A".hashCode());
//        System.out.println("a".hashCode());
//        System.out.println(7 * 31 + "A".hashCode());

//        System.out.println(Integer.valueOf("-1"));

//        String s1 = "abc";
//        String s2 = "abc";
//        String s3 = new String("abc");
//        String s4 = new String("abc");
//        Set<String> set = new HashSet<>();
//        System.out.println(set.add(s1));
//        System.out.println(set.add(s2));
//        System.out.println(set.add(s3));
//        System.out.println(set.add(s4));
//
//        System.out.println(s1 == s2);
//        System.out.println(s3 == s4);
//        System.out.println(1 + 1 + "" + (1 + 1));
//        System.out.println('z'- 'a');
//        Long l = new Long(1234);
//        Long l1 = l;
//        if(l==l1) {
//            System.out.println("Eq objects");
//        }else {
//            System.out.println("not eq");
//        }
//        l++;
//        if (l==l1) {
//            System.out.println("Eq objects");
//        }else {
//            System.out.println("not eq");
//        }

//        List<String> letters = new ArrayList(Arrays.asList("D","B","A","C","F","G"));
//        Predicate<String> p1 = s->s.compareTo("C")>0;
//        Predicate<String> p2 = s->s.equals("B");
//        letters.removeIf(p1.negate().or(p2));
//        letters.sort((s1,s2)->s1.compareTo(s2));
//        System.out.println(letters);
//        System.out.println(Stream.of("green","yellow","blue")
//                .max((s1,s2) -> s1.compareTo(s2))
//                .filter(s -> s.endsWith("n"))
//                .orElse("yellow"));

//        System.out.println(Math.random());
//        InputStreamReader a=new InputStreamReader("sad","UTF-16E");
//        FileInputStream s=new FileInputStream("asd");
//        InputStreamReader isr=new InputStreamReader(s,"UTF-8");
//        FileReader fr=new FileReader(s);
//        RandomAccessFile rf=new RandomAccessFile("asd","wer");


//        String a = "abc";
//        System.out.println(a.substring(0,0));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1,3);
//        map.put(2,3);
//        System.out.println(map.size());
//        System.out.println(map.values());
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(null);
//        list.add(2);
//        System.out.println(list);
//        int[] ia = { 9, 10, 8, 3, 4, 7, 6, 1, 5 };
//        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();

        // use offer() method to add elements to the PriorityQueue pq1
//        for (int x : ia) {
//            pq1.offer(x);
//        }

//        System.out.println("pq1: " + pq1);
//        System.out.println(pq1.peek());
//        System.out.println(pq1.poll());
//        System.out.println(pq1.poll());
//        System.out.println(pq1.poll());
//        System.out.println(pq1.poll());
//        System.out.println(pq1.poll());
//        String s1 = "welcome";
//        String s2 = s1 + "eee";
//        System.out.println(s1.hashCode() + " " + s2.hashCode());
//        System.out.println(Integer.valueOf("-1"));
//        List<String> aaa = Arrays.asList("dog","over","good");
//        aaa.forEach(System.out::println);
//        System.out.println(aaa.stream().reduce(new String(), (s1,s2) -> s1 + s2.charAt(0),(c1,c2)->c1+=c2));
//        Invoice invoice = new Invoice();
//        System.out.println(invoice.formatId("1234"));
//
//        YearMonth ym1 = YearMonth.now();
//        YearMonth ym2 = YearMonth.of(2016, Month.FEBRUARY)
//        String s1 = "My string";
//        String s2 = new String("My string");
//        System.out.println(s1.hashCode() == s2.hashCode());
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.matches(s2));
        Integer n1 = new Integer(1);
        Integer n2 = n1;
        n1 +=1;
//        System.out.println(n1);
//        System.out.println(n2);
    }

    private void meth(String[] args) {
        System.out.println(args);
        System.out.println(args[1]);
    }
    class MyCollection<T> {
        private Set<T> set;
        public Set<T> getCollection() {
            return this.set;
        }
    }

    public void TestCollection(MyCollection<?> collection) {
        Set<?> set = collection.getCollection();
    }
}


