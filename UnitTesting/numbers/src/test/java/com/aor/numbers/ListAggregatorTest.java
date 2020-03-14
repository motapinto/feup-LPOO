package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    List<Integer> list;

    @Before
    public void createAggregators() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);
        int sum = aggregator.sum();
        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();
        assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);
        int min = aggregator.min();
        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);
        deduplicated.add(5);

        /* class DeduplicateStub implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter sorter) {
                List<Integer> stublist = new ArrayList<>();
                stublist.add(1);
                stublist.add(2);
                stublist.add(4);
                return stublist;
            }
        } */

        /* class SorterStub implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> stubList = new ArrayList<>();
                stubList.add(1);
                stubList.add(2);
                stubList.add(2);
                stubList.add(4);
                return stubList;
            }
        } */

        ListAggregator aggregator = new ListAggregator(list);
        IListDeduplicator deduplicated_stub = Mockito.mock(IListDeduplicator.class);
        IListSorter sorter_stub = Mockito.mock(IListSorter.class);

        Mockito.when(deduplicated_stub.deduplicate(sorter_stub)).thenReturn(deduplicated);
        int distinct = aggregator.distinct(deduplicated_stub, sorter_stub);
        assertEquals(4, distinct);
    }
}