package com.orion.math.conversion;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.stream.OrionStream;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.point.polar.PolarPoint;
import com.orion.math.geometry.point.polar.PolarPointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.graph.Graph;
import com.orion.math.graph.GraphRules;
import com.orion.math.graph.tree.Tree;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.fraction.Fraction;
import com.orion.math.set.SetRules;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class ConversionService extends OrionService
{
    public static BigInteger getAsBigInteger(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getAsInteger();
    }


    public static BigDecimal getAsBigDecimal(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.get();
    }


    public static BigInteger getImaginaryValueAsBigInteger(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getImaginaryValueAsBigInteger();
    }


    public static BigDecimal getImaginaryValueAsBigDecimal(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getImaginaryValue();
    }


    public static Fraction getAsFraction(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getAsFraction();
    }


    public static int getAsInt(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getAsInt();
    }


    public static double getAsDouble(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getAsDouble();
    }


    public static PolarPoint getAsPolarPoint(Point x)
    {
        PointRules.isValid(x);
        return x.getAsPolarPoint();
    }


    public static Point getAsPoint(PolarPoint x)
    {
        PolarPointRules.isValid(x);
        return x.getAsPoint();
    }


    public static Line getAsLine(LineSegment x)
    {
        LineSegmentRules.isValid(x);
        return x.getLine();
    }


    public static ANumber[] getAsArray(Vector x)
    {
        VectorRules.isValid(x);
        return x.getAsArray();
    }


    public static Vector getAsVector(ANumber[] x)
    {
        return Vector.of(x);
    }


    public static List<ANumber> getAsList(Vector x)
    {
        VectorRules.isValid(x);
        return x.getAsList();
    }


    public static Vector getAsVector(List<ANumber> x)
    {
        return Vector.of(x);
    }


    public static List<String> getAsStrings(Vector x)
    {
        VectorRules.isValid(x);
        return OrionStream.getAsList(x.getAsList().stream().map(e -> e.toString()));
    }


    public static Vector getAsVector(String[] x)
    {
        return Vector.of(x);
    }


    public static Matrix getAsRowMatrix(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[][] elements = new ANumber[1][];
        elements[0] = x.getElements().getAsArray();
        return Matrix.of(elements);
    }


    public static Matrix getAsColumnMatrix(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[][] elements = new ANumber[x.getDimensions()][1];
        IntStream.range(0, x.getDimensions()).forEach(i -> elements[i][0] = x.getCopy(i));
        return Matrix.of(elements);
    }


    public static Set<ANumber> getAsHashSet(Vector x)
    {
        VectorRules.isValid(x);
        return x.getAsHashSet();
    }


    public static OrionList<ANumber> getAsOrionList(Vector x)
    {
        VectorRules.isValid(x);
        return x.getAsOrionList();
    }


    public static Tree getAsTree(Graph x)
    {
        GraphRules.isValid(x);
        return Tree.of(x.getVerticesCopy(), x.getEdgesCopy());
    }


    public static ANumber[][] getAsArrayOfArrays(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.getAsArrayOfArrays();
    }


    public static List<ANumber> getAsList(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.getAsList();
    }


    public static OrionList<ANumber> getAsOrionList(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.getAsOrionList();
    }


    public static Vector getAsVector(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.getAsVector();
    }


    public static List<ANumber> getAsList(com.orion.math.set.Set x)
    {
        SetRules.isValid(x);
        return x.getAsList();
    }


    public static OrionList<ANumber> getAsOrionList(com.orion.math.set.Set x)
    {
        SetRules.isValid(x);
        return x.getAsOrionList();
    }
}