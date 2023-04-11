package com.orion.math.function;

import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.runnable.functions.OrionFunction;
import com.orion.math.MathRule;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain;
import com.orion.math.function.domain.FunctionDomain2x1;
import com.orion.math.function.domain.FunctionDomain3x1;
import com.orion.math.function.domain.FunctionDomain4x1;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import com.orion.math.polynomial.Polynomials;
import java.util.Arrays;
import java.util.List;

public class FunctionRules extends MathRule
{
    public static void areIndicesOfVariableThatIsConstantValid(int indexOfVariableThatIsConstant1, int indexOfVariableThatIsConstant2)
    {
        Assert.areNotEqual(indexOfVariableThatIsConstant1, indexOfVariableThatIsConstant2, "Indices of variables that are constant ae the same.");
    }


    public static void areIndicesOfVariableThatIsConstantValid(int indexOfVariableThatIsConstant1, int indexOfVariableThatIsConstant2, int indexOfVariableThatIsConstant3)
    {
        Assert.areNotEqual(indexOfVariableThatIsConstant1, indexOfVariableThatIsConstant2, "Indices of variables that are constant ae the same.");
        Assert.areNotEqual(indexOfVariableThatIsConstant1, indexOfVariableThatIsConstant3, "Indices of variables that are constant ae the same.");
        Assert.areNotEqual(indexOfVariableThatIsConstant2, indexOfVariableThatIsConstant3, "Indices of variables that are constant ae the same.");
    }


    public static void isValid(PolynomialFunction f)
    {
        Assert.notNull(f, "The PolynomialFunction input cannot be null.");
        Assert.isFalse(Polynomials.isNotValid(f.getPolynomial()), "The PolynomialFunction input cannot be null.");
    }


    public static void isValid(PolynomialFunction numerator, PolynomialFunction denominator)
    {
        isValid(numerator);
        isValid(denominator);
    }


    public static void isValid(OrionFunction f)
    {
        Assert.notNull(f, "The Function input cannot be null.");
    }


    public static void isValid(OrionFunction f, FunctionDomain domain, FunctionCodomain codomain)
    {
        Assert.notNull(f, "The Function input cannot be null.");
        Assert.notNull(domain, "The domain input cannot be null.");
        Assert.notNull(codomain, "The codomain input cannot be null.");
    }


    public static void isValid(OrionFunction f, int orderOfBernsteinPolynomial)
    {
        isValid(f);
        Assert.isGreaterOrEqualTo(orderOfBernsteinPolynomial, 1, "the order of the Bernstein polynomial has to be at least 1.");
    }


    public static void isValid(Function f)
    {
        Assert.notNull(f, "The Function input cannot be null.");
    }


    public static void isValidDomain(FunctionDomain2x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable1(), "The interval for the function domain of variable 1 cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable2(), "The interval for the function domain of variable 2 cannot be null.");
    }


    public static void isValidDomainForVariable1(FunctionDomain2x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable1(), "The interval for the function domain of variable 1 cannot be null.");
    }


    public static void isValidDomainForVariable2(FunctionDomain2x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable2(), "The interval for the function domain of variable 2 cannot be null.");
    }


    public static void isValidDomainForVariable1(FunctionDomain3x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable1(), "The interval for the function domain of variable 1 cannot be null.");
    }


    public static void isValidDomainForVariable2(FunctionDomain3x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable2(), "The interval for the function domain of variable 2 cannot be null.");
    }


    public static void isValidDomainForVariable3(FunctionDomain3x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable3(), "The interval for the function domain of variable 3 cannot be null.");
    }


    public static void isValidDomainForVariable1(FunctionDomain4x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable1(), "The interval for the function domain of variable 1 cannot be null.");
    }


    public static void isValidDomainForVariable2(FunctionDomain4x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable2(), "The interval for the function domain of variable 2 cannot be null.");
    }


    public static void isValidDomainForVariable3(FunctionDomain4x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable3(), "The interval for the function domain of variable 3 cannot be null.");
    }


    public static void isValidDomainForVariable4(FunctionDomain4x1 domain)
    {
        Assert.notNull(domain, "The Function domain cannot be null.");
        Assert.notNull(domain.getIntervalOfVariable4(), "The interval for the function domain of variable 4 cannot be null.");
    }


    public static void isValid(Function f, int orderOfBernsteinPolynomial)
    {
        isValid(f);
        Assert.isGreaterOrEqualTo(orderOfBernsteinPolynomial, 1, "the order of the Bernstein polynomial has to be at least 1.");
    }


    public static void isValid(OrionFunction f, boolean[] indicesOfVariablesThatAreConstants, int numberOfVariables)
    {
        isValid(f);
        Assert.notNull(indicesOfVariablesThatAreConstants, "The Function input cannot be null.");
        Assert.hasLength(indicesOfVariablesThatAreConstants, numberOfVariables, "The Function input cannot be null.");
    }


    public static void isValid(Function f, boolean[] indicesOfVariablesThatAreConstants, int numberOfVariables)
    {
        isValid(f);
        Assert.notNull(indicesOfVariablesThatAreConstants, "The Function input cannot be null.");
        Assert.hasLength(indicesOfVariablesThatAreConstants, numberOfVariables, "The Function input cannot be null.");
    }


    public static void isValid(Function f, int indexOfVariableThatIsConstant, int numberOfVariables)
    {
        isValid(f);
        Assert.isFalse(Numbers.isNotBetween(indexOfVariableThatIsConstant, 0, numberOfVariables), "The Function input cannot be null.");
    }


    public static void isValid(OrionFunction f, int indexOfVariableThatIsConstant, int numberOfVariables)
    {
        isValid(f);
        Assert.isFalse(Numbers.isNotBetween(indexOfVariableThatIsConstant, 0, numberOfVariables), "The Function input cannot be null.");
    }


    public static void areValid(OrionFunction... functions)
    {
        Assert.notEmpty(functions, "The functions input cannot be null/empty.");
        Arrays.stream(functions).forEach(f -> isValid(f));
    }


    public static void areValid(List<OrionFunction> functions)
    {
        Assert.notEmpty(functions, "The functions input cannot be null/empty.");
        functions.stream().forEach(f -> isValid(f));
    }


    public static void areValid(Function... functions)
    {
        Assert.notEmpty(functions, "The functions input cannot be null/empty.");
        Arrays.stream(functions).forEach(f -> isValid(f));
    }


    public static void areValidFunctions(List<Function> functions)
    {
        Assert.notEmpty(functions, "The functions input cannot be null/empty.");
        functions.stream().forEach(f -> isValid(f));
    }


    public static void areValidFunctions1x1(List<Function1x1<ANumber, ANumber>> functions)
    {
        Assert.notEmpty(functions, "The functions input cannot be null/empty.");
        functions.stream().forEach(f -> isValid(f));
    }


    public static void doNumberOfVariablesMatch(Function... functions)
    {
        areValid(functions);
        int numberOfVariables = functions[0].getNumberOfVariables();

        for(int i = 1; i < functions.length; i++)
        {

            if(functions[i].getNumberOfVariables() != numberOfVariables)
            {
                throw new InvalidArgumentException("The number of variables do not match for all functions.");
            }

        }

    }
}