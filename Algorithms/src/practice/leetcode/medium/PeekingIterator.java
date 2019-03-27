package practice.leetcode.medium;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @design
 * @iterator
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be
 * sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * next is pop()
 * peek() is just get the first element
 */

public class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iter;
    boolean noSuchElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        advanceIter();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        // you should confirm with interviewer what to return/throw
        // if there are no more values
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (noSuchElement)
            throw new NoSuchElementException();
        Integer res = next;
        advanceIter();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !noSuchElement;
    }

    private void advanceIter() {
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            noSuchElement = true;
        }
    }
}