package com.orion.testing.cucumber.glue.steps.common;

import com.orion.testing.OrionTestingBase;
import com.orion.testing.cucumber.CucumberAPICall;
import com.orion.testing.cucumber.CucumberAPICallHeader;
import com.orion.testing.cucumber.CucumberService;
import com.orion.testing.cucumber.glue.steps.internal.CucumberStepsWorld;
import com.orion.web.core.cookie.CookieService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseCookie;

public class APICucumberSteps
{
    private final CucumberStepsWorld stepsWorld;


    public APICucumberSteps(CucumberStepsWorld stepsWorld)
    {
        this.stepsWorld = stepsWorld;

        if(stepsWorld.apiCall == null)
        {
            stepsWorld.apiCall = new CucumberAPICall();
        }

    }


    @When("^API call has headers$")
    public void whenAPICallHasHeaders(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);
        List<CucumberAPICallHeader> httpHeaders = new ArrayList<>();

        for(Map<String, String> row : rows)
        {
            String key = CucumberService.getCellValue(row, "name");
            String value = CucumberService.getCellValue(row, "value");
            httpHeaders.add(CucumberAPICallHeader.builder()
                            .name(key)
                            .value(value)
                            .build());
        }

        stepsWorld.apiCall.httpHeaders = httpHeaders;
    }


    @When("^API call has JSON request body \"(.*)\"$")
    public void whenAPICallHasJSONRequestBody(String input)
    {
        stepsWorld.apiCall.jsonRequestBody = input;
    }


    @When("^API call has cookies$")
    public void whenAPICallHasCookies(DataTable input)
    {
        Map<String, String> rows = input.asMap(String.class, String.class);

        if(rows != null && !rows.isEmpty())
        {
            List<ResponseCookie> cookies = new ArrayList<>();

            for(Map.Entry<String, String> entry : rows.entrySet())
            {
                cookies.add(CookieService.createCookie(entry.getKey(), entry.getValue()));
            }

            if(stepsWorld.apiCall.cookies != null)
            {
                stepsWorld.apiCall.cookies.addAll(cookies);
            }
            else
            {
                stepsWorld.apiCall.cookies = cookies;
            }

        }

    }


    @When("^API call has access cookie for default userID$")
    public void whenAPICallHasAccessCookieForDefaultUserID()
    {
        List<ResponseCookie> cookies = new ArrayList<>();
        cookies.add(OrionTestingBase.getJWTCookieForDefaultUser());

        if(stepsWorld.apiCall.cookies != null)
        {
            stepsWorld.apiCall.cookies.addAll(cookies);
        }
        else
        {
            stepsWorld.apiCall.cookies = cookies;
        }

    }


    @When("^API is reset$")
    public void whenAPIIsReset()
    {
        stepsWorld.apiCall.httpHeaders = null;
        stepsWorld.apiCall.apiCallDetails = null;
        stepsWorld.apiCall.jsonRequestBody = null;
        stepsWorld.apiCall.cookies = null;
        stepsWorld.apiCall.requestParameters = null;
    }


    @When("^making API call$")
    public void whenMakingAPICall()
    {
        stepsWorld.makeAPICall();
    }


    @Then("^making API call responds with \"(.*)\"$")
    public void thenMakingAPICallRespondsWithStatus(String expectedResponseHTTPStatusCode)
    {
        stepsWorld.makeAPICallAndVerifyResponseStatusCode(expectedResponseHTTPStatusCode);
    }


    @Then("^API call responds with code \"(.*)\"$")
    public void thenAPICallRespondsWithStatusCode(String expectedResponseHTTPStatusCode)
    {
        stepsWorld.verifyAPICallResponseStatusCode(expectedResponseHTTPStatusCode);
    }


    @Then("^API call response includes non-empty fields$")
    public void thenAPICallResponseIncludesNonEmptyFields(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);
        List<String> expectedNonEmptyFields = new ArrayList<>();

        for(Map<String, String> row : rows)
        {
            expectedNonEmptyFields.add(CucumberService.getCellValue(row, "field name"));
        }

        stepsWorld.verifyAPICallResponseIncludesNonEmptyFields(expectedNonEmptyFields);
    }


    @Then("^API call response includes field \"(.*)\" with value starting with \"(.*)\"$")
    public void thenAPICallResponseIncludesFieldWithValueStartingWith(String field, String valuePrefix)
    {
        stepsWorld.verifyAPICallResponseIncludesFieldsWithValueStartingWith(field, valuePrefix);
    }


    @Then("^API call response includes field \"(.*)\" with value containing \"(.*)\"$")
    public void thenAPICallResponseIncludesFieldWithValueContaining(String field, String valueInfix)
    {
        stepsWorld.verifyAPICallResponseIncludesFieldsWithValueContaining(field, valueInfix);
    }


    @Then("^API call response includes field \"(.*)\" with value \"(.*)\"$")
    public void thenAPICallResponseIncludesFieldWithValue(String field, String value)
    {
        stepsWorld.verifyAPICallResponseIncludesFieldsWithValue(field, value);
    }


    @Then("^API call response includes fields$")
    public void thenAPICallResponseIncludesFields(DataTable input)
    {
        List<Map<String, String>> rows = input.asMaps(String.class, String.class);
        List<String> expectedFields = new ArrayList<>();

        for(Map<String, String> row : rows)
        {
            expectedFields.add(CucumberService.getCellValue(row, "field name"));
        }

        stepsWorld.verifyAPICallResponseIncludesFields(expectedFields);
    }


    @Then("^API call response is saved in internal mapper with key \"(.*)\"$")
    public void thenAPICallResponseIsSavedInInternalMapperWithKey(String responseKey)
    {
        stepsWorld.keyToAPICallResponseMapper.put(responseKey, stepsWorld.apiCall.apiResponse);
    }
}