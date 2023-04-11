package com.orion.glue.core.comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.orion.core.comparator.NumberComparator;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.java.en.When;
import java.math.BigDecimal;

public class NumberComparatorSteps
{
    private final CucumberStepsWorld stepsWorld;


    public NumberComparatorSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @When("^compare numbers \"(.*)\" and \"(.*)\" to be equal$")
    public void whenCompareNumbersToBeEqual(String x, String y)
    {
        assertEquals(0, new NumberComparator().compare(new BigDecimal(x), new BigDecimal(y)));
    }


    @When("^compare numbers \"(.*)\" and \"(.*)\" to be unequal$")
    public void whenCompareNumbersToBeUnequal(String x, String y)
    {
        assertTrue(new NumberComparator().compare(new BigDecimal(x), new BigDecimal(y)) != 0);
    }
}