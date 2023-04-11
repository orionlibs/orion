package com.orion.glue.core.content;

import static org.junit.Assert.assertEquals;

import com.orion.core.content.Pagination;
import com.orion.testing.cucumber.glue.steps.CucumberStepsWorld;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PaginationSteps
{
    private final CucumberStepsWorld stepsWorld;
    private int numberOfElements;
    private int paginationLimit;


    public PaginationSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;
    }


    @Given("^pagination has (\\d+) elements and page limit of (\\d+)$")
    public void givenPaginationHasElementsAndPageLimit(int numberOfElements, int paginationLimit)
    {
        this.numberOfElements = numberOfElements;
        this.paginationLimit = paginationLimit;
    }


    @Then("^total number of pages for pagination is (\\d+)$")
    public void thenTotalNumberOfPagesForPaginationIs(int expectedNumberOfPages)
    {
        assertEquals(expectedNumberOfPages, Pagination.getTotalNumberOfPages(numberOfElements, paginationLimit));
    }
}