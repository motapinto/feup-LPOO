package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class ListFilterTest {
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
        ListFilter filter = new ListFilter(this.list1);

        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        expected.add(12);

        IListFilter stubFilter = Mockito.mock(IListFilter.class);
        Mockito.when(stubFilter.accept(any(Integer.class))).thenReturn(false);
        Mockito.when(stubFilter.accept(3)).thenReturn(true);
        Mockito.when(stubFilter.accept(5)).thenReturn(true);
        Mockito.when(stubFilter.accept(12)).thenReturn(true);

        List<Integer> filtered = filter.filter(stubFilter);

        assertEquals(expected, filtered);
    }

    @Test
    public void positiveFilter2() {
        ListFilter filter = new ListFilter(this.list2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(5);

        IListFilter stubFilter = Mockito.mock(IListFilter.class);
        Mockito.when(stubFilter.accept(any(Integer.class))).thenReturn(false);
        Mockito.when(stubFilter.accept(1)).thenReturn(true);
        Mockito.when(stubFilter.accept(5)).thenReturn(true);

        List<Integer> filtered = filter.filter(stubFilter);

        assertEquals(expected, filtered);
    }

    @Test
    public void divisionFilter1() {
        ListFilter filter = new ListFilter(this.list1);

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(12);

        // fake division by 1
        IListFilter stubFilter = Mockito.mock(IListFilter.class);
        Mockito.when(stubFilter.accept(any(Integer.class))).thenReturn(false);
        Mockito.when(stubFilter.accept(0)).thenReturn(true);
        Mockito.when(stubFilter.accept(12)).thenReturn(true);

        List<Integer> filtered = filter.filter(stubFilter);

        assertEquals(expected, filtered);
    }

    @Test
    public void divisionFilter2() {
        ListFilter filter = new ListFilter(this.list2);

        List<Integer> expected = new ArrayList<>();
        expected.add(-4);
        expected.add(-4);
        expected.add(1);
        expected.add(1);
        expected.add(5);
        expected.add(-10);

        // fake division by 2
        IListFilter stubFilter = Mockito.mock(IListFilter.class);
        Mockito.when(stubFilter.accept(any(Integer.class))).thenReturn(true);

        List<Integer> filtered = filter.filter(stubFilter);

        assertEquals(expected, filtered);
    }
}
