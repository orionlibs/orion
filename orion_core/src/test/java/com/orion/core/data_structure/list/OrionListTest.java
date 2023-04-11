package com.orion.core.data_structure.list;

import static org.junit.Assert.assertArrayEquals;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.ListService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.tasks.GetIntersectionTask;
import com.orion.core.data.structure.list.type.OrionArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class OrionListTest extends Orion
{
    private OrionList<Integer> filteredList;
    private OrionList<Integer> expectedFilteredList;


    @BeforeAll
    public void setUp() throws Exception
    {
        filteredList = new OrionArrayList<Integer>();
        expectedFilteredList = new OrionArrayList<Integer>();
        expectedFilteredList.add(4);
        expectedFilteredList.add(5);
        expectedFilteredList.add(6);
    }


    @Test
    public void testListFilterAndLoop()
    {
        OrionList<Integer> list = new OrionArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.filterAndLoop((Integer s) -> s > 3, this::getFilteredList);
        Assert.assertArrayEquals(filteredList.toArray(), expectedFilteredList.toArray());
    }


    private void getFilteredList(Object number)
    {
        int numberTemp = (int)number;
        filteredList.add(numberTemp);
    }


    @Test
    public void testAreListsTheSame()
    {
        OrionList<Integer> list1 = new OrionArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        OrionList<Integer> list2 = new OrionArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        Assert.assertTrue(ListService.areListsTheSame(list1, list2));
    }


    @Test
    public void testSubList()
    {
        OrionList<Integer> list1 = new OrionArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        OrionList<Integer> list2 = new OrionArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        OrionList<Integer> sublist = ListService.subList(list1, 2, 4);
        Assert.assertArrayEquals(list2.toArray(), sublist.toArray());
    }


    @Test
    public void testSwapIndices()
    {
        OrionList<Integer> list1 = new OrionArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        OrionList<Integer> list2 = new OrionArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(5);
        list2.add(4);
        list2.add(3);
        list2.add(6);
        ListService.swapIndices(list1, 2, 4);
        Assert.assertArrayEquals(list2.toArray(), list1.toArray());
    }


    @Test
    public void testReverseList()
    {
        OrionList<Integer> list1 = new OrionArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        OrionList<Integer> list2 = new OrionArrayList<Integer>();
        list2.add(6);
        list2.add(5);
        list2.add(4);
        list2.add(3);
        list2.add(2);
        list2.add(1);
        list1.reverse();
        Assert.assertArrayEquals(list1.toArray(), list2.toArray());
    }


    @Test
    public void testConcatenateLists()
    {
        OrionList<Integer> list1 = new OrionArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        OrionList<Integer> list2 = new OrionArrayList<Integer>();
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        list2.add(11);
        list2.add(12);
        OrionList<Integer> list3 = new OrionArrayList<Integer>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list3.add(6);
        list3.add(7);
        list3.add(8);
        list3.add(9);
        list3.add(10);
        list3.add(11);
        list3.add(12);
        Assert.assertArrayEquals(list3.toArray(), ListService.concatenateLists(list1, list2).toArray());
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testGetIntersection()
    {
        OrionList<String> list1 = new OrionArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        OrionList<String> list2 = new OrionArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("1");
        OrionList<String> list3 = new OrionArrayList<String>();
        list3.add("2");
        list3.add("3");
        list3.add("4");
        list3.add("5");
        list3.add("6");
        list3.add("1");
        OrionList<String> result = new OrionArrayList<String>();
        result.add("2");
        result.add("3");
        result.add("1");
        OrionList<String> result1 = new GetIntersectionTask<String>().run(list1, list2, list3);
        String[] resultArray = result.toArray(new String[0]);
        String[] result1Array = result1.toArray(new String[0]);
        Arrays.sort(resultArray);
        Arrays.sort(result1Array);
        assertArrayEquals(resultArray, result1Array);
    }
}