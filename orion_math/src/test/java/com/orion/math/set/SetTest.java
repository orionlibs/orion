package com.orion.math.set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class SetTest
{
    @Test
    public void testContainsValue_true()
    {
        OrionSet<ANumber> numbers = new OrionHashSet<ANumber>();
        numbers.append(ANumber.of(1));
        numbers.append(ANumber.of(2));
        numbers.append(ANumber.of(3));
        numbers.append(ANumber.of(4));
        Set elementsTemp = new Set(numbers);
        assertTrue(elementsTemp.containsValue(ANumber.of(3)));
    }


    @Test
    public void testContainsValue_false()
    {
        OrionSet<ANumber> numbers = new OrionHashSet<ANumber>();
        numbers.append(ANumber.of(1));
        numbers.append(ANumber.of(2));
        numbers.append(ANumber.of(3));
        numbers.append(ANumber.of(4));
        Set elementsTemp = new Set(numbers);
        assertFalse(elementsTemp.containsValue(ANumber.of(5)));
    }


    @Test
    public void testEquals_true()
    {
        OrionSet<ANumber> numbers = new OrionHashSet<ANumber>();
        numbers.append(ANumber.of(1));
        numbers.append(ANumber.of(2));
        numbers.append(ANumber.of(3));
        numbers.append(ANumber.of(4));
        OrionSet<ANumber> numbers2 = new OrionHashSet<ANumber>();
        numbers2.append(ANumber.of(1));
        numbers2.append(ANumber.of(2));
        numbers2.append(ANumber.of(3));
        numbers2.append(ANumber.of(4));
        Set elementsTemp1 = new Set(numbers);
        Set elementsTemp2 = new Set(numbers2);
        assertTrue(elementsTemp1.equals(elementsTemp2));
    }


    @Test
    public void testEquals_false()
    {
        OrionSet<ANumber> numbers = new OrionHashSet<ANumber>();
        numbers.append(ANumber.of(1));
        numbers.append(ANumber.of(2));
        numbers.append(ANumber.of(3));
        numbers.append(ANumber.of(4));
        OrionSet<ANumber> numbers2 = new OrionHashSet<ANumber>();
        numbers2.append(ANumber.of(1));
        numbers2.append(ANumber.of(2));
        numbers2.append(ANumber.of(3));
        Set elementsTemp1 = new Set(numbers);
        Set elementsTemp2 = new Set(numbers2);
        assertFalse(elementsTemp1.equals(elementsTemp2));
    }


    @Test
    public void testGetUnion()
    {
        OrionSet<ANumber> numbers = new OrionHashSet<ANumber>();
        numbers.append(ANumber.of(1));
        numbers.append(ANumber.of(2));
        numbers.append(ANumber.of(3));
        numbers.append(ANumber.of(4));
        OrionSet<ANumber> numbers2 = new OrionHashSet<ANumber>();
        numbers2.append(ANumber.of(2));
        numbers2.append(ANumber.of(6));
        Set set1 = Set.of(numbers);
        Set set2 = Set.of(numbers2);
        Set union = set1.getUnion(set2);
        OrionSet<ANumber> numbers3 = new OrionHashSet<ANumber>();
        numbers3.append(ANumber.of(1));
        numbers3.append(ANumber.of(2));
        numbers3.append(ANumber.of(3));
        numbers3.append(ANumber.of(4));
        numbers3.append(ANumber.of(6));
        Set expected = Set.of(numbers3);
        assertTrue(expected.equals(union));
    }


    @Test
    public void testGetIntersection()
    {
        OrionSet<ANumber> numbers = new OrionHashSet<ANumber>();
        numbers.append(ANumber.of(1));
        numbers.append(ANumber.of(2));
        numbers.append(ANumber.of(3));
        numbers.append(ANumber.of(4));
        OrionSet<ANumber> numbers2 = new OrionHashSet<ANumber>();
        numbers2.append(ANumber.of(2));
        numbers2.append(ANumber.of(6));
        Set set1 = Set.of(numbers);
        Set set2 = Set.of(numbers2);
        Set intersection = set1.getIntersection(set2);
        OrionSet<ANumber> numbers3 = new OrionHashSet<ANumber>();
        numbers3.append(ANumber.of(2));
        Set expected = Set.of(numbers3);
        assertTrue(expected.equals(intersection));
    }


    @Test
    public void testGetDifference()
    {
        OrionSet<ANumber> numbers = new OrionHashSet<ANumber>();
        numbers.append(ANumber.of(1));
        numbers.append(ANumber.of(2));
        numbers.append(ANumber.of(3));
        numbers.append(ANumber.of(4));
        OrionSet<ANumber> numbers2 = new OrionHashSet<ANumber>();
        numbers2.append(ANumber.of(2));
        numbers2.append(ANumber.of(6));
        Set set1 = Set.of(numbers);
        Set set2 = Set.of(numbers2);
        Set difference = set1.getDifference(set2);
        OrionSet<ANumber> numbers3 = new OrionHashSet<ANumber>();
        numbers3.append(ANumber.of(1));
        numbers3.append(ANumber.of(3));
        numbers3.append(ANumber.of(4));
        Set expected = Set.of(numbers3);
        assertTrue(expected.equals(difference));
    }
}