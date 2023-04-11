package com.orion.testing.cucumber.glue.steps.common;

import com.orion.data.source.database.Database;
import com.orion.testing.OrionTestingBase;
import com.orion.testing.cucumber.glue.steps.internal.CucumberStepsWorld;
import io.cucumber.java.en.Given;

public class DatabaseCucumberSteps
{
    private final CucumberStepsWorld stepsWorld;
    private final OrionTestingBase testingBase;


    public DatabaseCucumberSteps(CucumberStepsWorld stepsWorld, OrionTestingBase testingBase)
    {
        this.stepsWorld = stepsWorld;
        this.testingBase = testingBase;
    }


    @Given("^MySQL database is loaded$")
    public void givenMySQLDatabaseIsLoaded()
    {
        testingBase.resetDatabase();
    }


    @Given("^MySQL table \"(.*)\" in database \"(.*)\" is truncated$")
    public void givenMySQLTableIsTruncated(String tableToTruncate, String databaseTableBelongsTo)
    {
        Database.truncateTable("." + tableToTruncate, databaseTableBelongsTo);
    }


    @Given("^all MySQL database tables are truncated$")
    public void givenAllMySQLDatabaseTablesAreTruncated()
    {
        testingBase.truncateAllDatabaseTables();
    }


    @Given("^all non-essential MySQL database tables are truncated$")
    public void givenAllNonEssentialMySQLDatabaseTablesAreTruncated()
    {
        testingBase.truncateNonEssentialDatabaseTables();
    }


    @Given("^all user-related MySQL database tables are truncated$")
    public void givenAllUserRelatedMySQLDatabaseTablesAreTruncated()
    {
        testingBase.truncateNonEssentialDatabaseTables();
    }
}