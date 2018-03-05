package practice.algorithmAndOOD.OOD;

import java.util.ArrayList;
import java.util.List;

public class MyP implements P{
    public static void main(String[] args) {
        List<String> x = new ArrayList<>();
        x.add("3");
        x.add("7");
        x.add("5");
        List<String> y = new MyP().doStubff(x);
        y.add("1");
        System.out.println(x);
    }
    public List<String> doStubff(List<String> z) {
        z.add("9");
        return z;
    }
}

