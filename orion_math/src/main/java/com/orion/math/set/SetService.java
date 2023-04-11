package com.orion.math.set;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.exception.Assert;
import com.orion.core.stream.OrionStream;
import com.orion.math.function.Functions;
import com.orion.math.number.ANumber;
import com.orion.math.set.tasks.SetPrintTask;
import com.orion.math.set.tasks.query.GetComplementOfSetRelativeToAnotherTask;
import com.orion.math.set.tasks.query.GetPowersetTask;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SetService extends OrionService
{
    public static boolean containsValue(Set set, ANumber value)
    {
        SetRules.isValid(set);
        return set.findAny(e -> e.equal(value));
    }


    public static String print(Set set)
    {
        return new SetPrintTask().run(set);
    }


    public static Set getUnion(Set set1, OrionSet<ANumber> set2)
    {
        SetRules.isValid(set1);
        return set1.getUnion(set2);
    }


    public static void unionise(Set set1, OrionSet<ANumber> set2)
    {
        SetRules.isValid(set1);
        set1.unionise(set2);
    }


    public static Set getUnion(Set set1, Set set2)
    {
        SetRules.isValid(set1);
        return set1.getUnion(set2);
    }


    public static void unionise(Set set1, Set set2)
    {
        SetRules.isValid(set1);
        set1.unionise(set2);
    }


    @SuppressWarnings("unchecked")
    public static Set getIntersection(Set set1, OrionSet<ANumber> set2)
    {
        SetRules.isValid(set1);
        Set newSet = set1.getCopy();
        return Set.of(newSet.getElements().getIntersection(set2));
    }


    @SuppressWarnings("unchecked")
    public static Set getIntersection(Set set1, Set set2)
    {
        SetRules.isValid(set1, set2);
        Set newSet = set1.getCopy();
        return Set.of(newSet.getElements().getIntersection(set2.getElements()));
    }


    public static Set getDifference(Set set1, OrionSet<ANumber> set2)
    {
        SetRules.isValid(set1);
        Set newSet = set1.getCopy();
        return Set.of(newSet.getElements().getDifference(set2));
    }


    public static Set getDifference(Set set1, Set set2)
    {
        SetRules.isValid(set1, set2);
        Set newSet = set1.getCopy();
        return Set.of(newSet.getElements().getDifference(set2.getElements()));
    }


    public static boolean isSubset(Set set1, Set set2)
    {
        SetRules.isValid(set1, set2);
        Set newSet = set1.getCopy();
        OrionSet<ANumber> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() <= newSet.getElements().getSize();
    }


    public static boolean isProperSubset(Set set1, Set set2)
    {
        SetRules.isValid(set1, set2);
        Set newSet = set1.getCopy();
        OrionSet<ANumber> elements2 = set2.getElements();
        return !elements2.retainAll(newSet.getElements()) && elements2.getSize() < newSet.getElements().getSize();
    }


    public static Set getPowerset(Set set)
    {
        return GetPowersetTask.run(set);
    }


    public static boolean isDisjointTo(Set set1, Set set2)
    {
        SetRules.isValid(set1, set2);
        return Sets.isEmpty(set1.getIntersection(set2));
    }


    public static Set getComplementRelativeTo(Set set1, Set set2)
    {
        return GetComplementOfSetRelativeToAnotherTask.run(set1, set2);
    }


    public static Set getSymmetricDifference(Set set1, Set set2)
    {
        SetRules.isValid(set1, set2);
        return Set.of(set1.getElements().getSymmetricDifference(set2.getElements()));
    }


    public static boolean isBounded(Set set)
    {
        SetRules.isValid(set);
        return set.getMinimum().negateGET().equal(set.getMaximum());
    }


    public static TruthSet getTruthSetFor(Set set, Predicate<ANumber> filterToApply)
    {
        SetRules.isValid(set);
        Assert.notNull(filterToApply, "The filterToApply input cannot be null.");
        return TruthSet.of(OrionHashSet.<ANumber>of(OrionStream.getAsSet(set.filter(filterToApply))));
    }


    public static ANumber getNumberOfDerangements(Set set)
    {
        SetRules.isValid(set);
        ANumber n = ANumber.of(set.getSize());
        ANumber a = Functions.factorial.run(n);
        ANumber sum = ANumber.of(0);
        IntStream.range(0, set.getSize() + 1)
                        .forEach(i -> sum.add(ANumber.of(-1).exponentiateGET(n).divideGET(Functions.factorial.run(ANumber.of(i)))));
        return a.multiplyGET(sum);
    }
}