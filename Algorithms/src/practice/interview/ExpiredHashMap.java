package practice.interview;

/**
 * 题目是Map with expiration time , 就是实现 put(key, value, sec) 和 get(key), 如果get的是expired的就不返回值;
 * follow up1 是memory enhancement, 怎么随时delete expired key-value pair; follow up2是 how to handle same key put
 * 但是第一个key-value pair 没expire
 *
 * 就是一个正常的hashmap，但是多了time to live这个input
 *
 * follow up是，如何快速的得到当前没有expired的key/value。我用了treemap
 *
 * 还是expired hashmap…… 但follow up不一样，问了如何get the most recently added unexpired value，get了一次后，
 * 下一次get就是second most recently的
 */
public class ExpiredHashMap {

    public void put(String key, int value, int sec) {

    }

    public int getValue(String key) {
        return -1;
    }
}
