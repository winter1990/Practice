package practice.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个方法 encode 一个 int。
 * 例如有一个 N, 那么第一步就是 N + 1
 * 第二步是把 N + 1 变为 binary， 第三步是在前面加上 digit(Bin(N + 1)) - 1 个 0
 * 给个例子， 给 3 -> 3 + 1 = 4 -> 100 -> 00100 (因为 100 是 3 个digit， 加上 2 个 0）
 * 然后问题就是怎么样给你一个 int stream， decode 这个，变回 10 进制
 *
 * [0100 0100 0001 0000] -> [1, 3, 15]
 */
public class BinaryDecoding {
    public List<Integer> getStreamValues(int[] arr) {
        int i = 0, count = 0;
        List<Integer> res = new ArrayList<>();
        while (i < arr.length) {
            if (arr[i] == 0) {
                count++;
                i++;
            } else {
                ++count;
//                StringBuilder sb = new StringBuilder();
                int val = 0;
                while (count > 0) {
//                    sb.append(arr[i++]);
//                    count--;
                    val <<= 1;
                    val |= arr[i];
                    i++;
                    count--;
                }
//                res.add(Integer.parseInt(sb.toString(), 2) - 1);
                res.add(val - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {0,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0};
        BinaryDecoding b = new BinaryDecoding();
        System.out.println(b.getStreamValues(in));
    }
}
