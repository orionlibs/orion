package com.orion.core.data_structure.set;

import static org.junit.Assert.assertArrayEquals;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.tasks.GetIntersectionTask;
import com.orion.core.data.structure.set.type.OrionHashSet;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class OrionSetTest extends Orion
{
    @BeforeAll
    public void setUp() throws Exception
    {
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testGetIntersection()
    {
        OrionSet<String> set1 = new OrionHashSet<String>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        OrionSet<String> set2 = new OrionHashSet<String>();
        set2.add("2");
        set2.add("3");
        set2.add("1");
        OrionSet<String> set3 = new OrionHashSet<String>();
        set3.add("2");
        set3.add("3");
        set3.add("4");
        set3.add("5");
        set3.add("6");
        set3.add("1");
        OrionList<String> result = new OrionArrayList<String>();
        result.add("2");
        result.add("3");
        result.add("1");
        OrionList<String> result1 = new OrionArrayList<String>(GetIntersectionTask.run(set1, set2, set3));
        String[] resultArray = result.toArray(new String[0]);
        String[] result1Array = result1.toArray(new String[0]);
        Arrays.sort(resultArray);
        Arrays.sort(result1Array);
        assertArrayEquals(resultArray, result1Array);
    }
}