package com.orion.math.function;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.function.domain.FunctionDomain2x1;
import com.orion.math.function.domain.FunctionDomain3x1;
import com.orion.math.function.domain.FunctionDomain4x1;

public class FunctionBoundaryRules extends MathRule
{
    public static void isValid(FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        Assert.notNull(domain, "The domain input cannot be null.");
        Assert.notNull(codomain, "The codomain input cannot be null.");
        Assert.isTrue(domain.getIntervalOfVariable1() != null || (domain.getAllowedValuesForVariable1() != null && !domain.getAllowedValuesForVariable1().isEmpty()), "The domain's interval or allowedValuesForVariable1 has to exist.");
        Assert.isTrue(codomain.getInterval() != null || (codomain.getAllowedYValues() != null && !codomain.getAllowedYValues().isEmpty()), "The codomain's interval or allowedYValues has to exist.");
    }


    public static void isValid(FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        Assert.notNull(domain, "The domain input cannot be null.");
        Assert.notNull(codomain, "The codomain input cannot be null.");
        Assert.isTrue(domain.getIntervalOfVariable1() != null || (domain.getAllowedValuesForVariable1() != null && !domain.getAllowedValuesForVariable1().isEmpty()), "The domain's interval or allowedValuesForVariable1 has to exist.");
        Assert.isTrue(domain.getIntervalOfVariable2() != null || (domain.getAllowedValuesForVariable2() != null && !domain.getAllowedValuesForVariable2().isEmpty()), "The domain's interval or allowedValuesForVariable2 has to exist.");
        Assert.isTrue(codomain.getInterval() != null || (codomain.getAllowedYValues() != null && !codomain.getAllowedYValues().isEmpty()), "The codomain's interval or allowedYValues has to exist.");
    }


    public static void isValid(FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        Assert.notNull(domain, "The domain input cannot be null.");
        Assert.notNull(codomain, "The codomain input cannot be null.");
        Assert.isTrue(domain.getIntervalOfVariable1() != null || (domain.getAllowedValuesForVariable1() != null && !domain.getAllowedValuesForVariable1().isEmpty()), "The domain's interval or allowedValuesForVariable1 has to exist.");
        Assert.isTrue(domain.getIntervalOfVariable2() != null || (domain.getAllowedValuesForVariable2() != null && !domain.getAllowedValuesForVariable2().isEmpty()), "The domain's interval or allowedValuesForVariable2 has to exist.");
        Assert.isTrue(domain.getIntervalOfVariable3() != null || (domain.getAllowedValuesForVariable3() != null && !domain.getAllowedValuesForVariable3().isEmpty()), "The domain's interval or allowedValuesForVariable3 has to exist.");
        Assert.isTrue(codomain.getInterval() != null || (codomain.getAllowedYValues() != null && !codomain.getAllowedYValues().isEmpty()), "The codomain's interval or allowedYValues has to exist.");
    }


    public static void isValid(FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        Assert.notNull(domain, "The domain input cannot be null.");
        Assert.notNull(codomain, "The codomain input cannot be null.");
        Assert.isTrue(domain.getIntervalOfVariable1() != null || (domain.getAllowedValuesForVariable1() != null && !domain.getAllowedValuesForVariable1().isEmpty()), "The domain's interval or allowedValuesForVariable1 has to exist.");
        Assert.isTrue(domain.getIntervalOfVariable2() != null || (domain.getAllowedValuesForVariable2() != null && !domain.getAllowedValuesForVariable2().isEmpty()), "The domain's interval or allowedValuesForVariable2 has to exist.");
        Assert.isTrue(domain.getIntervalOfVariable3() != null || (domain.getAllowedValuesForVariable3() != null && !domain.getAllowedValuesForVariable3().isEmpty()), "The domain's interval or allowedValuesForVariable3 has to exist.");
        Assert.isTrue(domain.getIntervalOfVariable4() != null || (domain.getAllowedValuesForVariable4() != null && !domain.getAllowedValuesForVariable4().isEmpty()), "The domain's interval or allowedValuesForVariable4 has to exist.");
        Assert.isTrue(codomain.getInterval() != null || (codomain.getAllowedYValues() != null && !codomain.getAllowedYValues().isEmpty()), "The codomain's interval or allowedYValues has to exist.");
    }
}