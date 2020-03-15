package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PositiveFilterTest {
    private List<Integer> list1;
    private List<Integer> list2;

    @Before
    public void init() {
        this.list1 = new ArrayList<>();
        this.list2 = new ArrayList<>();

        this.list1.add(-1);
        this.list1.add(-5);
        this.list1.add(3);
        this.list1.add(0);
        this.list1.add(5);
        this.list1.add(12);

        this.list2.add(-4);
        this.list2.add(-4);
        this.list2.add(1);
        this.list2.add(1);
        this.list2.add(5);
        this.list2.add(-10);
    }

    @Test
    public void positiveFilter1() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        expected.add(12);

        PositiveFilter filter = new PositiveFilter();

        List<Integer> filtered = new ArrayList<>();
        for (int n : this.list1) {
            if(filter.accept(n)) {
                filtered.add(n);
            }
        }

        assertEquals(expected, filtered);
    }

    @Test
    public void positiveFilter2() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(5);

        PositiveFilter filter = new PositiveFilter();

        List<Integer> filtered = new ArrayList<>();
        for (int n : this.list2) {
            if(filter.accept(n)) {
                filtered.add(n);
            }
        }

        assertEquals(expected, filtered);
    }
}