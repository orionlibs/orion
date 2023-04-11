package com.orion.math.streams;

import com.orion.core.data.structure.array.ArrayRules;
import com.orion.core.object.CloningService;
import com.orion.core.stream.OrionArrays;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberArrayStream extends OrionArrays implements MathObject
{
    private Stream<ANumber> stream;


    public NumberArrayStream(Stream<ANumber> stream)
    {
        this.stream = stream;
    }


    public NumberArrayStream(ANumber[] array)
    {
        ArrayRules.isValid(array);
        this.stream = Arrays.stream(array);
    }


    public static NumberArrayStream of(Stream<ANumber> stream)
    {
        return new NumberArrayStream(stream);
    }


    public static NumberArrayStream of(ANumber[] array)
    {
        return new NumberArrayStream(array);
    }


    @SuppressWarnings("unchecked")
    public static Stream<ANumber>[] of(ANumber[][] array)
    {
        ArrayRules.isValid(array);
        Stream<ANumber>[] streams = new Stream[array.length];
        IntStream.range(0, array.length).forEach(i -> streams[i] = Arrays.stream(array[i]));
        return streams;
    }


    public NumberArrayStream filter(Predicate<ANumber> predicate)
    {
        return NumberArrayStream.of(stream.filter(predicate));
    }


    public void forAll(Consumer<ANumber> action)
    {
        stream.forEach(action);
    }


    public static void negateAll(ANumber[] array)
    {
        ArrayRules.isValid(array);

        for(int i = 0; i < array.length; i++)
        {
            array[i] = array[i].negateGET();
        }

    }


    public static void setValues(ANumber[][] array, List<Vector> vectors)
    {
        ArrayRules.isValid(array);

        for(int i = 0; i < array.length; i++)
        {

            for(int j = 0; j < array[0].length; j++)
            {
                array[i][j] = vectors.get(i).get(j).getCopy();
            }

        }

    }


    public static void setValues(ANumber[][] array, Vector vector, int columnToSet)
    {
        ArrayRules.isValid(array);
        IntStream.range(0, vector.getSize()).forEach(i -> array[i][columnToSet] = vector.get(i).getCopy());
    }


    public static void setValues(Function1x1<ANumber, ANumber>[][] array, VectorOfFunction1x1 vector, int columnToSet)
    {
        ArrayRules.isValid(array);
        IntStream.range(0, vector.getSize()).forEach(i -> array[i][columnToSet] = vector.get(i));
    }


    public static void setValues(Object[][] array, GenericVector vector, int columnToSet)
    {
        ArrayRules.isValid(array);
        IntStream.range(0, vector.getSize()).forEach(i -> array[i][columnToSet] = CloningService.clone(vector.get(i)));
    }


    public static void setValue(ANumber[][] array, ANumber x)
    {
        ArrayRules.isValid(array);

        for(int i = 0; i < array.length; i++)
        {

            for(int j = 0; j < array[0].length; j++)
            {
                array[i][j] = x.getCopy();
            }

        }

    }


    public static void setValue(ANumber[] array, ANumber x)
    {
        ArrayRules.isValid(array);

        for(int i = 0; i < array.length; i++)
        {
            array[i] = x.getCopy();
        }

    }


    public static void setZeroValue(ANumber[][] array)
    {
        setValue(array, ANumber.of(0));
    }


    public static void setZeroValue(ANumber[] array)
    {
        setValue(array, ANumber.of(0));
    }


    public static boolean hasZeroValues(ANumber[] array)
    {
        NumberRules.areNotNull(array);

        if(array != null && array.length > 0)
        {

            for(int i = 0; i < array.length; i++)
            {

                if(array[i].isNotZero())
                {
                    return false;
                }

            }

        }

        return true;
    }


    public static double[] getAsDoubleArray(ANumber[] array)
    {
        NumberRules.areNotNull(array);
        double[] result = new double[array.length];
        IntStream.range(0, array.length).forEach(i -> result[i] = array[i].getAsDouble());
        return result;
    }


    public static double[][] getAsDoubleMatrix(ANumber[][] array)
    {
        IntStream.range(0, array.length).forEach(i -> NumberRules.areNotNull(array[i]));
        double[][] result = new double[array.length][array[0].length];

        for(int i = 0; i < array.length; i++)
        {

            for(int j = 0; j < array[0].length; j++)
            {
                result[i][j] = array[i][j].getAsDouble();
            }

        }

        return result;
    }


    public static ANumber[] getAsNumberArray(double[] array)
    {
        ANumber[] result = new ANumber[array.length];
        IntStream.range(0, array.length).forEach(i -> result[i] = ANumber.of(array[i]));
        return result;
    }


    public static ANumber[][] getAsNumberMatrix(double[][] array)
    {
        ANumber[][] result = new ANumber[array.length][array[0].length];

        for(int i = 0; i < array.length; i++)
        {

            for(int j = 0; j < array[0].length; j++)
            {
                result[i][j] = ANumber.of(array[i][j]);
            }

        }

        return result;
    }


    public List<ANumber> getAsList()
    {
        return stream.collect(Collectors.toList());
    }


    public static void setValue(Function1x1<ANumber, ANumber>[][] array, Function1x1<ANumber, ANumber> x)
    {
        ArrayRules.isValid(array);

        for(int i = 0; i < array.length; i++)
        {

            for(int j = 0; j < array[0].length; j++)
            {
                array[i][j] = x;
            }

        }

    }
}