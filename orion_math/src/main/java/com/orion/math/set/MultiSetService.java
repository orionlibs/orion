package com.orion.math.set;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.number.ANumber;
import com.orion.math.set.tasks.SetPrintTask;
import com.orion.math.set.tasks.transform.GetDifferenceOfMultiSetsTask;
import com.orion.math.set.tasks.transform.GetIntersectionOfMultiSetsTask;
import com.orion.math.set.tasks.transform.GetSumOfMultiSetsTask;
import com.orion.math.set.tasks.transform.GetUnionOfMultiSetsTask;

public class MultiSetService extends OrionService
{
    public static boolean containsValue(MultiSet set, ANumber value)
    {
        SetRules.isValid(set);
        return set.findAny(e -> e.equal(value));
    }


    public static String print(MultiSet set)
    {
        return new SetPrintTask().run(set);
    }


    public static MultiSet getUnion(MultiSet set1, OrionSet<ANumber> set2)
    {
        return GetUnionOfMultiSetsTask.run(set1, set2);
    }


    public static MultiSet getUnion(MultiSet set1, MultiSet set2)
    {
        SetRules.isValid(set2);
        return getUnion(set1, set2.getElements());
    }


    public static MultiSet getUnion(MultiSet set1, Set set2)
    {
        SetRules.isValid(set2);
        return getUnion(set1, set2.getElements());
    }


    public static MultiSet getIntersection(MultiSet set1, OrionSet<ANumber> set2)
    {
        return GetIntersectionOfMultiSetsTask.run(set1, set2);
    }


    public static MultiSet getIntersection(MultiSet set1, Set set2)
    {
        SetRules.isValid(set2);
        return getIntersection(set1, set2.getElements());
    }


    public static MultiSet getIntersection(MultiSet set1, MultiSet set2)
    {
        SetRules.isValid(set2);
        return getIntersection(set1, set2.getElements());
    }


    public static MultiSet getDifference(MultiSet set1, OrionSet<ANumber> set2)
    {
        return GetDifferenceOfMultiSetsTask.run(set1, set2);
    }


    public static MultiSet getDifference(MultiSet set1, Set set2)
    {
        SetRules.isValid(set2);
        return getDifference(set1, set2.getElements());
    }


    public static MultiSet getDifference(MultiSet set1, MultiSet set2)
    {
        SetRules.isValid(set2);
        return getDifference(set1, set2.getElements());
    }


    public static MultiSet getSum(MultiSet set1, OrionSet<ANumber> set2)
    {
        return GetSumOfMultiSetsTask.run(set1, set2);
    }


    public static MultiSet getSum(MultiSet set1, Set set2)
    {
        SetRules.isValid(set2);
        return getSum(set1, set2.getElements());
    }


    public static MultiSet getSum(MultiSet set1, MultiSet set2)
    {
        SetRules.isValid(set2);
        return getSum(set1, set2.getElements());
    }


    public static boolean isSubset(MultiSet set1, Set set2)
    {
        SetRules.isValid(set1);
        SetRules.isValid(set2);
        MultiSet newSet = set1.getCopy();
        OrionSet<ANumber> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() <= newSet.getElements().getSize();
    }


    public static boolean isSubset(MultiSet set1, MultiSet set2)
    {
        SetRules.isValid(set1, set2);
        MultiSet newSet = set1.getCopy();
        OrionSet<ANumber> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() <= newSet.getElements().getSize();
    }


    public static boolean isProperSubset(MultiSet set1, Set set2)
    {
        SetRules.isValid(set1);
        SetRules.isValid(set2);
        MultiSet newSet = set1.getCopy();
        OrionSet<ANumber> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() < newSet.getElements().getSize();
    }


    public static boolean isProperSubset(MultiSet set1, MultiSet set2)
    {
        SetRules.isValid(set1, set2);
        MultiSet newSet = set1.getCopy();
        OrionSet<ANumber> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() < newSet.getElements().getSize();
    }


    public static boolean isDisjointTo(MultiSet set1, MultiSet set2)
    {
        SetRules.isValid(set1, set2);
        return MultiSets.isEmpty(set1.getIntersection(set2));
    }


    public static boolean isDisjointTo(MultiSet set1, Set set2)
    {
        SetRules.isValid(set1);
        SetRules.isValid(set2);
        return MultiSets.isEmpty(set1.getIntersection(set2));
    }


    public static boolean isBounded(MultiSet set)
    {
        SetRules.isValid(set);
        return set.getMinimum().negateGET().equal(set.getMaximum());
    }
}