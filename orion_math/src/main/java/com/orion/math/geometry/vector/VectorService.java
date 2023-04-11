package com.orion.math.geometry.vector;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.geometry.vector.tasks.ConvertVectorToMatrixTask;
import com.orion.math.geometry.vector.tasks.DivideVectorWithRatioTask;
import com.orion.math.geometry.vector.tasks.FlattenVectorsTask;
import com.orion.math.geometry.vector.tasks.check.AreVectorsAtEquilibriumTask;
import com.orion.math.geometry.vector.tasks.check.AreVectorsLinearlyDependentTask;
import com.orion.math.geometry.vector.tasks.check.AreVectorsOrthonormalTask;
import com.orion.math.geometry.vector.tasks.component.GetVectorComponentTask;
import com.orion.math.geometry.vector.tasks.component.GetVectorComponentsTask;
import com.orion.math.geometry.vector.tasks.cumulativity.GetCumulativeProductOfVectorElementsTask;
import com.orion.math.geometry.vector.tasks.cumulativity.GetReverseCumulativeProductOfVectorElementsTask;
import com.orion.math.geometry.vector.tasks.cumulativity.GetReverseCumulativeSumOfVectorElementsTask;
import com.orion.math.geometry.vector.tasks.cumulativity.GetVectorCumulativeSumOfVectorElementsTask;
import com.orion.math.geometry.vector.tasks.product.GetCrossProductLengthOf2VectorsTask;
import com.orion.math.geometry.vector.tasks.product.GetCrossProductOf2VectorsTask;
import com.orion.math.geometry.vector.tasks.product.GetDotProductOf2VectorsTask;
import com.orion.math.geometry.vector.tasks.product.VectorMultiplyComponentWiseTask;
import com.orion.math.geometry.vector.tasks.product.VectorMultiplyTask;
import com.orion.math.geometry.vector.tasks.query.GetAbsoluteValuesOfVectorElementsTask;
import com.orion.math.geometry.vector.tasks.query.GetBasisVectorBasedonDimensionsAndAxisTask;
import com.orion.math.geometry.vector.tasks.query.GetDifferencesBetweenSuccessiveElementsOfVectorTask;
import com.orion.math.geometry.vector.tasks.query.GetDisplacementVectorOf2PointsTask;
import com.orion.math.geometry.vector.tasks.query.GetEqualVectorBasedOnPointTask;
import com.orion.math.geometry.vector.tasks.query.GetFirstIndexOfMaximumVectorElementTask;
import com.orion.math.geometry.vector.tasks.query.GetFirstIndexOfMinimumVectorElementTask;
import com.orion.math.geometry.vector.tasks.query.GetIndicesOfOccurenceOfVectorElementTask;
import com.orion.math.geometry.vector.tasks.query.GetLastIndexOfMaximumVectorElementTask;
import com.orion.math.geometry.vector.tasks.query.GetLastIndexOfMinimumVectorElementTask;
import com.orion.math.geometry.vector.tasks.query.GetMidpointOfVectorTask;
import com.orion.math.geometry.vector.tasks.query.GetTheFirstNLargestVectorElementsTask;
import com.orion.math.geometry.vector.tasks.query.GetTheFirstNSmallestVectorElementsTask;
import com.orion.math.geometry.vector.tasks.query.SortAndMap2VectorsTogetherTask;
import com.orion.math.geometry.vector.tasks.subsequence.GetLengthOfLongestDecreasingSubsequenceInVectorTask;
import com.orion.math.geometry.vector.tasks.subsequence.GetLengthOfLongestIncreasingSubsequenceInVectorTask;
import com.orion.math.geometry.vector.tasks.subsequence.GetLengthOfLongestStableSubsequenceInVectorTask;
import com.orion.math.geometry.vector.tasks.subsequence.GetLengthOfLongestStrictlyDecreasingSubsequenceInVectorTask;
import com.orion.math.geometry.vector.tasks.subsequence.GetLengthOfLongestStrictlyIncreasingSubsequenceInVectorTask;
import com.orion.math.geometry.vector.tasks.transform.NegateVectorTask;
import com.orion.math.geometry.vector.tasks.transform.NormaliseVectorFrom0To1Task;
import com.orion.math.geometry.vector.tasks.transform.NormaliseVectorTask;
import com.orion.math.geometry.vector.tasks.transform.TranslateVectorTask;
import com.orion.math.geometry.vector.tasks.transform.VectorAddTask;
import com.orion.math.geometry.vector.tasks.transform.VectorSubtractTask;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.precision.Precision;
import java.util.List;
import java.util.stream.IntStream;

public class VectorService extends OrionService
{
    public static boolean isEquivalentTo(Vector x, Vector y)
    {
        return isEquivalentTo(x, y, Precision.precision);
    }


    public static boolean isEquivalentTo(Vector x, Vector y, int precision)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y);
        precision = Precision.getValidPrecision(precision);
        return x.isParallelTo(y, precision) && x.getMagnitude(precision).equal(y.getMagnitude(precision));
    }


    public static Vector add(Vector x, Vector y)
    {
        return VectorAddTask.run(x, y);
    }


    public static Vector subtract(Vector x, Vector y)
    {
        return VectorSubtractTask.run(x, y);
    }


    public static Vector multiply(Vector x, ANumber y)
    {
        return VectorMultiplyTask.run(x, y);
    }


    public static Vector multiplyComponentWise(Vector x, Vector y)
    {
        return VectorMultiplyComponentWiseTask.run(x, y);
    }


    public static ANumber getMagnitude(Vector x)
    {
        return getMagnitude(x, Precision.precision);
    }


    public static ANumber getMagnitude(Vector x, int squareRootPrecision)
    {
        VectorRules.isValid(x);
        return ArithmeticService.getSumOfSquares(x.getAsArray()).getSquareRoot(squareRootPrecision);
    }


    public static Vector normalise(Vector x)
    {
        return normalise(x, Precision.precision);
    }


    public static Vector normalise(Vector x, int precision)
    {
        return NormaliseVectorTask.run(x, precision);
    }


    public static Vector translate(Vector x, ANumber translationLength)
    {
        return TranslateVectorTask.run(x, translationLength);
    }


    public static Vector translate(Vector x, Vector translationVector)
    {
        VectorRules.doVectorSizesMatch(x, translationVector);
        return x.add(translationVector);
    }


    public static Vector negate(Vector x)
    {
        return NegateVectorTask.run(x);
    }


    public static Vector reverseDirection(Vector x)
    {
        VectorRules.isValid(x);
        return Vector.of(x.getEndPoint(), x.getStartPoint());
    }


    public static Vector reverseOrderOfElements(Vector x)
    {
        VectorRules.isValid(x);
        return Vector.of(x.getElements().reverseGET());
    }


    public static Vector getDisplacementVector(Point point1, Point point2)
    {
        return GetDisplacementVectorOf2PointsTask.run(point1, point2);
    }


    public static Vector getBasisVector(int dimensions, Axis axis)
    {
        return GetBasisVectorBasedonDimensionsAndAxisTask.run(dimensions, axis);
    }


    public static Vector getBasisVector(int dimensions, int axis)
    {
        return GetBasisVectorBasedonDimensionsAndAxisTask.run(dimensions, axis);
    }


    public static Vector getVectorComponent(Vector x, Axis axis)
    {
        return GetVectorComponentTask.run(x, axis);
    }


    public static Vector getVectorComponent(Vector x, int axis)
    {
        return GetVectorComponentTask.run(x, axis);
    }


    public static Vector[] getVectorComponents(Vector x)
    {
        return GetVectorComponentsTask.run(x);
    }


    public static ANumber getDotProduct(Vector x, Vector y)
    {
        return GetDotProductOf2VectorsTask.run(x, y);
    }


    public static ANumber getCosineWithVector(Vector x, Vector y)
    {
        return getCosineWithVector(x, y, Precision.precision);
    }


    public static ANumber getCosineWithVector(Vector x, Vector y, int precision)
    {

        if(x.isZeroVector() || y.isZeroVector())
        {
            return ANumber.ofNaN();
        }
        else
        {
            return getDotProduct(x, y).divideGET(x.getMagnitude(precision).multiplyGET(y.getMagnitude(precision)));
        }

    }


    public static ANumber getCosineWithXAxis(Vector x)
    {
        return getCosineWithAxis(x, Axis.X);
    }


    public static ANumber getCosineWithXAxis(Vector x, int precision)
    {
        return getCosineWithAxis(x, Axis.X, precision);
    }


    public static ANumber getCosineWithAxis(Vector x, Axis axis)
    {
        return getCosineWithAxis(x, axis, Precision.precision);
    }


    public static ANumber getCosineWithAxis(Vector x, Axis axis, int precision)
    {

        if(x.isZeroVector())
        {
            return ANumber.ofNaN();
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            Vector axisVector = getBasisVector(x.getDimensions(), axis);
            return getDotProduct(x, axisVector).divideGET(x.getMagnitude(precision));
        }

    }


    public static ANumber getAngleWithVectorAsRadians(Vector x, Vector y)
    {
        return getAngleWithVectorAsRadians(x, y, Precision.precision);
    }


    public static ANumber getAngleWithVectorAsRadians(Vector x, Vector y, int precision)
    {

        if(x.isZeroVector() || y.isZeroVector())
        {
            return ANumber.ofNaN();
        }
        else
        {
            ANumber cosine = getDotProduct(x, y).divideGET(x.getMagnitude(precision).multiplyGET(y.getMagnitude(precision)));
            return TrigonometryService.getArccosineAsRadians(cosine, precision);
        }

    }


    public static ANumber getAngleWithVectorAsDegrees(Vector x, Vector y)
    {
        return getAngleWithVectorAsDegrees(x, y, Precision.precision);
    }


    public static ANumber getAngleWithVectorAsDegrees(Vector x, Vector y, int precision)
    {

        if(x.isZeroVector() || y.isZeroVector())
        {
            return ANumber.ofNaN();
        }
        else
        {
            ANumber cosine = getDotProduct(x, y).divideGET(x.getMagnitude(precision).multiplyGET(y.getMagnitude(precision)));
            return TrigonometryService.getArccosineAsDegrees(cosine.applyPrecisionGET(precision), precision);
        }

    }


    public static ANumber getAngleWithXAxisAsRadians(Vector x)
    {
        return TrigonometryService.getArccosineAsRadians(getCosineWithXAxis(x));
    }


    public static ANumber getAngleWithXAxisAsRadians(Vector x, int precision)
    {
        return TrigonometryService.getArccosineAsRadians(getCosineWithXAxis(x, precision), precision);
    }


    public static ANumber getAngleWithXAxisAsDegrees(Vector x)
    {
        return TrigonometryService.getArccosineAsDegrees(getCosineWithXAxis(x));
    }


    public static ANumber getAngleWithXAxisAsDegrees(Vector x, int precision)
    {
        return TrigonometryService.getArccosineAsDegrees(getCosineWithXAxis(x, precision), precision);
    }


    public static ANumber getAngleWithAxisAsRadians(Vector x, Axis axis)
    {
        return TrigonometryService.getArccosineAsRadians(getCosineWithAxis(x, axis));
    }


    public static ANumber getAngleWithAxisAsRadians(Vector x, Axis axis, int precision)
    {
        return TrigonometryService.getArccosineAsRadians(getCosineWithAxis(x, axis, precision), precision);
    }


    public static ANumber getAngleWithAxisAsDegrees(Vector x, Axis axis)
    {
        return TrigonometryService.getArccosineAsDegrees(getCosineWithAxis(x, axis));
    }


    public static ANumber getAngleWithAxisAsDegrees(Vector x, Axis axis, int precision)
    {
        return TrigonometryService.getArccosineAsDegrees(getCosineWithAxis(x, axis, precision), precision);
    }


    public static boolean isPerpendicularTo(Vector x, Vector y)
    {
        return getDotProduct(x, y).isZero();
    }


    public static boolean isPerpendicularTo(Vector x, Vector y, int precision)
    {
        precision = Precision.getValidPrecision(precision);
        return getDotProduct(x, y).applyPrecisionGET(precision).isZero();
    }


    public static boolean isNotPerpendicularTo(Vector x, Vector y)
    {
        return !isPerpendicularTo(x, y);
    }


    public static boolean isNotPerpendicularTo(Vector x, Vector y, int precision)
    {
        return !isPerpendicularTo(x, y, precision);
    }


    public static boolean isParallelTo(Vector x, Vector y)
    {
        return isParallelTo(x, y, Precision.precision);
    }


    public static boolean isParallelTo(Vector x, Vector y, int precision)
    {
        ANumber angleBetweenVectors = x.getAngleWithVectorAsDegrees(y);
        precision = Precision.getValidPrecision(precision - 2);
        angleBetweenVectors.applyPrecision(precision);
        return angleBetweenVectors.isZero() || angleBetweenVectors.equal(180);
    }


    public static boolean isNotParallelTo(Vector x, Vector y)
    {
        return !isParallelTo(x, y);
    }


    public static boolean isNotParallelTo(Vector x, Vector y, int precision)
    {
        return !isParallelTo(x, y, precision);
    }


    public static ANumber getLengthOfProjectionOntoVector(Vector x, Vector y)
    {
        return getLengthOfProjectionOntoVector(x, y, Precision.precision);
    }


    public static ANumber getLengthOfProjectionOntoVector(Vector x, Vector y, int precision)
    {
        return getProjectionOntoVector(x, y, precision).getMagnitude(precision);
    }


    public static Vector getProjectionOntoVector(Vector x, Vector y)
    {
        return getProjectionOntoVector(x, y, Precision.precision);
    }


    public static Vector getProjectionOntoVector(Vector x, Vector y, int precision)
    {

        if(x.isZeroVector() || y.isZeroVector())
        {
            return Vector.of(x.getDimensions());
        }
        else
        {
            ANumber length = getDotProduct(x, y).divideGET(y.getMagnitude(precision));
            return y.normalise(precision).multiply(length);
        }

    }


    public static Vector getCrossProduct(Vector x, Vector y)
    {
        return getCrossProduct(x, y, Precision.precision);
    }


    public static Vector getCrossProduct(Vector x, Vector y, int precision)
    {
        ANumber angleBetweenVectorsInDegrees = getAngleWithVectorAsDegrees(x, y, precision);
        return GetCrossProductOf2VectorsTask.run(x, y, angleBetweenVectorsInDegrees);
    }


    public static ANumber getCrossProductLength(Vector x, Vector y)
    {
        ANumber angleBetweenVectorsInDegrees = getAngleWithVectorAsDegrees(x, y);
        return GetCrossProductLengthOf2VectorsTask.run(x, y, angleBetweenVectorsInDegrees);
    }


    public static ANumber getCrossProductLength(Vector x, Vector y, int precision)
    {
        ANumber angleBetweenVectorsInDegrees = getAngleWithVectorAsDegrees(x, y, precision);
        return GetCrossProductLengthOf2VectorsTask.run(x, y, angleBetweenVectorsInDegrees);
    }


    public static ANumber getTripleScalarProduct(Vector x, Vector y, Vector z)
    {
        return getTripleScalarProduct(x, y, z, Precision.precision);
    }


    public static ANumber getTripleScalarProduct(Vector x, Vector y, Vector z, int precision)
    {
        return getCrossProduct(x, y, precision).getDotProduct(z);
    }


    public static ANumber getDistanceFrom(Vector x, Vector y)
    {
        return getDistanceFrom(x, y, Precision.precision);
    }


    public static ANumber getDistanceFrom(Vector x, Vector y, int precision)
    {
        VectorRules.areValid(x, y);
        return x.subtract(y).getMagnitude(precision);
    }


    public static Vector[] getStandardBasis(int dimensions)
    {
        VectorRules.isValidDimensions(dimensions);
        Vector[] result = new Vector[dimensions];
        IntStream.range(1, dimensions + 1).forEach(i -> result[i - 1] = getBasisVector(dimensions, Axis.of(i)));
        return result;
    }


    public static boolean isCodirectionalTo(Vector x, Vector y)
    {
        return isCodirectionalTo(x, y, Precision.precision);
    }


    public static boolean isCodirectionalTo(Vector x, Vector y, int precision)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y);
        return y.getMagnitude(precision).divideGET(x.getMagnitude(precision)).isPositive();
    }


    public static boolean isAntidirectionalTo(Vector x, Vector y)
    {
        return isAntidirectionalTo(x, y, Precision.precision);
    }


    public static boolean isAntidirectionalTo(Vector x, Vector y, int precision)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y);
        return y.getMagnitude(precision).divideGET(x.getMagnitude(precision)).isNegative();
    }


    public static Vector getEqualVectorBasedOnPoint(Vector x, Point point)
    {
        return GetEqualVectorBasedOnPointTask.run(x, point);
    }


    public static boolean areVectorsLinearlyDependent(List<Vector> vectors)
    {
        return AreVectorsLinearlyDependentTask.run(vectors);
    }


    public static boolean areVectorsLinearlyDependent(Vector... vectors)
    {
        return AreVectorsLinearlyDependentTask.run(vectors);
    }


    public static boolean areVectorsLinearlyIndependent(List<Vector> vectors)
    {
        return !areVectorsLinearlyDependent(vectors);
    }


    public static boolean areVectorsLinearlyIndependent(Vector... vectors)
    {
        return !areVectorsLinearlyDependent(vectors);
    }


    public static boolean isOrthonormalTo(Vector x, Vector y)
    {
        return isOrthonormalTo(x, y, Precision.precision);
    }


    public static boolean isOrthonormalTo(Vector x, Vector y, int precision)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y);
        return x.getMagnitude(precision).isOne() && y.getMagnitude(precision).isOne() && x.isPerpendicularTo(y, precision);
    }


    public static boolean areVectorsOrthonormal(List<Vector> vectors)
    {
        return AreVectorsOrthonormalTask.run(vectors, Precision.precision);
    }


    public static boolean areVectorsOrthonormal(List<Vector> vectors, int precision)
    {
        return AreVectorsOrthonormalTask.run(vectors, precision);
    }


    public static boolean isPointBetweenVectorEndPoints(Vector x, Point point)
    {
        VectorRules.isValid(x);
        PointRules.isValid(point);
        PointRules.doDimensionsMatch(x.getStartPoint(), point);
        return x.getAsLineSegment().isPointOnLineSegment(point);
    }


    public static boolean isPointNotBetweenVectorEndPoints(Vector x, Point point)
    {
        return !isPointBetweenVectorEndPoints(x, point);
    }


    public static Pair<Vector, Vector> divideVectorWithRatio(Vector x, ANumber ratio)
    {
        return DivideVectorWithRatioTask.run(x, ratio);
    }


    public static Point getMidpoint(Vector x)
    {
        return GetMidpointOfVectorTask.run(x);
    }


    public static Matrix convertToMatrix(Vector x)
    {
        return ConvertVectorToMatrixTask.run(x);
    }


    public static int getLengthOfLongestIncreasingSubsequence(Vector x)
    {
        return GetLengthOfLongestIncreasingSubsequenceInVectorTask.run(x);
    }


    public static int getLengthOfLongestStrictlyIncreasingSubsequence(Vector x)
    {
        return GetLengthOfLongestStrictlyIncreasingSubsequenceInVectorTask.run(x);
    }


    public static int getLengthOfLongestDecreasingSubsequence(Vector x)
    {
        return GetLengthOfLongestDecreasingSubsequenceInVectorTask.run(x);
    }


    public static int getLengthOfLongestStrictlyDecreasingSubsequence(Vector x)
    {
        return GetLengthOfLongestStrictlyDecreasingSubsequenceInVectorTask.run(x);
    }


    public static int getLengthOfLongestStableSubsequence(Vector x)
    {
        return GetLengthOfLongestStableSubsequenceInVectorTask.run(x);
    }


    public static int getFirstIndexOfMinimum(Vector x)
    {
        return GetFirstIndexOfMinimumVectorElementTask.run(x);
    }


    public static int getLastIndexOfMinimum(Vector x)
    {
        return GetLastIndexOfMinimumVectorElementTask.run(x);
    }


    public static ANumber getMinimum(Vector x)
    {
        VectorRules.isValid(x);
        return x.get(getFirstIndexOfMinimum(x));
    }


    public static int getFirstIndexOfMaximum(Vector x)
    {
        return GetFirstIndexOfMaximumVectorElementTask.run(x);
    }


    public static int getLastIndexOfMaximum(Vector x)
    {
        return GetLastIndexOfMaximumVectorElementTask.run(x);
    }


    public static ANumber getMaximum(Vector x)
    {
        VectorRules.isValid(x);
        return x.get(getFirstIndexOfMaximum(x));
    }


    public static ANumber getNorm(Vector x)
    {
        return getNorm(x, Precision.precision);
    }


    public static ANumber getNorm(Vector x, int precision)
    {
        VectorRules.isValid(x);
        return x.getMagnitude(precision);
    }


    public static ANumber getNormInfinitum(Vector x)
    {
        VectorRules.isValid(x);
        return ArithmeticService.getMaximum(VectorService.getAbsoluteValues(x).getAsArray());
    }


    public static Vector getAbsoluteValues(Vector x)
    {
        return GetAbsoluteValuesOfVectorElementsTask.run(x);
    }


    public static Vector getCumulativeSum(Vector x)
    {
        return GetVectorCumulativeSumOfVectorElementsTask.run(x);
    }


    public static Vector getCumulativeProduct(Vector x)
    {
        return GetCumulativeProductOfVectorElementsTask.run(x);
    }


    public static Vector getReverseCumulativeSum(Vector x)
    {
        return GetReverseCumulativeSumOfVectorElementsTask.run(x);
    }


    public static Vector getReverseCumulativeProduct(Vector x)
    {
        return GetReverseCumulativeProductOfVectorElementsTask.run(x);
    }


    public static Vector getDifferencesBetweenSuccessiveElements(Vector x)
    {
        return GetDifferencesBetweenSuccessiveElementsOfVectorTask.run(x);
    }


    public static boolean areAtEquilibrium(Vector... vectors)
    {
        return AreVectorsAtEquilibriumTask.run(vectors);
    }


    public static Pair<Vector, Vector> sortAndMapTogether(Vector x, Vector y)
    {
        return SortAndMap2VectorsTogetherTask.run(x, y);
    }


    public static Vector normaliseFrom0To1(Vector x)
    {
        return NormaliseVectorFrom0To1Task.run(x);
    }


    public static List<ANumber> flattenVectors(List<Vector> vectors)
    {
        return FlattenVectorsTask.run(vectors);
    }


    public static List<ANumber> getTheFirstNLargestElementsSorted(Vector x, int n)
    {
        return GetTheFirstNLargestVectorElementsTask.run(x, n);
    }


    public static List<ANumber> getTheFirstNSmallestElementsSorted(Vector x, int n)
    {
        return GetTheFirstNSmallestVectorElementsTask.run(x, n);
    }


    public static List<Integer> getIndicesOfOccurenceOfElement(Vector x, ANumber element)
    {
        return GetIndicesOfOccurenceOfVectorElementTask.run(x, element);
    }
}