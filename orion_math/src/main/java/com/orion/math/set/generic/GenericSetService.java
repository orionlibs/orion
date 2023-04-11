package com.orion.math.set.generic;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.set.generic.tasks.query.GetComplementOfGenericSetRelativeToTask;
import com.orion.math.set.generic.tasks.query.GetPowersetOfGenericSetTask;

public class GenericSetService extends OrionService
{
    public static boolean containsValue(GenericSet genericSet, Object value)
    {
        GenericSetRules.isValid(genericSet);
        return genericSet.findAny(e -> e.equals(value));
    }


    public static GenericSet getUnion(GenericSet set1, OrionSet<Object> set2)
    {
        GenericSetRules.isValid(set1);
        return set1.getUnion(set2);
    }


    public static void unionise(GenericSet set1, OrionSet<Object> set2)
    {
        GenericSetRules.isValid(set1);
        set1.unionise(set2);
    }


    public static GenericSet getUnion(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1);
        return set1.getUnion(set2);
    }


    public static void unionise(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1);
        set1.unionise(set2);
    }


    @SuppressWarnings("unchecked")
    public static GenericSet getIntersection(GenericSet set1, OrionSet<Object> set2)
    {
        GenericSetRules.isValid(set1);
        GenericSet newSet = set1.getCopy();
        return GenericSet.of(newSet.getElements().getIntersection(set2));
    }


    @SuppressWarnings("unchecked")
    public static GenericSet getIntersection(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        GenericSet newSet = set1.getCopy();
        return GenericSet.of(newSet.getElements().getIntersection(set2.getElements()));
    }


    public static GenericSet getDifference(GenericSet set1, OrionSet<Object> set2)
    {
        GenericSetRules.isValid(set1);
        GenericSet newSet = set1.getCopy();
        return GenericSet.of(newSet.getElements().getDifference(set2));
    }


    public static GenericSet getDifference(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        GenericSet newSet = set1.getCopy();
        return GenericSet.of(newSet.getElements().getDifference(set2.getElements()));
    }


    public static boolean isSubset(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        GenericSet newSet = set1.getCopy();
        OrionSet<Object> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() <= newSet.getElements().getSize();
    }


    public static boolean isProperSubset(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        GenericSet newSet = set1.getCopy();
        OrionSet<Object> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() < newSet.getElements().getSize();
    }


    public static GenericSet getPowerset(GenericSet genericSet)
    {
        return GetPowersetOfGenericSetTask.run(genericSet);
    }


    public static boolean isDisjointTo(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        return GenericSets.isEmpty(set1.getIntersection(set2));
    }


    public static GenericSet getComplementRelativeTo(GenericSet set1, GenericSet set2)
    {
        return GetComplementOfGenericSetRelativeToTask.run(set1, set2);
    }


    public static GenericSet getSymmetricDifference(GenericSet set1, GenericSet set2)
    {
        GenericSetRules.isValid(set1, set2);
        return GenericSet.of(set1.getElements().getSymmetricDifference(set2.getElements()));
    }
}