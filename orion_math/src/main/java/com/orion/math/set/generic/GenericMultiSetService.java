package com.orion.math.set.generic;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.set.generic.tasks.transform.GetDifferenceOfGenericMultiSetsTask;
import com.orion.math.set.generic.tasks.transform.GetIntersectionOfGenericMultiSetsTask;
import com.orion.math.set.generic.tasks.transform.GetSumOfGenericMultiSetsTask;
import com.orion.math.set.generic.tasks.transform.GetUnionOfGenericMultiSetsTask;

public class GenericMultiSetService extends OrionService
{
    public static boolean containsValue(GenericMultiSet genericSet, Object value)
    {
        GenericSetRules.isValid(genericSet);
        return genericSet.findAny(e -> e.equals(value));
    }


    public static GenericMultiSet getUnion(GenericMultiSet set1, OrionSet<Object> set2)
    {
        return GetUnionOfGenericMultiSetsTask.run(set1, set2);
    }


    public static GenericMultiSet getUnion(GenericMultiSet set1, GenericMultiSet set2)
    {
        GenericSetRules.isValid(set2);
        return getUnion(set1, set2.getElements());
    }


    public static GenericMultiSet getUnion(GenericMultiSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set2);
        return getUnion(set1, set2.getElements());
    }


    public static GenericMultiSet getIntersection(GenericMultiSet set1, OrionSet<Object> set2)
    {
        return GetIntersectionOfGenericMultiSetsTask.run(set1, set2);
    }


    public static GenericMultiSet getIntersection(GenericMultiSet set1, GenericMultiSet set2)
    {
        GenericSetRules.isValid(set2);
        return getIntersection(set1, set2.getElements());
    }


    public static GenericMultiSet getIntersection(GenericMultiSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set2);
        return getIntersection(set1, set2.getElements());
    }


    public static GenericMultiSet getDifference(GenericMultiSet set1, OrionSet<Object> set2)
    {
        return GetDifferenceOfGenericMultiSetsTask.run(set1, set2);
    }


    public static GenericMultiSet getDifference(GenericMultiSet set1, GenericMultiSet set2)
    {
        GenericSetRules.isValid(set2);
        return getDifference(set1, set2.getElements());
    }


    public static GenericMultiSet getDifference(GenericMultiSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set2);
        return getDifference(set1, set2.getElements());
    }


    public static GenericMultiSet getSum(GenericMultiSet set1, OrionSet<Object> set2)
    {
        return GetSumOfGenericMultiSetsTask.run(set1, set2);
    }


    public static GenericMultiSet getSum(GenericMultiSet set1, GenericMultiSet set2)
    {
        GenericSetRules.isValid(set2);
        return getSum(set1, set2.getElements());
    }


    public static GenericMultiSet getSum(GenericMultiSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set2);
        return getSum(set1, set2.getElements());
    }


    public static boolean isSubset(GenericMultiSet set1, GenericMultiSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        GenericMultiSet newSet = set1.getCopy();
        OrionSet<Object> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() <= newSet.getElements().getSize();
    }


    public static boolean isSubset(GenericMultiSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1);
        GenericSetRules.isValid(set2);
        GenericMultiSet newSet = set1.getCopy();
        OrionSet<Object> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() <= newSet.getElements().getSize();
    }


    public static boolean isProperSubset(GenericMultiSet set1, GenericMultiSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        GenericMultiSet newSet = set1.getCopy();
        OrionSet<Object> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() < newSet.getElements().getSize();
    }


    public static boolean isProperSubset(GenericMultiSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1);
        GenericSetRules.isValid(set2);
        GenericMultiSet newSet = set1.getCopy();
        OrionSet<Object> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() < newSet.getElements().getSize();
    }


    public static boolean isDisjointTo(GenericMultiSet set1, GenericMultiSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        return GenericMultiSets.isEmpty(set1.getIntersection(set2));
    }


    public static boolean isDisjointTo(GenericMultiSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1);
        GenericSetRules.isValid(set2);
        return GenericMultiSets.isEmpty(set1.getIntersection(set2));
    }
}