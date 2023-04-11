package com.orion.math.geometry.vector;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.core.stream.OrionStream;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1xN;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.average.AverageService;
import com.orion.math.number.precision.Precision;
import com.orion.math.number.services.NumberService;
import com.orion.math.streams.NumberArrayStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Vector implements MathObject, Cloneable
{
    private OrionList<ANumber> elements;
    private Point startPoint;
    private Point endPoint;


    public Vector()
    {
        ANumber[] newElements = new ANumber[3];
        NumberArrayStream.setZeroValue(newElements);
        this.elements = OrionArrayList.<ANumber>of(newElements);
        this.startPoint = Point.ofZeroPoint();
        this.endPoint = Point.ofZeroPoint();
    }


    public Vector(int dimensions)
    {
        NumberRules.isNonNegative(dimensions);
        ANumber[] newElements = new ANumber[dimensions];
        NumberArrayStream.setZeroValue(newElements);
        this.elements = OrionArrayList.<ANumber>of(newElements);
        this.startPoint = Point.ofZeroPoint(dimensions);
        this.endPoint = Point.ofZeroPoint(dimensions);
    }


    public Vector(ANumber[] elements)
    {
        VectorRules.isValid(elements);
        this.elements = OrionArrayList.<ANumber>of(elements);
        this.startPoint = Point.ofZeroPoint(elements.length);
        this.endPoint = Point.of(elements);
    }


    public Vector(List<ANumber> elements)
    {
        VectorRules.isValid(elements);
        this.elements = OrionArrayList.<ANumber>of(elements);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.toArray(new ANumber[] {}));
    }


    public Vector(Set<ANumber> elements)
    {
        VectorRules.isValid(elements);
        this.elements = OrionArrayList.<ANumber>of(elements);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.toArray(new ANumber[] {}));
    }


    public Vector(Number... elements)
    {
        VectorRules.isValid(elements);
        ANumber[] newElements = NumberService.convertNumbersToANumberObjects(elements);
        this.elements = OrionArrayList.<ANumber>of(newElements);
        this.startPoint = Point.ofZeroPoint(elements.length);
        this.endPoint = Point.of(newElements);
    }


    public Vector(String... elements)
    {
        VectorRules.isValid(elements);
        ANumber[] newElements = NumberService.convertNumberStringsToANumberObjects(elements);
        this.elements = new OrionArrayList<ANumber>(newElements);
        this.startPoint = Point.ofZeroPoint(elements.length);
        this.endPoint = Point.of(newElements);
    }


    public Vector(Point startPoint, Point endPoint)
    {
        VectorRules.isValid(startPoint, endPoint);
        this.elements = convertPointsToPositionVectorCoordinates(startPoint, endPoint);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }


    public static Vector of()
    {
        return new Vector();
    }


    public static Vector of(int dimensions)
    {
        return new Vector(dimensions);
    }


    public static Vector of(List<ANumber> elements)
    {
        return new Vector(elements);
    }


    public static Vector of(Set<ANumber> elements)
    {
        return new Vector(elements);
    }


    public static Vector of(ANumber... elements)
    {
        return new Vector(elements);
    }


    public static Vector of(Number... elements)
    {
        return new Vector(elements);
    }


    public static Vector of(String... elements)
    {
        return new Vector(elements);
    }


    public static Vector of(Point startPoint, Point endPoint)
    {
        return new Vector(startPoint, endPoint);
    }


    public static Vector ofGeneratingFunction(Function1xN<ANumber, ANumber> generatingFunction, ANumber initialFunctionInput)
    {
        FunctionRules.isValid(generatingFunction);
        return new Vector(generatingFunction.run(initialFunctionInput));
    }


    private OrionList<ANumber> convertPointsToPositionVectorCoordinates(Point startPoint, Point endPoint)
    {
        OrionList<ANumber> newCoordinates = OrionArrayList.of();

        for(int i = 0; i < startPoint.getCoordinates().length; i++)
        {
            newCoordinates.append(endPoint.getCoordinates()[i].subtractGET(startPoint.getCoordinates()[i]));
        }

        return newCoordinates;
    }


    public boolean contains(ANumber x)
    {
        return getElements().contains(x);
    }


    public boolean notContains(ANumber x)
    {
        return getElements().notContains(x);
    }


    public Vector getVectorComponent(Axis axis)
    {
        return VectorService.getVectorComponent(this, axis);
    }


    public Vector getVectorComponent(int axis)
    {
        return VectorService.getVectorComponent(this, axis);
    }


    public Vector[] getVectorComponents()
    {
        return VectorService.getVectorComponents(this);
    }


    public Vector add(Vector y)
    {
        return VectorService.add(this, y);
    }


    public Vector subtract(Vector y)
    {
        return VectorService.subtract(this, y);
    }


    public Vector multiply(ANumber y)
    {
        return VectorService.multiply(this, y);
    }


    public Vector multiplyComponentWise(Vector y)
    {
        return VectorService.multiplyComponentWise(this, y);
    }


    public ANumber getMagnitude()
    {
        return VectorService.getMagnitude(this);
    }


    public ANumber getMagnitude(int squareRootPrecision)
    {
        return VectorService.getMagnitude(this, squareRootPrecision);
    }


    public boolean isEquivalentTo(Vector other)
    {
        return VectorService.isEquivalentTo(this, other);
    }


    public boolean isEquivalentTo(Vector other, int precision)
    {
        return VectorService.isEquivalentTo(this, other, precision);
    }


    public Vector normalise()
    {
        return VectorService.normalise(this);
    }


    public Vector normalise(int precision)
    {
        return VectorService.normalise(this, precision);
    }


    public Vector translate(ANumber translationLength)
    {
        return VectorService.translate(this, translationLength);
    }


    public Vector translate(Vector translationVector)
    {
        return VectorService.translate(this, translationVector);
    }


    public Vector negate()
    {
        return VectorService.negate(this);
    }


    public Vector reverseOrderOfElements()
    {
        return VectorService.reverseOrderOfElements(this);
    }


    public Vector reverseDirection()
    {
        return VectorService.reverseDirection(this);
    }


    public ANumber getDotProduct(Vector other)
    {
        return VectorService.getDotProduct(this, other);
    }


    public ANumber getCosineWithVector(Vector other)
    {
        return VectorService.getCosineWithVector(this, other);
    }


    public ANumber getCosineWithVector(Vector other, int precision)
    {
        return VectorService.getCosineWithVector(this, other, precision);
    }


    public ANumber getCosineWithXAxis()
    {
        return VectorService.getCosineWithXAxis(this);
    }


    public ANumber getCosineWithXAxis(int precision)
    {
        return VectorService.getCosineWithXAxis(this, precision);
    }


    public ANumber getCosineWithAxis(Axis axis)
    {
        return VectorService.getCosineWithAxis(this, axis);
    }


    public ANumber getCosineWithAxis(Axis axis, int precision)
    {
        return VectorService.getCosineWithAxis(this, axis, precision);
    }


    public ANumber getAngleWithVectorAsRadians(Vector other)
    {
        return VectorService.getAngleWithVectorAsRadians(this, other);
    }


    public ANumber getAngleWithVectorAsRadians(Vector other, int precision)
    {
        return VectorService.getAngleWithVectorAsRadians(this, other, precision);
    }


    public ANumber getAngleWithVectorAsDegrees(Vector other)
    {
        return VectorService.getAngleWithVectorAsDegrees(this, other);
    }


    public ANumber getAngleWithXAxisAsRadians()
    {
        return VectorService.getAngleWithXAxisAsRadians(this);
    }


    public ANumber getAngleWithXAxisAsRadians(int precision)
    {
        return VectorService.getAngleWithXAxisAsRadians(this, precision);
    }


    public ANumber getAngleWithXAxisAsDegrees()
    {
        return VectorService.getAngleWithXAxisAsDegrees(this);
    }


    public ANumber getAngleWithXAxisAsDegrees(int precision)
    {
        return VectorService.getAngleWithXAxisAsDegrees(this, precision);
    }


    public ANumber getAngleWithAxisAsRadians(Axis axis)
    {
        return VectorService.getAngleWithAxisAsRadians(this, axis);
    }


    public ANumber getAngleWithAxisAsRadians(Axis axis, int precision)
    {
        return VectorService.getAngleWithAxisAsRadians(this, axis, precision);
    }


    public ANumber getAngleWithAxisAsDegrees(Axis axis)
    {
        return VectorService.getAngleWithAxisAsDegrees(this, axis);
    }


    public ANumber getAngleWithAxisAsDegrees(Axis axis, int precision)
    {
        return VectorService.getAngleWithAxisAsDegrees(this, axis, precision);
    }


    public LineSegment getAsLineSegment()
    {
        return LineSegment.of(startPoint.getCopy(), endPoint.getCopy());
    }


    public boolean isPerpendicularTo(Vector other)
    {
        return VectorService.isPerpendicularTo(this, other);
    }


    public boolean isPerpendicularTo(Vector other, int precision)
    {
        return VectorService.isPerpendicularTo(this, other, precision);
    }


    public boolean isNotPerpendicularTo(Vector other)
    {
        return VectorService.isNotPerpendicularTo(this, other);
    }


    public boolean isNotPerpendicularTo(Vector other, int precision)
    {
        return VectorService.isNotPerpendicularTo(this, other, precision);
    }


    public boolean isParallelTo(Vector other)
    {
        return VectorService.isParallelTo(this, other);
    }


    public boolean isParallelTo(Vector other, int precision)
    {
        return VectorService.isParallelTo(this, other, precision);
    }


    public boolean isNotParallelTo(Vector other)
    {
        return VectorService.isNotParallelTo(this, other);
    }


    public boolean isNotParallelTo(Vector other, int precision)
    {
        return VectorService.isNotParallelTo(this, other, precision);
    }


    public boolean isCodirectionalTo(Vector other)
    {
        return VectorService.isCodirectionalTo(this, other);
    }


    public boolean isCodirectionalTo(Vector other, int precision)
    {
        return VectorService.isCodirectionalTo(this, other, precision);
    }


    public boolean isAntidirectionalTo(Vector other)
    {
        return VectorService.isAntidirectionalTo(this, other);
    }


    public boolean isAntidirectionalTo(Vector other, int precision)
    {
        return VectorService.isAntidirectionalTo(this, other, precision);
    }


    public ANumber getLengthOfProjectionOntoVector(Vector other)
    {
        return VectorService.getLengthOfProjectionOntoVector(this, other);
    }


    public ANumber getLengthOfProjectionOntoVector(Vector other, int precision)
    {
        return VectorService.getLengthOfProjectionOntoVector(this, other, precision);
    }


    public Vector getProjectionOntoVector(Vector other)
    {
        return VectorService.getProjectionOntoVector(this, other);
    }


    public Vector getProjectionOntoVector(Vector other, int precision)
    {
        return VectorService.getProjectionOntoVector(this, other, precision);
    }


    public Vector getCrossProduct(Vector other)
    {
        return VectorService.getCrossProduct(this, other);
    }


    public Vector getCrossProduct(Vector other, int precision)
    {
        return VectorService.getCrossProduct(this, other, precision);
    }


    public ANumber getCrossProductMagnitude(Vector other)
    {
        return VectorService.getCrossProductLength(this, other);
    }


    public ANumber getCrossProductMagnitude(Vector other, int precision)
    {
        return VectorService.getCrossProductLength(this, other, precision);
    }


    public ANumber getTripleScalarProduct(Vector other1, Vector other2)
    {
        return VectorService.getTripleScalarProduct(this, other1, other2);
    }


    public ANumber getTripleScalarProduct(Vector other1, Vector other2, int precision)
    {
        return VectorService.getTripleScalarProduct(this, other1, other2, precision);
    }


    public ANumber getDistanceFrom(Vector other)
    {
        return VectorService.getDistanceFrom(this, other);
    }


    public ANumber getDistanceFrom(Vector other, int precision)
    {
        return VectorService.getDistanceFrom(this, other, precision);
    }


    public boolean isUnitVector()
    {
        return getMagnitude().isOne();
    }


    public boolean isUnitVector(int precision)
    {
        precision = Precision.getValidPrecision(precision);
        return getMagnitude(precision).isOne();
    }


    public Vector getEqualVectorBasedOnPoint(Point point)
    {
        return VectorService.getEqualVectorBasedOnPoint(this, point);
    }


    public boolean isOrthonormalTo(Vector other)
    {
        return VectorService.isOrthonormalTo(this, other);
    }


    public boolean isOrthonormalTo(Vector other, int precision)
    {
        return VectorService.isOrthonormalTo(this, other, precision);
    }


    public boolean isNotOrthonormalTo(Vector other)
    {
        return !isOrthonormalTo(other);
    }


    public boolean isNotOrthonormalTo(Vector other, int precision)
    {
        return !isOrthonormalTo(other, precision);
    }


    public boolean isPointBetweenVectorEndPoints(Point point)
    {
        return VectorService.isPointBetweenVectorEndPoints(this, point);
    }


    public boolean isPointNotBetweenVectorEndPoints(Point point)
    {
        return VectorService.isPointNotBetweenVectorEndPoints(this, point);
    }


    public Pair<Vector, Vector> divideVectorWithRatio(ANumber ratio)
    {
        return VectorService.divideVectorWithRatio(this, ratio);
    }


    public Point getMidpoint()
    {
        return VectorService.getMidpoint(this);
    }


    public int getLengthOfLongestIncreasingSubsequence()
    {
        return VectorService.getLengthOfLongestIncreasingSubsequence(this);
    }


    public int getLengthOfLongestStrictlyIncreasingSubsequence()
    {
        return VectorService.getLengthOfLongestStrictlyIncreasingSubsequence(this);
    }


    public int getLengthOfLongestDecreasingSubsequence()
    {
        return VectorService.getLengthOfLongestDecreasingSubsequence(this);
    }


    public int getLengthOfLongestStrictlyDecreasingSubsequence()
    {
        return VectorService.getLengthOfLongestStrictlyDecreasingSubsequence(this);
    }


    public int getLengthOfLongestStableSubsequence()
    {
        return VectorService.getLengthOfLongestStableSubsequence(this);
    }


    public ANumber getMinimum()
    {
        return VectorService.getMinimum(this);
    }


    public int getFirstIndexOfMinimum()
    {
        return VectorService.getFirstIndexOfMinimum(this);
    }


    public int getLastIndexOfMinimum()
    {
        return VectorService.getLastIndexOfMinimum(this);
    }


    public ANumber getMaximum()
    {
        return VectorService.getMaximum(this);
    }


    public int getFirstIndexOfMaximum()
    {
        return VectorService.getFirstIndexOfMaximum(this);
    }


    public int getLastIndexOfMaximum()
    {
        return VectorService.getLastIndexOfMaximum(this);
    }


    public ANumber getNorm()
    {
        return VectorService.getNorm(this);
    }


    public ANumber getNorm(int precision)
    {
        return VectorService.getNorm(this, precision);
    }


    public ANumber getNormSquared()
    {
        return getNorm().squareGET();
    }


    public ANumber getNormSquared(int precision)
    {
        return getNorm(precision).squareGET();
    }


    public ANumber getNormInfinitum()
    {
        return VectorService.getNormInfinitum(this);
    }


    public Vector getCumulativeSum()
    {
        return VectorService.getCumulativeSum(this);
    }


    public Vector getCumulativeProduct()
    {
        return VectorService.getCumulativeProduct(this);
    }


    public Vector getReverseCumulativeSum()
    {
        return VectorService.getReverseCumulativeSum(this);
    }


    public Vector getReverseCumulativeProduct()
    {
        return VectorService.getReverseCumulativeProduct(this);
    }


    public Vector getDifferencesBetweenSuccessiveElements()
    {
        return VectorService.getDifferencesBetweenSuccessiveElements(this);
    }


    public ANumber getArithmeticAverage()
    {
        return AverageService.getArithmeticAverage(this);
    }


    public ANumber getGeometricAverage()
    {
        return AverageService.getGeometricAverage(this);
    }


    public ANumber getHarmonicAverage()
    {
        return AverageService.getHarmonicAverage(this);
    }


    public ANumber getQuadraticAverage()
    {
        return AverageService.getQuadraticAverage(this);
    }


    public GenericVector getAsGenericVector()
    {
        return GenericVector.of(getElements().mapToList(e -> (Object)e));
    }


    public ANumber[] getAsArray()
    {
        return getElements().getAsArray();
    }


    public ANumber[] getAsArrayCopy()
    {
        return getCopy().getElements().getAsArray();
    }


    public List<ANumber> getAsList()
    {
        return getElements().getAsList();
    }


    public List<ANumber> getAsListCopy()
    {
        return getCopy().getAsList();
    }


    public OrionList<ANumber> getAsOrionList()
    {
        return getElements();
    }


    public OrionList<ANumber> getAsOrionListCopy()
    {
        return getCopy().getAsOrionList();
    }


    public Set<ANumber> getAsHashSet()
    {
        return getElements().getAsSet();
    }


    public Set<ANumber> getAsHashSetCopy()
    {
        return getCopy().getAsHashSet();
    }


    public com.orion.math.set.Set getAsSet()
    {
        return com.orion.math.set.Set.of(getAsOrionList());
    }


    public com.orion.math.set.Set getAsSetCopy()
    {
        return getCopy().getAsSet();
    }


    public ANumber[] getStartPointCoordinates()
    {
        return getStartPoint().getCoordinates();
    }


    public ANumber[] getEndPointCoordinates()
    {
        return getEndPoint().getCoordinates();
    }


    public int getDimensions()
    {
        return getSize();
    }


    public ANumber getDimensionsAsNumber()
    {
        return ANumber.of(getDimensions());
    }


    public boolean isZeroVector()
    {
        return getMagnitude().isZero();
    }


    public boolean isNotZeroVector()
    {
        return !isZeroVector();
    }


    public Vector getAbsoluteValues()
    {
        return VectorService.getAbsoluteValues(this);
    }


    public int getSize()
    {
        return getElements().getSize();
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    public Stream<ANumber> getStream()
    {
        return getAsList().stream();
    }


    public Stream<ANumber> filter(Predicate<ANumber> filterToApply)
    {
        return getElements().filter(filterToApply);
    }


    public boolean findAny(Predicate<ANumber> filterToApply)
    {
        return getElements().findAny(filterToApply);
    }


    public boolean findAny(IntPredicate filterToApply)
    {
        return OrionStream.findAny(elements, filterToApply);
    }


    public void forAll(Consumer<ANumber> action)
    {
        getElements().forAll(action);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void forAllIndices(IntConsumer action)
    {
        IntStream.range(0, elements.getSize()).forEach(action);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void forAll(Stream<ANumber> stream, Consumer<ANumber> action)
    {
        getElements().forAll(stream, action);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void forAllIndices(IntStream stream, IntConsumer action)
    {
        OrionStream.forAll(stream, action);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void filterAndLoop(Predicate<ANumber> filterToApply, Consumer<ANumber> action)
    {
        forAll(filter(filterToApply), action);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void filterAndLoopIndices(IntPredicate filterToApply, IntConsumer action)
    {
        OrionStream.filterAndLoop(elements, filterToApply, action);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void sort()
    {
        getElements().sort();
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public Vector sortGET()
    {
        Vector copy = getCopy();
        copy.sort();
        return copy;
    }


    public void sortReverse()
    {
        getElements().sortReverse();
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public Vector sortReverseGET()
    {
        Vector copy = getCopy();
        copy.sortReverse();
        return copy;
    }


    public Vector normaliseFrom0To1()
    {
        return VectorService.normaliseFrom0To1(this);
    }


    public ANumber getFirst()
    {
        return getAsArray()[0];
    }


    public ANumber getLast()
    {
        return getAsArray()[getElements().getSize() - 1];
    }


    public void set(int index, ANumber element)
    {
        getElements().set(index, element);
        getEndPoint().set(index, element);
    }


    public Vector prepend(ANumber element)
    {
        List<ANumber> newElements = new ArrayList<ANumber>();
        newElements.add(element);
        newElements.addAll(elements.getAsList());
        return Vector.of(newElements);
    }


    public void delete(int index)
    {
        getElements().delete(index);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void delete(int[] indices)
    {
        getElements().delete(indices);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void delete(List<Integer> indices)
    {
        getElements().delete(indices);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void deleteAll()
    {
        getElements().deleteAll();
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public void deleteAllOccurencesOf(ANumber element)
    {
        getElements().deleteAllOccurencesOf(element);
        this.startPoint = Point.ofZeroPoint(elements.size());
        this.endPoint = Point.of(elements.getAsArray());
    }


    public ANumber get(int index)
    {
        return getElements().get(index);
    }


    public List<ANumber> getTheFirstNLargestElementsSorted(int n)
    {
        return VectorService.getTheFirstNLargestElementsSorted(this, n);
    }


    public List<ANumber> getTheFirstNSmallestElementsSorted(int n)
    {
        return VectorService.getTheFirstNSmallestElementsSorted(this, n);
    }


    public List<Integer> getIndicesOfOccurenceOfElement(ANumber element)
    {
        return VectorService.getIndicesOfOccurenceOfElement(this, element);
    }


    public ANumber getCopy(int index)
    {
        return get(index).getCopy();
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < getDimensions(); i++)
        {
            sb.append(get(i));

            if(i < getDimensions() - 1)
            {
                sb.append(", ");
            }

        }

        return sb.toString();
    }


    public String toStringWithPoints()
    {
        return getStartPoint().print() + " - " + getEndPoint().print();
    }


    @Override
    public Vector clone() throws CloneNotSupportedException
    {
        return (Vector)CloningService.clone(this);
    }


    public Vector getCopy()
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
        return VectorInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return VectorInternalService.equals(this, object);
    }


    public OrionList<ANumber> getElements()
    {
        return this.elements;
    }


    public void setElements(OrionList<ANumber> elements)
    {
        this.elements = elements;
    }


    public Point getStartPoint()
    {
        return this.startPoint;
    }


    public Point getStartPointCopy()
    {
        return getStartPoint().getCopy();
    }


    public void setStartPoint(Point startPoint)
    {
        this.startPoint = startPoint;
    }


    public Point getEndPoint()
    {
        return this.endPoint;
    }


    public Point getEndPointCopy()
    {
        return getEndPoint().getCopy();
    }


    public void setEndPoint(Point endPoint)
    {
        this.endPoint = endPoint;
    }
}