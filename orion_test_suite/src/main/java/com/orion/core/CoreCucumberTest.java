package com.orion.core;

import io.cucumber.java.BeforeAll;
// import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;

// @RunWith(Cucumber.class)
@Cucumber
@CucumberOptions(glue =
{
                "com.orion.testing.cucumber",
                "com.orion.glue"}, features = "src/test/resources/com/orion/core")
public class CoreCucumberTest
{
    @BeforeAll
    public static void setUp()
    {
        System.setProperty("spring.profiles.active", "testing");
    }
}