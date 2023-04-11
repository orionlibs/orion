package com.orion.glue.core.comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.orion.core.comparator.CompareToService;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.java.en.When;

public class CompareToServiceSteps
{
    private final CucumberStepsWorld stepsWorld;


    public CompareToServiceSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @When("^compare strings \"(.*)\" and \"(.*)\" to be equal$")
    public void whenCompareStringsToBeEqual(String x, String y)
    {
        assertEquals(0, CompareToService.<String>compareTo(x, y));
    }


    @When("^compare strings \"(.*)\" and \"(.*)\" to be unequal$")
    public void whenCompareStringsToBeUnequal(String x, String y)
    {
        assertTrue(CompareToService.<String>compareTo(x, y) != 0);
    }
}