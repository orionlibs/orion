package com.orion.glue.core.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.orion.core.cache.Cache;
import com.orion.testing.cucumber.CucumberService;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

public class CacheSteps
{
    private final CucumberStepsWorld stepsWorld;
    private Cache<String, String> cache;


    public CacheSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @Given("^cache entries$")
    public void givenCacheEntries(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);
        cache = Cache.of();
        //stepsWorld.resetForNewScenarioRun();

        for(Map<String, String> row : rows)
        {
            String key = CucumberService.getCellValue(row, "keys");
            String value = CucumberService.getCellValue(row, "values");
            cache.addEntry(key, value);
        }

    }


    @When("^add cache entries$")
    public void whenAddCacheEntries(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);

        for(Map<String, String> row : rows)
        {
            String key = CucumberService.getCellValue(row, "keys");
            String value = CucumberService.getCellValue(row, "values");
            cache.addEntry(key, value);
        }

    }


    @When("^delete cache entries with keys$")
    public void whenDeleteCacheEntriesWithKeys(List<String> input)
    {

        for(String element : input)
        {
            cache.deleteEntry(element);
        }

    }


    @Then("^cache size is (\\d+)$")
    public void thenCacheSizeIs(int expectedCacheSize)
    {
        assertEquals(expectedCacheSize, cache.getSize());
    }
}