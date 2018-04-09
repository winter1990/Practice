package practice.interview.other;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class WilliamsSonomaCodingChallengeTest {

    private WilliamsSonomaCodingChallenge ws;

    private ZipCodeInterval i1;
    private ZipCodeInterval i2;
    private ZipCodeInterval i3;
    private ZipCodeInterval i4;
    private ZipCodeInterval i5;
    private ZipCodeInterval i6;

    private List<ZipCodeInterval> list1;
    private List<ZipCodeInterval> list2;
    private List<ZipCodeInterval> list3;

    List<ZipCodeInterval> result1;
    List<ZipCodeInterval> result2;
    List<ZipCodeInterval> result3;

    @Before
    public void initializeZipCodeIntervals() {
        ws = new WilliamsSonomaCodingChallenge();

        i1 = new ZipCodeInterval();
        i2 = new ZipCodeInterval();
        i3 = new ZipCodeInterval();
        i4 = new ZipCodeInterval();
        i5 = new ZipCodeInterval();
        i6 = new ZipCodeInterval();

        i1.setStart(94133);
        i1.setEnd(94133);
        i2.setStart(94200);
        i2.setEnd(94299);
        i3.setStart(94123);
        i3.setEnd(94789);
        i4.setStart(94234);
        i4.setEnd(94890);
        i5.setStart(94226);
        i5.setEnd(94399);
        i6.setStart(94400);
        i6.setEnd(96666);

        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
        list3 = new LinkedList<>();

        list1.add(i1);
        list1.add(i2);
        list2.add(i3);
        list2.add(i4);
        list3.add(i5);
        list3.add(i6);

        result1 = ws.merge(list1);
        result2 = ws.merge(list2);
        result3 = ws.merge(list3);
    }

    @Test
    public void testNoOverlap() {
        assertEquals(2, result1.size());
        assertEquals(94133, result1.get(0).getStart());
        assertEquals(94133, result1.get(0).getEnd());
        assertEquals(94200, result1.get(1).getStart());
        assertEquals(94299, result1.get(1).getEnd());
    }

    @Test
    public void testOverlapAndMerge() {
        assertEquals(1, result2.size());
        assertEquals(94123, result2.get(0).getStart());
        assertEquals(94890, result2.get(0).getEnd());
    }

    @Test
    public void testNoOverlapButMerge() {
        assertEquals(1, result3.size());
        assertEquals(94226, result3.get(0).getStart());
        assertEquals(96666, result3.get(0).getEnd());
    }
}