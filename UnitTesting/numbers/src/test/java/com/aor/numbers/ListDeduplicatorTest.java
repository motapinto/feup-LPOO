package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    List<Integer> list;

    @Before
    public void createDuplicators() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        List<Integer> sorted_list = new ArrayList<>();
        sorted_list.add(1);
        sorted_list.add(2);
        sorted_list.add(2);
        sorted_list.add(4);
        sorted_list.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(sorted_list);

        List<Integer> distinct = deduplicator.deduplicate(sorter);
        assertEquals(expected, distinct);
    }

    @Test
    public void distinct_bug8726() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        /* class SorterStub implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> stublist = new ArrayList<>();
                stublist.add(1);
                stublist.add(2);
                stublist.add(4);
                return stublist;
            }
        } */

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        IListSorter sorter_stub = Mockito.mock(IListSorter.class);
        Mockito.when(sorter_stub.sort()).thenReturn(expected);
        List<Integer> distinct = deduplicator.deduplicate(sorter_stub);


        assertEquals(expected, distinct);
    }
}