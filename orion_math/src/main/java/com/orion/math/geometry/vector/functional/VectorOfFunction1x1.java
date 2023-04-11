package com.orion.math.geometry.vector.functional;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.core.stream.OrionStream;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VectorOfFunction1x1 implements MathObject, Cloneable
{
    private OrionList<Function1x1<ANumber, ANumber>> elements;


    public VectorOfFunction1x1()
    {
        this.elements = OrionArrayList.<Function1x1<ANumber, ANumber>>of();
    }


    public VectorOfFunction1x1(int dimensions)
    {
        NumberRules.isNonNegative(dimensions);
        this.elements = OrionArrayList.<Function1x1<ANumber, ANumber>>of(dimensions);
    }


    public VectorOfFunction1x1(Function1x1<ANumber, ANumber>[] elements)
    {
        VectorOfFunction1x1Rules.isValid(elements);
        this.elements = OrionArrayList.<Function1x1<ANumber, ANumber>>of(elements);
    }


    public VectorOfFunction1x1(List<Function1x1<ANumber, ANumber>> elements)
    {
        VectorOfFunction1x1Rules.isValid(elements);
        this.elements = OrionArrayList.<Function1x1<ANumber, ANumber>>of(elements);
    }


    public VectorOfFunction1x1(Set<Function1x1<ANumber, ANumber>> elements)
    {
        VectorOfFunction1x1Rules.isValid(elements);
        this.elements = OrionArrayList.<Function1x1<ANumber, ANumber>>of(elements);
    }


    public VectorOfFunction1x1(Vector elements)
    {
        VectorRules.isValid(elements);
        OrionList<Function1x1<ANumber, ANumber>> elementsTemp = OrionArrayList.of();
        elements.forAll(e -> elementsTemp.add(Function1x1.<ANumber, ANumber>of(x -> e)));
        this.elements = elementsTemp;
    }


    public static VectorOfFunction1x1 of()
    {
        return new VectorOfFunction1x1();
    }


    public static VectorOfFunction1x1 of(int dimensions)
    {
        return new VectorOfFunction1x1(dimensions);
    }


    public static VectorOfFunction1x1 of(Function1x1<ANumber, ANumber>[] elements)
    {
        return new VectorOfFunction1x1(elements);
    }


    public static VectorOfFunction1x1 of(List<Function1x1<ANumber, ANumber>> elements)
    {
        return new VectorOfFunction1x1(elements);
    }


    public static VectorOfFunction1x1 of(Set<Function1x1<ANumber, ANumber>> elements)
    {
        return new VectorOfFunction1x1(elements);
    }


    public static VectorOfFunction1x1 of(Vector elements)
    {
        return new VectorOfFunction1x1(elements);
    }


    public void applyValueToFunctionElements(ANumber x)
    {
        List<Function1x1<ANumber, ANumber>> newFunctions = getElements().mapToList(function -> function.run(x))
                        .stream()
                        .map(value -> Function1x1.<ANumber, ANumber>of(x1 -> value))
                        .collect(Collectors.toList());
        this.elements = OrionArrayList.<Function1x1<ANumber, ANumber>>of(newFunctions);
    }


    public VectorOfFunction1x1 applyValueToFunctionElementsGET(ANumber x)
    {
        VectorOfFunction1x1 copy = getCopy();
        copy.applyValueToFunctionElements(x);
        return copy;
    }


    public Vector applyValueToFunctionElementsAndGetAsVector(ANumber x)
    {
        return Vector.of(getElements().mapToList(function -> function.run(x)));
    }


    public VectorOfFunction1x1 getVectorComponent(Axis axis)
    {
        return VectorOfFunction1x1Service.getVectorComponent(this, axis);
    }


    public VectorOfFunction1x1 getVectorComponent(int axis)
    {
        return VectorOfFunction1x1Service.getVectorComponent(this, axis);
    }


    public VectorOfFunction1x1[] getVectorComponents()
    {
        return VectorOfFunction1x1Service.getVectorComponents(this);
    }


    public Function1x1<ANumber, ANumber> get(int index)
    {
        return getElements().get(index);
    }


    public Function1x1<ANumber, ANumber> getMagnitude()
    {
        return VectorOfFunction1x1Service.getMagnitude(this);
    }


    public Function1x1<ANumber, ANumber> getMagnitude(int squareRootPrecision)
    {
        return VectorOfFunction1x1Service.getMagnitude(this, squareRootPrecision);
    }


    public VectorOfFunction1x1 add(ANumber x)
    {
        return VectorOfFunction1x1Service.add(this, x);
    }


    public VectorOfFunction1x1 add(VectorOfFunction1x1 y)
    {
        return VectorOfFunction1x1Service.add(this, y);
    }


    public VectorOfFunction1x1 subtract(ANumber x)
    {
        return VectorOfFunction1x1Service.subtract(this, x);
    }


    public VectorOfFunction1x1 subtract(VectorOfFunction1x1 y)
    {
        return VectorOfFunction1x1Service.subtract(this, y);
    }


    public VectorOfFunction1x1 multiply(ANumber x)
    {
        return VectorOfFunction1x1Service.multiply(this, x);
    }


    public VectorOfFunction1x1 multiplyComponentWise(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.multiplyComponentWise(this, other);
    }


    public VectorOfFunction1x1 normalise()
    {
        return VectorOfFunction1x1Service.normalise(this);
    }


    public VectorOfFunction1x1 normalise(int precision)
    {
        return VectorOfFunction1x1Service.normalise(this, precision);
    }


    public VectorOfFunction1x1 translate(ANumber translationLength)
    {
        return VectorOfFunction1x1Service.translate(this, translationLength);
    }


    public VectorOfFunction1x1 translate(VectorOfFunction1x1 translationVector)
    {
        return VectorOfFunction1x1Service.translate(this, translationVector);
    }


    public VectorOfFunction1x1 negate()
    {
        return VectorOfFunction1x1Service.negate(this);
    }


    public VectorOfFunction1x1 reverseOrderOfElements()
    {
        return VectorOfFunction1x1Service.reverseOrderOfElements(this);
    }


    public VectorOfFunction1x1 reverseDirection()
    {
        return VectorOfFunction1x1Service.reverseDirection(this);
    }


    public Function1x1<ANumber, ANumber> getDotProduct(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getDotProduct(this, other);
    }


    public Function1x1<ANumber, ANumber> getCosineWithVector(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getCosineWithVector(this, other);
    }


    public Function1x1<ANumber, ANumber> getCosineWithVector(VectorOfFunction1x1 other, int precision)
    {
        return VectorOfFunction1x1Service.getCosineWithVector(this, other, precision);
    }


    public VectorOfFunction1x1 getBasisVector(int dimensions, Axis axis)
    {
        return VectorOfFunction1x1Service.getBasisVector(dimensions, axis);
    }


    public VectorOfFunction1x1 getBasisVector(int dimensions, int axis)
    {
        return VectorOfFunction1x1Service.getBasisVector(dimensions, axis);
    }


    public Function1x1<ANumber, ANumber> getCosineWithAxis(Axis axis)
    {
        return VectorOfFunction1x1Service.getCosineWithAxis(this, axis);
    }


    public Function1x1<ANumber, ANumber> getCosineWithAxis(Axis axis, int precision)
    {
        return VectorOfFunction1x1Service.getCosineWithAxis(this, axis, precision);
    }


    public Function1x1<ANumber, ANumber> getCosineWithXAxis()
    {
        return VectorOfFunction1x1Service.getCosineWithXAxis(this);
    }


    public Function1x1<ANumber, ANumber> getCosineWithXAxis(int precision)
    {
        return VectorOfFunction1x1Service.getCosineWithXAxis(this, precision);
    }


    public Function1x1<ANumber, ANumber> getAngleWithVectorAsRadians(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getAngleWithVectorAsRadians(this, other);
    }


    public Function1x1<ANumber, ANumber> getAngleWithVectorAsRadians(VectorOfFunction1x1 other, int precision)
    {
        return VectorOfFunction1x1Service.getAngleWithVectorAsRadians(this, other, precision);
    }


    public Function1x1<ANumber, ANumber> getAngleWithVectorAsDegrees(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getAngleWithVectorAsDegrees(this, other);
    }


    public Function1x1<ANumber, ANumber> getAngleWithVectorAsDegrees(VectorOfFunction1x1 other, int precision)
    {
        return VectorOfFunction1x1Service.getAngleWithVectorAsDegrees(this, other, precision);
    }


    public Function1x1<ANumber, ANumber> getAngleWithXAxisAsRadians()
    {
        return VectorOfFunction1x1Service.getAngleWithXAxisAsRadians(this);
    }


    public Function1x1<ANumber, ANumber> getAngleWithXAxisAsRadians(int precision)
    {
        return VectorOfFunction1x1Service.getAngleWithXAxisAsRadians(this, precision);
    }


    public Function1x1<ANumber, ANumber> getAngleWithXAxisAsDegrees()
    {
        return VectorOfFunction1x1Service.getAngleWithXAxisAsDegrees(this);
    }


    public Function1x1<ANumber, ANumber> getAngleWithXAxisAsDegrees(int precision)
    {
        return VectorOfFunction1x1Service.getAngleWithXAxisAsDegrees(this, precision);
    }


    public Function1x1<ANumber, ANumber> getAngleWithAxisAsRadians(Axis axis)
    {
        return VectorOfFunction1x1Service.getAngleWithAxisAsRadians(this, axis);
    }


    public Function1x1<ANumber, ANumber> getAngleWithAxisAsRadians(Axis axis, int precision)
    {
        return VectorOfFunction1x1Service.getAngleWithAxisAsRadians(this, axis, precision);
    }


    public Function1x1<ANumber, ANumber> getAngleWithAxisAsDegrees(Axis axis)
    {
        return VectorOfFunction1x1Service.getAngleWithAxisAsDegrees(this, axis);
    }


    public Function1x1<ANumber, ANumber> getAngleWithAxisAsDegrees(Axis axis, int precision)
    {
        return VectorOfFunction1x1Service.getAngleWithAxisAsDegrees(this, axis, precision);
    }


    public boolean isPerpendicularTo(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.isPerpendicularTo(this, other);
    }


    public boolean isNotPerpendicularTo(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.isNotPerpendicularTo(this, other);
    }


    public boolean isParallelTo(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.isParallelTo(this, other);
    }


    public boolean isNotParallelTo(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.isNotParallelTo(this, other);
    }


    public VectorOfFunction1x1 getProjectionOntoVector(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getProjectionOntoVector(this, other);
    }


    public Function1x1<ANumber, ANumber> getLengthOfProjectionOntoVector(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getLengthOfProjectionOntoVector(this, other);
    }


    public VectorOfFunction1x1 getCrossProduct(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getCrossProduct(this, other);
    }


    public Function1x1<ANumber, ANumber> getCrossProductMagnitude(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getCrossProductMagnitude(this, other);
    }


    public Function1x1<ANumber, ANumber> getTripleScalarProduct(VectorOfFunction1x1 other1, VectorOfFunction1x1 other2)
    {
        return VectorOfFunction1x1Service.getTripleScalarProduct(this, other1, other2);
    }


    public Function1x1<ANumber, ANumber> getDistanceFrom(VectorOfFunction1x1 other)
    {
        return VectorOfFunction1x1Service.getDistanceFrom(this, other);
    }


    public Function1x1<ANumber, ANumber> getNorm()
    {
        return VectorOfFunction1x1Service.getNorm(this);
    }


    public Function1x1<ANumber, ANumber> getNormSquared()
    {
        return VectorOfFunction1x1Service.getNormSquared(this);
    }


    public VectorOfFunction1x1 getCumulativeSum()
    {
        return VectorOfFunction1x1Service.getCumulativeSum(this);
    }


    public VectorOfFunction1x1 getCumulativeProduct()
    {
        return VectorOfFunction1x1Service.getCumulativeProduct(this);
    }


    public VectorOfFunction1x1 getReverseCumulativeSum()
    {
        return VectorOfFunction1x1Service.getReverseCumulativeSum(this);
    }


    public VectorOfFunction1x1 getReverseCumulativeProduct()
    {
        return VectorOfFunction1x1Service.getReverseCumulativeProduct(this);
    }


    public VectorOfFunction1x1 getDifferenceBetweenSuccessiveElements()
    {
        return VectorOfFunction1x1Service.getDifferenceBetweenSuccessiveElements(this);
    }


    public Function1x1<ANumber, ANumber> getArithmeticAverage()
    {
        return VectorOfFunction1x1Service.getArithmeticAverage(this);
    }


    public Function1x1<ANumber, ANumber> getGeometricAverage()
    {
        return VectorOfFunction1x1Service.getGeometricAverage(this);
    }


    public VectorOfFunction1x1 getAbsoluteValues()
    {
        return VectorOfFunction1x1Service.getAbsoluteValues(this);
    }


    public void set(int index, Function1x1<ANumber, ANumber> element)
    {
        getElements().set(index, element);
    }


    public VectorOfFunction1x1 prepend(Function1x1<ANumber, ANumber> element)
    {
        List<Function1x1<ANumber, ANumber>> newElements = new ArrayList<>();
        newElements.add(element);
        newElements.addAll(elements.getAsList());
        return VectorOfFunction1x1.of(newElements);
    }


    public void delete(int index)
    {
        getElements().delete(index);
    }


    public void delete(int[] indices)
    {
        getElements().delete(indices);
    }


    public void delete(List<Integer> indices)
    {
        getElements().delete(indices);
    }


    public void deleteAll()
    {
        getElements().deleteAll();
    }


    public boolean isZeroVector()
    {
        return getMagnitude().isZeroFunction();
    }


    public boolean isNotZeroVector()
    {
        return !isZeroVector();
    }


    public Stream<Function1x1<ANumber, ANumber>> filter(Predicate<Function1x1<ANumber, ANumber>> filterToApply)
    {
        return getElements().filter(filterToApply);
    }


    public boolean findAny(Predicate<Function1x1<ANumber, ANumber>> filterToApply)
    {
        return getElements().findAny(filterToApply);
    }


    public boolean findAny(IntPredicate filterToApply)
    {
        return OrionStream.findAny(elements, filterToApply);
    }


    public void forAll(Consumer<Function1x1<ANumber, ANumber>> action)
    {
        getElements().forAll(action);
    }


    public void forAllIndices(IntConsumer action)
    {
        IntStream.range(0, elements.getSize()).forEach(action);
    }


    public int getDimensions()
    {
        return getSize();
    }


    public int getSize()
    {
        return getElements().getSize();
    }


    public GenericVector getAsGenericVector()
    {
        return GenericVector.of(getElements().mapToList(e -> (Object)e));
    }


    public Function1x1<ANumber, ANumber>[] getAsArray()
    {
        return getElements().getAsArray();
    }


    public Function1x1<ANumber, ANumber>[] getAsArrayCopy()
    {
        return getCopy().getElements().getAsArray();
    }


    public List<Function1x1<ANumber, ANumber>> getAsList()
    {
        return getElements().getAsList();
    }


    public List<Function1x1<ANumber, ANumber>> getAsListCopy()
    {
        return getCopy().getAsList();
    }


    public Set<Function1x1<ANumber, ANumber>> getAsHashSet()
    {
        return getElements().getAsSet();
    }


    public Set<Function1x1<ANumber, ANumber>> getAsHashSetCopy()
    {
        return getCopy().getAsHashSet();
    }


    public Function1x1<ANumber, ANumber> getFirst()
    {
        return getAsArray()[0];
    }


    public Function1x1<ANumber, ANumber> getLast()
    {
        return getAsArray()[getElements().getSize() - 1];
    }


    public Stream<Function1x1<ANumber, ANumber>> getStream()
    {
        return getAsList().stream();
    }


    @Override
    public VectorOfFunction1x1 clone() throws CloneNotSupportedException
    {
        return (VectorOfFunction1x1)CloningService.clone(this);
    }


    public VectorOfFunction1x1 getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return VectorOfFunction1x1InternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return VectorOfFunction1x1InternalService.equals(this, object);
    }


    public OrionList<Function1x1<ANumber, ANumber>> getElements()
    {
        return this.elements;
    }
}