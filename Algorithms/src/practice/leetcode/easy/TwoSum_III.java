package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TwoSum_III {
}




// time limit exceed
class TwoSum1 {
    /** Initialize your data structure here. */
    Set<Integer> num;
    Set<Integer> sum;
    public TwoSum1() {
        num = new HashSet<>();
        sum = new HashSet<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(num.contains(number)){
            sum.add(number * 2);
        }else{
            Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next() + number);
            }
            num.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }
}