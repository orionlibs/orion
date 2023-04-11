package com.orion.glue.core.comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.orion.core.comparator.ReverseCompareToService;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.java.en.When;

public class ReverseCompareToServiceSteps
{
    private final CucumberStepsWorld stepsWorld;


    public ReverseCompareToServiceSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @SuppressWarnings("rawtypes")
    @When("^reverse compare strings \"(.*)\" and \"(.*)\" to be equal$")
    public void whenReverseCompareStringsToBeEqual(String x, String y)
    {
        assertTrue(new ReverseCompareToService().<String>compareTo(x, y) != 0);
    }


    @When("^reverse compare strings \"(.*)\" and \"(.*)\" to be unequal$")
    public void whenReverseCompareStringsToBeUnequal(String x, String y)
    {
        assertEquals(0, new ReverseCompareToService().<String>compareTo(x, y));
    }
}