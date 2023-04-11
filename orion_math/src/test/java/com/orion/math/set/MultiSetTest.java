package com.orion.math.set;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class MultiSetTest
{
    @Test
    public void getUnion()
    {
        List<ANumber> numbers1 = new ArrayList<ANumber>();
        numbers1.add(ANumber.of(1));
        numbers1.add(ANumber.of(2));
        numbers1.add(ANumber.of(1));
        numbers1.add(ANumber.of(3));
        numbers1.add(ANumber.of(4));
        numbers1.add(ANumber.of(2));
        numbers1.add(ANumber.of(2));
        MultiSet set1 = MultiSet.of(numbers1);
        List<ANumber> numbers2 = new ArrayList<ANumber>();
        numbers2.add(ANumber.of(5));
        numbers2.add(ANumber.of(6));
        numbers2.add(ANumber.of(6));
        numbers2.add(ANumber.of(1));
        numbers2.add(ANumber.of(8));
        numbers2.add(ANumber.of(2));
        MultiSet set2 = MultiSet.of(numbers2);
        MultiSet result = set1.getUnion(set2);
        List<ANumber> expectedNumbers = new ArrayList<ANumber>();
        expectedNumbers.add(ANumber.of(1));
        expectedNumbers.add(ANumber.of(1));
        expectedNumbers.add(ANumber.of(2));
        expectedNumbers.add(ANumber.of(2));
        expectedNumbers.add(ANumber.of(2));
        expectedNumbers.add(ANumber.of(3));
        expectedNumbers.add(ANumber.of(4));
        expectedNumbers.add(ANumber.of(5));
        expectedNumbers.add(ANumber.of(6));
        expectedNumbers.add(ANumber.of(8));
        MultiSet expected = MultiSet.of(expectedNumbers);
        assertTrue(expected.equals(result));
    }


    @Test
    public void getIntersection()
    {
        List<ANumber> numbers1 = new ArrayList<ANumber>();
        numbers1.add(ANumber.of(1));
        numbers1.add(ANumber.of(2));
        numbers1.add(ANumber.of(1));
        numbers1.add(ANumber.of(3));
        numbers1.add(ANumber.of(4));
        numbers1.add(ANumber.of(2));
        numbers1.add(ANumber.of(2));
        MultiSet set1 = MultiSet.of(numbers1);
        List<ANumber> numbers2 = new ArrayList<ANumber>();
        numbers2.add(ANumber.of(5));
        numbers2.add(ANumber.of(6));
        numbers2.add(ANumber.of(6));
        numbers2.add(ANumber.of(1));
        numbers2.add(ANumber.of(8));
        numbers2.add(ANumber.of(2));
        MultiSet set2 = MultiSet.of(numbers2);
        MultiSet result = set1.getIntersection(set2);
        List<ANumber> expectedNumbers = new ArrayList<ANumber>();
        expectedNumbers.add(ANumber.of(1));
        expectedNumbers.add(ANumber.of(2));
        expectedNumbers.add(ANumber.of(3));
        expectedNumbers.add(ANumber.of(4));
        expectedNumbers.add(ANumber.of(5));
        expectedNumbers.add(ANumber.of(6));
        expectedNumbers.add(ANumber.of(8));
        MultiSet expected = MultiSet.of(expectedNumbers);
        assertTrue(expected.equals(result));
    }
}