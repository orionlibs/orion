package com.orion.math.geometry.vector.functional;

import com.orion.core.abstraction.OrionService;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1Service;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorService;
import com.orion.math.geometry.vector.functional.tasks.component.GetVectorOfFunction1x1ComponentTask;
import com.orion.math.geometry.vector.functional.tasks.component.GetVectorOfFunction1x1ComponentsTask;
import com.orion.math.geometry.vector.functional.tasks.cumulativity.GetVectorOfFunction1x1CumulativeProductOfVectorElementsTask;
import com.orion.math.geometry.vector.functional.tasks.cumulativity.GetVectorOfFunction1x1CumulativeReverseProductOfVectorElementsTask;
import com.orion.math.geometry.vector.functional.tasks.cumulativity.GetVectorOfFunction1x1CumulativeReverseSumOfVectorElementsTask;
import com.orion.math.geometry.vector.functional.tasks.cumulativity.GetVectorOfFunction1x1CumulativeSumOfVectorElementsTask;
import com.orion.math.geometry.vector.functional.tasks.query.GetCrossProductOf2VectorsOfFunction1x1Task;
import com.orion.math.geometry.vector.functional.tasks.query.GetDifferenceBetweenSuccessiveElementsOfVectorOfFunction1x1Task;
import com.orion.math.geometry.vector.functional.tasks.query.GetDotProductOf2VectorsOfFunction1x1Task;
import com.orion.math.geometry.vector.functional.tasks.query.GetProjectionOfVectorsOfFunction1x1OntoAnotherTask;
import com.orion.math.geometry.vector.functional.tasks.transform.NormaliseVectorOfFunction1x1Task;
import com.orion.math.geometry.vector.functional.tasks.transform.VectorOfFunction1x1AddTask;
import com.orion.math.geometry.vector.functional.tasks.transform.VectorOfFunction1x1MultiplyComponentWiseTask;
import com.orion.math.geometry.vector.functional.tasks.transform.VectorOfFunction1x1MultiplyTask;
import com.orion.math.geometry.vector.functional.tasks.transform.VectorOfFunction1x1SubtractTask;
import com.orion.math.geometry.vector.functional.tasks.trigonometry.GetAngleAsRadiansOf2VectorsOfFunction1x1Task;
import com.orion.math.geometry.vector.functional.tasks.trigonometry.GetCosineOf2VectorsOfFunction1x1Task;
import com.orion.math.geometry.vector.functional.tasks.trigonometry.GetCosineVectorOfFunction1x1WithAxisTask;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import com.orion.math.streams.NumberArrayStream;
import java.util.ArrayList;
import java.util.List;

public class VectorOfFunction1x1Service extends OrionService
{
    public static VectorOfFunction1x1 getVectorComponent(VectorOfFunction1x1 x, Axis axis)
    {
        return GetVectorOfFunction1x1ComponentTask.run(x, axis);
    }


    public static VectorOfFunction1x1 getVectorComponent(VectorOfFunction1x1 x, int axis)
    {
        return GetVectorOfFunction1x1ComponentTask.run(x, axis);
    }


    public static VectorOfFunction1x1[] getVectorComponents(VectorOfFunction1x1 x)
    {
        return GetVectorOfFunction1x1ComponentsTask.run(x);
    }


    public static Function1x1<ANumber, ANumber> getMagnitude(VectorOfFunction1x1 x)
    {
        return getMagnitude(x, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> getMagnitude(VectorOfFunction1x1 x, int squareRootPrecision)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return Function1x1Service.getSumOfSquares(x.getAsArray()).getSquareRoot(squareRootPrecision);
    }


    public static VectorOfFunction1x1 add(VectorOfFunction1x1 x, ANumber y)
    {
        return VectorOfFunction1x1AddTask.run(x, y);
    }


    public static VectorOfFunction1x1 add(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return VectorOfFunction1x1AddTask.run(x, y);
    }


    public static VectorOfFunction1x1 subtract(VectorOfFunction1x1 x, ANumber y)
    {
        return VectorOfFunction1x1SubtractTask.run(x, y);
    }


    public static VectorOfFunction1x1 subtract(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return VectorOfFunction1x1SubtractTask.run(x, y);
    }


    public static VectorOfFunction1x1 multiply(VectorOfFunction1x1 x, ANumber y)
    {
        return VectorOfFunction1x1MultiplyTask.run(x, y);
    }


    public static VectorOfFunction1x1 multiplyComponentWise(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return VectorOfFunction1x1MultiplyComponentWiseTask.run(x, y);
    }


    public static VectorOfFunction1x1 normalise(VectorOfFunction1x1 x)
    {
        return normalise(x, Precision.precision);
    }


    public static VectorOfFunction1x1 normalise(VectorOfFunction1x1 x, int precision)
    {
        return NormaliseVectorOfFunction1x1Task.run(x, precision);
    }


    public static VectorOfFunction1x1 translate(VectorOfFunction1x1 x, ANumber translationLength)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return x.add(translationLength);
    }


    public static VectorOfFunction1x1 translate(VectorOfFunction1x1 x, VectorOfFunction1x1 translationVector)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return x.add(translationVector);
    }


    public static VectorOfFunction1x1 negate(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return x.multiply(ANumber.of(-1));
    }


    public static VectorOfFunction1x1 reverseOrderOfElements(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return VectorOfFunction1x1.of(x.getElements().reverseGET());
    }


    public static VectorOfFunction1x1 reverseDirection(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return x.negate();
    }


    public static Function1x1<ANumber, ANumber> getDotProduct(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return GetDotProductOf2VectorsOfFunction1x1Task.run(x, y);
    }


    public static Function1x1<ANumber, ANumber> getCosineWithVector(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return getCosineWithVector(x, y, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> getCosineWithVector(VectorOfFunction1x1 x, VectorOfFunction1x1 y, int precision)
    {
        return GetCosineOf2VectorsOfFunction1x1Task.run(x, y, precision);
    }


    public static Function1x1<ANumber, ANumber> getCosineWithXAxis(VectorOfFunction1x1 x)
    {
        return getCosineWithAxis(x, Axis.X);
    }


    public static Function1x1<ANumber, ANumber> getCosineWithAxis(VectorOfFunction1x1 x, Axis axis)
    {
        return getCosineWithAxis(x, axis, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> getCosineWithXAxis(VectorOfFunction1x1 x, int precision)
    {
        return getCosineWithAxis(x, Axis.X, precision);
    }


    public static Function1x1<ANumber, ANumber> getCosineWithAxis(VectorOfFunction1x1 x, Axis axis, int precision)
    {
        return GetCosineVectorOfFunction1x1WithAxisTask.run(x, axis, precision);
    }


    public static VectorOfFunction1x1 getBasisVector(int dimensions, Axis axis)
    {
        Vector basisVector = VectorService.getBasisVector(dimensions, axis);
        List<Function1x1<ANumber, ANumber>> elements = new ArrayList<>();
        basisVector.forAll(e -> elements.add(Function1x1.<ANumber, ANumber>of(x -> e)));
        return VectorOfFunction1x1.of(elements);
    }


    public static VectorOfFunction1x1 getBasisVector(int dimensions, int axis)
    {
        return VectorOfFunction1x1.of(VectorService.getBasisVector(dimensions, axis));
    }


    public static Function1x1<ANumber, ANumber> getAngleWithVectorAsRadians(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return getAngleWithVectorAsRadians(x, y, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> getAngleWithVectorAsRadians(VectorOfFunction1x1 x, VectorOfFunction1x1 y, int precision)
    {
        return GetAngleAsRadiansOf2VectorsOfFunction1x1Task.run(x, y, precision);
    }


    public static Function1x1<ANumber, ANumber> getAngleWithVectorAsDegrees(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return getAngleWithVectorAsDegrees(x, y, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> getAngleWithVectorAsDegrees(VectorOfFunction1x1 x, VectorOfFunction1x1 y, int precision)
    {
        return TrigonometryService.convertRadiansToDegrees(getAngleWithVectorAsRadians(x, y, precision));
    }


    public static Function1x1<ANumber, ANumber> getAngleWithXAxisAsRadians(VectorOfFunction1x1 x)
    {
        return getCosineWithXAxis(x).getArccosineAsRadians();
    }


    public static Function1x1<ANumber, ANumber> getAngleWithXAxisAsRadians(VectorOfFunction1x1 x, int precision)
    {
        return getCosineWithXAxis(x, precision).getArccosineAsRadians();
    }


    public static Function1x1<ANumber, ANumber> getAngleWithXAxisAsDegrees(VectorOfFunction1x1 x)
    {
        return getCosineWithXAxis(x).getArccosineAsDegrees();
    }


    public static Function1x1<ANumber, ANumber> getAngleWithXAxisAsDegrees(VectorOfFunction1x1 x, int precision)
    {
        return getCosineWithXAxis(x, precision).getArccosineAsDegrees();
    }


    public static Function1x1<ANumber, ANumber> getAngleWithAxisAsRadians(VectorOfFunction1x1 x, Axis axis)
    {
        return getCosineWithAxis(x, axis).getArccosineAsRadians();
    }


    public static Function1x1<ANumber, ANumber> getAngleWithAxisAsRadians(VectorOfFunction1x1 x, Axis axis, int precision)
    {
        return getCosineWithAxis(x, axis, precision).getArccosineAsRadians();
    }


    public static Function1x1<ANumber, ANumber> getAngleWithAxisAsDegrees(VectorOfFunction1x1 x, Axis axis)
    {
        return getCosineWithAxis(x, axis).getArccosineAsDegrees();
    }


    public static Function1x1<ANumber, ANumber> getAngleWithAxisAsDegrees(VectorOfFunction1x1 x, Axis axis, int precision)
    {
        return getCosineWithAxis(x, axis, precision).getArccosineAsDegrees();
    }


    public static boolean isPerpendicularTo(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return getDotProduct(x, y).isZeroFunction();
    }


    public static boolean isNotPerpendicularTo(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return !isPerpendicularTo(x, y);
    }


    public static boolean isParallelTo(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return x.getAngleWithVectorAsDegrees(y).isZeroFunction();
    }


    public static boolean isNotParallelTo(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return !isParallelTo(x, y);
    }


    public static VectorOfFunction1x1 getProjectionOntoVector(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return GetProjectionOfVectorsOfFunction1x1OntoAnotherTask.run(x, y);
    }


    public static Function1x1<ANumber, ANumber> getLengthOfProjectionOntoVector(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return getProjectionOntoVector(x, y).getMagnitude();
    }


    public static VectorOfFunction1x1 getCrossProduct(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return GetCrossProductOf2VectorsOfFunction1x1Task.run(x, y);
    }


    public static Function1x1<ANumber, ANumber> getCrossProductMagnitude(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        Function1x1<ANumber, ANumber> angleBetweenVectorsInDegrees = getAngleWithVectorAsDegrees(x, y);
        Function1x1<ANumber, ANumber> newVectorLength = x.getMagnitude().multiply(y.getMagnitude());
        return newVectorLength.multiply(angleBetweenVectorsInDegrees.getSineInDegrees());
    }


    public static Function1x1<ANumber, ANumber> getTripleScalarProduct(VectorOfFunction1x1 x, VectorOfFunction1x1 y, VectorOfFunction1x1 z)
    {
        return getCrossProduct(x, y).getDotProduct(z);
    }


    public static Function1x1<ANumber, ANumber> getDistanceFrom(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return x.subtract(y).getMagnitude();
    }


    public static Function1x1<ANumber, ANumber> getNorm(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return x.getMagnitude();
    }


    public static Function1x1<ANumber, ANumber> getNormSquared(VectorOfFunction1x1 x)
    {
        return getNorm(x).getSquare();
    }


    public static VectorOfFunction1x1 getCumulativeSum(VectorOfFunction1x1 x)
    {
        return GetVectorOfFunction1x1CumulativeSumOfVectorElementsTask.run(x);
    }


    public static VectorOfFunction1x1 getCumulativeProduct(VectorOfFunction1x1 x)
    {
        return GetVectorOfFunction1x1CumulativeProductOfVectorElementsTask.run(x);
    }


    public static VectorOfFunction1x1 getReverseCumulativeSum(VectorOfFunction1x1 x)
    {
        return GetVectorOfFunction1x1CumulativeReverseSumOfVectorElementsTask.run(x);
    }


    public static VectorOfFunction1x1 getReverseCumulativeProduct(VectorOfFunction1x1 x)
    {
        return GetVectorOfFunction1x1CumulativeReverseProductOfVectorElementsTask.run(x);
    }


    public static VectorOfFunction1x1 getDifferenceBetweenSuccessiveElements(VectorOfFunction1x1 x)
    {
        return GetDifferenceBetweenSuccessiveElementsOfVectorOfFunction1x1Task.run(x);
    }


    public static Function1x1<ANumber, ANumber> getArithmeticAverage(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return Function1x1Service.add(x.getElements()).divide(ANumber.of(x.getDimensions()));
    }


    public static Function1x1<ANumber, ANumber> getGeometricAverage(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        return Function1x1Service.multiply(x.getElements()).getNthRoot(x.getDimensions());
    }


    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 getAbsoluteValues(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        Function1x1<ANumber, ANumber>[] elements = new Function1x1[x.getDimensions()];
        x.forAllIndices(i -> elements[i] = x.get(i).getAbsoluteValue());
        return VectorOfFunction1x1.of(elements);
    }


    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 convertToMatrix(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        Function1x1<ANumber, ANumber>[][] yTemp = new Function1x1[x.getSize()][1];
        NumberArrayStream.setValues(yTemp, x, 0);
        return MatrixOfFunction1x1.of(yTemp);
    }
}