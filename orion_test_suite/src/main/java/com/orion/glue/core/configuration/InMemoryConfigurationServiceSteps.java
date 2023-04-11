package com.orion.glue.core.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.testing.cucumber.CucumberService;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

public class InMemoryConfigurationServiceSteps
{
    private final CucumberStepsWorld stepsWorld;


    public InMemoryConfigurationServiceSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @Given("^in-memory configuration entries$")
    public void givenAddInMemoryConfigurationEntries(DataTable input)
    {
        addEntriesToInMemoryConfiguration(input);
    }


    @When("^add in-memory configuration entries$")
    public void whenAddInMemoryConfigurationEntries(DataTable input)
    {
        addEntriesToInMemoryConfiguration(input);
    }


    @When("^update in-memory configuration entries$")
    public void whenUpdateInMemoryConfigurationEntries(DataTable input)
    {
        updateEntriesToInMemoryConfiguration(input);
    }


    @When("^delete in-memory configuration entries with keys$")
    public void whenDeleteInMemoryConfigurationEntriesWithKeys(List<String> input)
    {

        for(String element : input)
        {
            InMemoryConfigurationService.deleteProp(element);
        }

    }


    @Then("^in-memory configuration size is at least (\\d+)$")
    public void thenInMemoryConfigurationSizeIsAtLeast(int expectedSize)
    {
        assertTrue(InMemoryConfigurationService.getNumberOfConfigurationProperties() >= expectedSize);
    }


    @Then("^in-memory configuration value for key \"(.*)\" is \"(.*)\"$")
    public void thenInMemoryConfigurationValueForKeyIs(String key, String value)
    {
        assertEquals(value, InMemoryConfigurationService.getProp(key));
    }


    private void addEntriesToInMemoryConfiguration(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);

        for(Map<String, String> row : rows)
        {
            String key = CucumberService.getCellValue(row, "keys");
            String value = CucumberService.getCellValue(row, "values");
            InMemoryConfigurationService.registerProp(key, value);
        }

    }


    private void updateEntriesToInMemoryConfiguration(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);

        for(Map<String, String> row : rows)
        {
            String key = CucumberService.getCellValue(row, "keys");
            String value = CucumberService.getCellValue(row, "values");
            InMemoryConfigurationService.updateProp(key, value);
        }

    }
}