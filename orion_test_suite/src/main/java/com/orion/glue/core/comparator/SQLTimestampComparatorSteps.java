package com.orion.glue.core.comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.orion.core.comparator.SQLTimestampComparator;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.java.en.When;
import java.sql.Timestamp;

public class SQLTimestampComparatorSteps
{
    private final CucumberStepsWorld stepsWorld;


    public SQLTimestampComparatorSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @When("^compare SQL timestamps with time in milliseconds (.*) and (.*) to be equal$")
    public void whenCompareNumbersToBeEqual(long x, long y)
    {
        Timestamp timestamp1 = new Timestamp(x);
        Timestamp timestamp2 = new Timestamp(y);
        assertEquals(0, new SQLTimestampComparator().compare(timestamp1, timestamp2));
    }


    @When("^compare SQL timestamps with time in milliseconds (.*) and (.*) to be unequal$")
    public void whenCompareNumbersToBeUnequal(long x, long y)
    {
        Timestamp timestamp1 = new Timestamp(x);
        Timestamp timestamp2 = new Timestamp(y);
        assertTrue(new SQLTimestampComparator().compare(timestamp1, timestamp2) != 0);
    }
}