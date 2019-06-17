package practice.interview.google;

/**
 * 给一句英文句子和给出屏幕的宽度，要求单词左对齐打印出来，求每一行最大的单词数目。
 *
 * Yimusanfendi is a great website that has a lot of good discussion.
 *
 * Yimusanfendi is         a great website
 * that         has        a lot   of
 * good         discussion
 *
 * lo, hi = [1 12]
 */
public class MaximumNumberOfWordsForEachLine {
    public int maximumNumberOfWords(String s, int maxLen) {
        String[] words = s.split(" ");
        int lo = 1, hi = words.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canFit(words, mid, maxLen)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    private boolean canFit(String[] words, int n, int maxLen) {
        int[] count = new int[n];
        for (int i = 0; i < words.length; i++) {
            count[i % n] = Math.max(count[i % n], words[i].length());
        }
        int totalLen = 0;
        for (int i = 0; i < n; i++) {
            totalLen += count[i];
        }
        totalLen += n - 1;
        return totalLen <= maxLen;
    }

    public static void main(String[] args) {
        MaximumNumberOfWordsForEachLine m = new MaximumNumberOfWordsForEachLine();
        String s = "Yimusanfendi is a great website that has a lot of good discussion"; // 39 to fit 5
        System.out.println(m.maximumNumberOfWords(s, 39));
    }
}
